package levae.client.view.apresentacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.core.app.ActivityOptionsCompat;

import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.view.cadastro.CadastroActivity;
import levae.client.view.login.LoginActivity;

public class ApresentacaoActivity extends BaseActivity implements ApresentacaoInterface.View<ApresentacaoInterface.Presenter> {

    @BindView(R.id.entrada_btn_entrar)
    MaterialButton btnEntrar;

    @BindView(R.id.entrada_btn_comecar)
    MaterialButton btnComecar;

    @BindView(R.id.entrada_btn_mais)
    MaterialButton btnMais;

    @BindView(R.id.layout_apresentacao)
    RelativeLayout layoutApresentacao;

    private ApresentacaoInterface.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentacao);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
        new ApresentacaoPresenter(this);

    }

    @OnClick(R.id.entrada_btn_entrar)
    public void onLoginClick() {
        mPresenter.moveToLogin();
    }

    @OnClick(R.id.entrada_btn_comecar)
    public void onCadastroClick(View view) {
        mPresenter.moveToCadastro();
    }

    @Override
    public void toLogin() {
        if (checkConnection()) {
            Intent intent = new Intent(ApresentacaoActivity.this, LoginActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
            startActivity(intent, options.toBundle());
        } else {
            showSnack("sem conexão com a Internet");
        }
    }

    @Override
    public void toCadastro() {
        if (checkConnection()) {
            Intent intent = new Intent(ApresentacaoActivity.this, CadastroActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
            getWindow().setExitTransition(null);
            startActivity(intent, options.toBundle());
        } else {
            showSnack("sem conexão com a Internet");
        }
    }

    @Override
    public void toSaibaMais() {

    }

    @Override
    public void setPresenter(ApresentacaoInterface.Presenter presenter) {
        mPresenter = presenter;
    }
}