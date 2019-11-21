package levae.client.view.perfil;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.util.ActivityUtils;
import levae.client.view.perfil.alterarCelular.CelularFragment;
import levae.client.view.perfil.alterarEmail.EmailFragment;
import levae.client.view.perfil.alterarSenha.SenhaFragment;

public class PerfilActivity extends BaseActivity implements PerfilInterface.View {

    @BindView(R.id.perfil_et_email)
    TextInputEditText perfilEtEmail;

    @BindView(R.id.perfil_et_celular)
    TextInputEditText perfilEtCelular;

    @BindView(R.id.perfil_et_senha)
    TextInputEditText perfilEtSenha;

    private PerfilInterface.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        ButterKnife.bind(this);
        new PerfilPresenter(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(PerfilInterface.Presenter presenter) {
        mPresenter = presenter;
    }

    @OnClick({R.id.perfil_et_email, R.id.perfil_et_celular, R.id.perfil_et_senha})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.perfil_et_email:
                mPresenter.onEmail();
                break;

            case R.id.perfil_et_celular:
                mPresenter.onCelular();
                break;

            case R.id.perfil_et_senha:
                mPresenter.onSenha();
                break;
        }
    }

    @Override
    public void setEmail(String email) {
        perfilEtEmail.setText(email);
    }

    @Override
    public void setSenha(String senha) {
        perfilEtSenha.setText(senha);
    }

    @Override
    public void setCelular(String celular) {
        perfilEtCelular.setText(celular);
    }

    @Override
    public void moveToEmail() {
        ActivityUtils.replaceFragment(getSupportFragmentManager(), new EmailFragment(), R.id.perfil_layout, true);
    }

    @Override
    public void moveToSenha() {
        ActivityUtils.replaceFragment(getSupportFragmentManager(), new SenhaFragment(), R.id.perfil_layout, true);
    }

    @Override
    public void moveToCelular() {
        ActivityUtils.replaceFragment(getSupportFragmentManager(), new CelularFragment(), R.id.perfil_layout, true);
    }

    @Override
    public void back(Fragment fragment) {
        ActivityUtils.removeFragment(getSupportFragmentManager(), fragment);
        getSupportActionBar().setTitle("suas informações");
        mPresenter.subscribe();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
            getSupportFragmentManager().popBackStack();
            getSupportActionBar().setTitle("suas informações");
            mPresenter.subscribe();
        } else {
            super.onBackPressed();
        }
    }
}