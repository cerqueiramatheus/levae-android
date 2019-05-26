package levae.client.view.cadastro;

import android.os.Bundle;

import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.util.ActivityUtils;
import levae.client.view.cadastroDadosPessoais.CadastroDadosPessoaisFragment;
import levae.client.view.cadastroLoginSenha.CadastroLoginSenhaFragment;

public class CadastroActivity extends BaseActivity implements CadastroInterface.View {

    private CadastroInterface.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getWindow().setEnterTransition(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter == null) mPresenter = new CadastroPresenter(this);

    }

    @Override
    public void setPresenter(CadastroInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void goToDadosPessoais() {
        ActivityUtils.addFragment(getSupportFragmentManager(), new CadastroDadosPessoaisFragment(), R.id.cadastro_layout);
        System.out.println("rodou aqui!!!");
    }

    @Override
    public void setDadosPessoais(String nome, String celular, String nascimento) {
        mPresenter.moveToLoginSenha(nome, celular, nascimento);
    }

    @Override
    public void goToLoginSenha() {
        ActivityUtils.addFragment(getSupportFragmentManager(), new CadastroLoginSenhaFragment(), R.id.cadastro_layout);
    }

    @Override
    public void setLoginSenha(String email, String senha) {
        mPresenter.moveToMain(email, senha);
    }

    @Override
    public void goToMain(Bundle bundle) {

    }

    @Override
    public void setError(String msg) {

    }

}