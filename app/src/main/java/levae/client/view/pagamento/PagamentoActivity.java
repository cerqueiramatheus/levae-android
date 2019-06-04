package levae.client.view.pagamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.view.pagamentoNovo.PagamentoNovoActivity;

public class PagamentoActivity extends BaseActivity implements PagamentoInterface.View {


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

    public void populateView(PagamentoAdapter pagamentoAdapter){

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

    @Override
    public void onItemClick(View view, int position) {
        System.out.println("something");
        System.out.println(position);
    }
}