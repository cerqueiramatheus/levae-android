package levae.client.view.cadastroDadosPessoais;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.util.DateInputMask;
import levae.client.core.util.EditTextUtils;
import levae.client.view.cadastro.CadastroActivity;
import levae.client.view.cadastro.CadastroInterface;

public class CadastroDadosPessoaisFragment extends BaseFragment implements CadastroDadosPessoaisInterface.View {

    @BindView(R.id.cadastro_btn_continuar)
    MaterialButton btnContinuar;

    @BindView(R.id.cadastro_et_nascimento)
    TextInputEditText etNascimento;

    @BindView(R.id.cadastro_til_nascimento)
    TextInputLayout tilNascimento;

    @BindView(R.id.cadastro_et_nome)
    TextInputEditText etNome;

    @BindView(R.id.cadastro_til_nome)
    TextInputLayout tilNome;

    @BindView(R.id.cadastro_et_celular)
    TextInputEditText etCelular;

    @BindView(R.id.cadastro_til_celular)
    TextInputLayout tilCelular;

    private CadastroInterface.View mView;

    private CadastroDadosPessoaisInterface.Presenter mPresenter;

    public CadastroDadosPessoaisFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_dados_pessoais, container, false);
        ButterKnife.bind(this, view);
        mView = (CadastroActivity) getActivity();
        new DateInputMask(etNascimento);
        if (mPresenter == null) {
            mPresenter = new CadastroDadosPessoaisPresenter(this);
        }
        return view;
    }

    @OnClick(R.id.cadastro_btn_continuar)
    void continuar() {
        mPresenter.verificaDadosPessoais(
                EditTextUtils.getString(etNome),
                EditTextUtils.getString(etCelular),
                EditTextUtils.getString(etNascimento)
        );
    }

    @Override
    public void onContinuar(String nome, String celular, String nascimento) {
        tilNome.setError("");
        tilCelular.setError("");
        tilNascimento.setError("");
        mView.setDadosPessoais(nome, celular, nascimento);
    }

    @Override
    public void onNomeErro(String msg) {
        tilNome.setError(msg);
    }

    @Override
    public void onCelularErro(String msg) {
        tilCelular.setError(msg);
    }

    @Override
    public void onNascimentoErro(String msg) {
        tilNascimento.setError(msg);
    }

    @Override
    public void setPresenter(CadastroDadosPessoaisInterface.Presenter presenter) {
        mPresenter = presenter;
    }
}