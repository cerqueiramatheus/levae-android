package levae.client.view.pagamento;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.model.pagamento.Cartao;
import levae.client.view.Main2Activity;
import levae.client.view.Teste;
import levae.client.view.login.LoginPresenter;
import levae.client.view.pagamentoNovo.PagamentoNovoActivity;

public class PagamentoActivity extends BaseActivity implements PagamentoInterface.View<PagamentoInterface.Presenter> {


    @BindView(R.id.pagamento_list)
    RecyclerView pagamentoList;

    private PagamentoInterface.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        ButterKnife.bind(this);
        new PagamentoPresenter(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        Intent it = new Intent(this, PagamentoNovoActivity.class);
        fab.setOnClickListener(__ ->
        startActivity(it));
        mPresenter.subscribe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    public void populateView(List<Cartao> listaCartao){

        PagamentoAdapter pagamentoAdapter = new PagamentoAdapter(listaCartao);

        //Use a LinearLayoutManager with default vertical orientation
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PagamentoActivity.this);
        pagamentoList.setLayoutManager(layoutManager);

        //Set the Adapter to the RecyclerView
        pagamentoList.setAdapter(pagamentoAdapter);
    }

    @Override
    public void setPresenter(PagamentoInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }
}