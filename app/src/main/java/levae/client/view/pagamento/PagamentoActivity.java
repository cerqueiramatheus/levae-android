package levae.client.view.pagamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.util.CustomProgressBar;
import levae.client.view.pagamento.pagamentoNovo.PagamentoNovoActivity;

public class PagamentoActivity extends BaseActivity implements PagamentoInterface.View {


    @BindView(R.id.pagamento_list)
    RecyclerView pagamentoList;

    @BindView(R.id.pagamento_layout)
    RelativeLayout mLayout;

    @BindView(R.id.pagamento_no_payment_layout)
    RelativeLayout noPaymentLayout;

    private PagamentoInterface.Presenter mPresenter;

    private CustomProgressBar customProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        ButterKnife.bind(this);
        new PagamentoPresenter(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mPresenter.subscribe();

        customProgressBar = new CustomProgressBar(this, mLayout, CustomProgressBar.ProgressBarEnum.CIRCULAR, false);
        customProgressBar.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    public void populateView(PagamentoAdapter pagamentoAdapter) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PagamentoActivity.this);

        pagamentoList.setLayoutManager(layoutManager);
        pagamentoList.setAdapter(pagamentoAdapter);
        pagamentoList.addItemDecoration(new DividerItemDecoration(pagamentoList.getContext(), DividerItemDecoration.VERTICAL));

        if (pagamentoAdapter.getItemCount() == 0) {
            pagamentoList.setVisibility(View.INVISIBLE);
            noPaymentLayout.setVisibility(View.VISIBLE);
        } else {
            pagamentoList.setVisibility(View.VISIBLE);
            noPaymentLayout.setVisibility(View.INVISIBLE);
        }
        customProgressBar.hide();
    }

    @Override
    public void navigateToEditar(Bundle bundle) {
        Intent it = new Intent(this, PagamentoNovoActivity.class);
        it.putExtras(bundle);
        startActivity(it);
    }

    @Override
    public void navigateToCadastrar() {
        Intent it = new Intent(this, PagamentoNovoActivity.class);
        startActivity(it);
    }

    @Override
    public void setPresenter(PagamentoInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @OnClick(R.id.pagamento_btn_novo)
    public void onConfirmarClick() {
        mPresenter.onButtonClick();
    }

    @Override
    public void onItemClick(View view, int position) {
        mPresenter.onItemClick(position);
    }
}