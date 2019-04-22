package levae.client.view.cadastro;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityOptionsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.util.DateInputMask;

public class Cadastro extends BaseActivity implements CadastroInterface.View {

    @BindView(R.id.cadastro_btn_continuar)
    MaterialButton btnContinuar;

    @BindView(R.id.cadastro_et_nascimento)
    TextInputEditText etNascimento;

    @BindView(R.id.cadastro_til_nascimento)
    TextInputLayout tilNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getWindow().setEnterTransition(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
        new DateInputMask(etNascimento);


    }

    @OnClick(R.id.cadastro_btn_continuar)
    public void continuar() {
        System.out.println("clicou");
        Bundle bundle = new Bundle();

        Intent intent = new Intent(Cadastro.this, CadastroLoginSenha.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        getWindow().setExitTransition(null);
        startActivity(intent, options.toBundle());

    }

    @Override
    public void setPresenter(Object presenter) {

    }
}