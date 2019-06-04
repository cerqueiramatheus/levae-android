package levae.client.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.util.EditTextUtils;
import levae.client.view.main.MainActivity;

public class LoginActivity extends BaseActivity implements LoginInterface.View {

    @BindView(R.id.login_tv_entrar)
    TextView tvEntrar;

    @BindView(R.id.login_et_email)
    TextInputEditText etEmail;

    @BindView(R.id.login_et_senha)
    TextInputEditText etSenha;

    @BindView(R.id.login_til_email)
    TextInputLayout tilEmail;

    @BindView(R.id.login_til_senha)
    TextInputLayout tilSenha;

    private LoginInterface.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
        new LoginPresenter(this);
    }

    @OnClick(R.id.login_btn_login)
    public void login() {
        mPresenter.logar(
                EditTextUtils.getString(etEmail),
                EditTextUtils.getString(etSenha)
        );
    }

    @Override
    public void toSignUp() {

    }

    @Override
    public void onAccepted() {
        Intent it = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(it);
    }

    @Override
    public void onErro(String msg) {
        System.out.println(msg);
        showSnack(msg);
    }

    @Override
    public void setPresenter(LoginInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
