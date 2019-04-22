package levae.client.view.cadastro;

import android.os.Bundle;

import levae.client.R;
import levae.client.core.base.BaseActivity;

public class CadastroLoginSenha extends BaseActivity implements CadastroInterface.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login_senha);
        getWindow().setEnterTransition(null);
    }

    @Override
    public void setPresenter(Object presenter) {

    }
}
