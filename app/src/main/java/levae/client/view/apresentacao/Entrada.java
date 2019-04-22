package levae.client.view.apresentacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import androidx.core.app.ActivityOptionsCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.view.cadastro.Cadastro;
import levae.client.view.login.Login;

public class Entrada extends BaseActivity {

    @BindView(R.id.entrada_btn_entrar)
    MaterialButton btnEntrar;

    @BindView(R.id.entrada_btn_comecar)
    MaterialButton btnComecar;

    @BindView(R.id.entrada_btn_mais)
    MaterialButton btnMais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);
        getWindow().setEnterTransition(null);
}

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
    }

    @OnClick(R.id.entrada_btn_entrar)
    public void fazerLogin(){
        System.out.println("clicou");
        Intent intent = new Intent(Entrada.this, Login.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        startActivity(intent, options.toBundle());
    }

    @OnClick(R.id.entrada_btn_comecar)
    public void fazerCadastro(View view){
        System.out.println("clicou");
        Intent intent = new Intent(Entrada.this, Cadastro.class);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        getWindow().setExitTransition(null);
        startActivity(intent, options.toBundle());
    }
}