package levae.client.view.pagamento.pagamentoNovo;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.pagarme.CreditCard;
import levae.client.core.util.CreditCardExpireMask;
import levae.client.core.util.CreditCardWatcher;
import levae.client.core.util.CustomDialog;
import levae.client.core.util.CustomProgressBar;
import levae.client.core.util.EditTextUtils;

public class PagamentoNovoActivity extends BaseActivity implements PagamentoNovoInterface.View {

    @BindView(R.id.pagamento_novo_til_numero)
    TextInputLayout tilNumero;

    @BindView(R.id.pagamento_novo_et_numero)
    TextInputEditText etNumero;

    @BindView(R.id.pagamento_novo_til_cvv)
    TextInputLayout tilCvv;

    @BindView(R.id.pagamento_novo_et_cvv)
    TextInputEditText etCvv;

    @BindView(R.id.pagamento_novo_til_validade)
    TextInputLayout tilValidade;

    @BindView(R.id.pagamento_novo_et_validade)
    TextInputEditText etValidade;

    @BindView(R.id.pagamento_novo_btn_cadastrar)
    MaterialButton btnCadastrar;

    @BindView(R.id.pagamento_novo_layout)
    RelativeLayout mLayout;

    @BindView(R.id.pagamento_novo_web_view)
    WebView webView;

    private CustomProgressBar customProgressBar;

    private CustomDialog customDialog;

    private PagamentoNovoInterface.Presenter mPresenter;

    private boolean isNew;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_novo);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        isNew = getIntent().getExtras() != null && getIntent().getExtras().getBoolean("isNew");

        if (getIntent().getExtras() != null && getIntent().getExtras().getBoolean("isNew")) {
            new PagamentoNovoPresenter(this, getIntent().getExtras());
        } else {
            new PagamentoNovoPresenter(this);
        }

        new CreditCard(this);

        etValidade.addTextChangedListener(new CreditCardExpireMask());
        etNumero.addTextChangedListener(new CreditCardWatcher());

        customProgressBar = new CustomProgressBar(this, mLayout, CustomProgressBar.ProgressBarEnum.HORIZONTAL, false);

    }

    @OnClick(R.id.pagamento_novo_btn_cadastrar)
    public void onCadastrarClick() {
        if (!isNew) {
            EditTextUtils.cleanError(tilCvv, tilNumero, tilValidade);
            if ((mPresenter.validaNumero(etNumero) && (mPresenter.validaValidade(etValidade)) && mPresenter.validaCvv(etCvv))) {
                customProgressBar.show();
                mPresenter.setHash(webView,
                        etValidade.getText().toString(),
                        etCvv.getText().toString(),
                        etNumero.getText().toString());
            }
        } else {
            customDialog = new CustomDialog(this, "deseja realmente excluir o cartão selecionado?", "sim", "não", new CustomDialog.CustomDialogInterface() {
                @Override
                public void onAccepted() {
                    mPresenter.excluir();
                    customDialog.hide();
                    customProgressBar.show();
                }

                @Override
                public void onRefused() {
                    customDialog.hide();
                }
            });
            customDialog.show();
        }
    }

    @Override
    public void setPresenter(PagamentoNovoInterface.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onSuccess(String token) {
        if ((token != null) && (!token.equals("0")) && (!(getIntent().getExtras() != null && getIntent().getExtras().getBoolean("isNew")))) {
            mPresenter.cadastrar(token);
        } else {
            customProgressBar.hide();
            showSnack("cartão inválido");
        }
    }

    @Override
    public void onError() {
        showSnack("cartão inválido");
        customProgressBar.hide();
    }

    @Override
    public void populateItems(Cartao cartao) {
        getSupportActionBar().setTitle(cartao.getSequencia());
        btnCadastrar.setText("excluir");
        etNumero.setText(cartao.getSequencia());
        etNumero.setKeyListener(null);
        etValidade.setText(cartao.getValidade());
        etValidade.setKeyListener(null);
        etCvv.setKeyListener(null);
    }

    @Override
    public void setError(String error) {
        customProgressBar.hide();
        showSnack(error);
    }

    @Override
    public void onFinished() {
        customProgressBar.hide();
        finish();
    }

    @Override
    public void setNumeroError(String erro) {
        EditTextUtils.setError(tilNumero, erro);
    }

    @Override
    public void setCvvError(String erro) {
        EditTextUtils.setError(tilCvv, erro);
    }

    @Override
    public void setValidadeError(String erro) {
        EditTextUtils.setError(tilValidade, erro);
    }
}