package levae.client.view.pagamentoNovo;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseActivity;

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

    private PagamentoNovoInterface.Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_novo);
        ButterKnife.bind(this);
        new PagamentoNovoPresenter(this);
    }

    @Override
    public void setPresenter(PagamentoNovoInterface.Presenter presenter) {
        mPresenter = presenter;
    }

}