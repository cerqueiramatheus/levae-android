package levae.client.view.demandaDetalhe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.stepstone.apprating.listener.RatingDialogListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.util.CustomDialog;
import levae.client.core.util.CustomRatingDialog;

import static levae.client.core.util.ContextUtil.getContext;

public class DemandaDetalheActivity extends BaseActivity implements DemandaDetalheInterface.View, RatingDialogListener {

    @BindView(R.id.demanda_detalhe_objeto_fotos)
    RecyclerView demandaDetalheObjetoFotos;

    @BindView(R.id.demanda_detalhe_objetos)
    TextView demandaDetalheObjetos;

    @BindView(R.id.demanda_detalhe_localizacao)
    TextView demandaDetalheLocalizacao;

    @BindView(R.id.demanda_detalhe_data)
    TextView demandaDetalheData;

    @BindView(R.id.demanda_detalhe_card_localizacao)
    CardView demandaDetalheCardLocalizacao;

    @BindView(R.id.demanda_detalhe_motorista_nome)
    TextView demandaDetalheMotoristaNome;

    @BindView(R.id.demanda_detalhe_motorista_carro)
    TextView demandaDetalheMotoristaCarro;

    @BindView(R.id.demanda_detalhe_card_motorista)
    CardView demandaDetalheCardMotorista;

    @BindView(R.id.demanda_detalhe_estado_coleta)
    TextView demandaDetalheEstadoColeta;

    @BindView(R.id.demanda_detalhe_estado_entrega)
    TextView demandaDetalheEstadoEntrega;

    @BindView(R.id.demanda_detalhe_card_estado)
    CardView demandaDetalheCardEstado;

    @BindView(R.id.demanda_detalhe_text_entrega)
    TextView demandaDetalheTextEntrega;

    @BindView(R.id.demanda_detalhe_btn_cancelar)
    MaterialButton demandaDetalheBtnCancelar;

    private DemandaDetalheInterface.Presenter mPresenter;

    private CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demanda_detalhe);
        ButterKnife.bind(this);
        new DemandaDetalhePresenter(this, (Demanda) getIntent().getExtras().get("demanda"));
        mPresenter.prepareTitle();
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(DemandaDetalheInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void setAdapter(DemandaDetalheAdapter adapter) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        demandaDetalheObjetoFotos.setLayoutManager(layoutManager);
        demandaDetalheObjetoFotos.setAdapter(adapter);
    }

    @Override
    public void setLocalizacao(String localizacao) {
        demandaDetalheLocalizacao.setText(localizacao);
    }

    @Override
    public void setObjetos(String objetos) {
        demandaDetalheObjetos.setText(objetos);
    }

    @Override
    public void setData(String data) {
        demandaDetalheData.setText(data);
    }

    @Override
    public void setTransportador(String transportador, String veiculo) {
        demandaDetalheTextEntrega.setVisibility(View.VISIBLE);
        demandaDetalheCardMotorista.setVisibility(View.VISIBLE);
        demandaDetalheMotoristaNome.setText(transportador);
        demandaDetalheMotoristaCarro.setText(veiculo);
    }

    @Override
    public void setDataColeta(String dataColeta) {
        demandaDetalheCardLocalizacao.setVisibility(View.VISIBLE);
        demandaDetalheCardEstado.setVisibility(View.VISIBLE);
        demandaDetalheEstadoColeta.setText(dataColeta);
    }

    @Override
    public void setDataEntrega(String dataEntrega) {
        demandaDetalheCardEstado.setVisibility(View.VISIBLE);
        demandaDetalheEstadoEntrega.setText(dataEntrega);
    }

    @Override
    public void setCancelar() {
        demandaDetalheBtnCancelar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setAvaliar() {
        demandaDetalheBtnCancelar.setVisibility(View.VISIBLE);
        demandaDetalheBtnCancelar.setText("avaliar");
    }

    @Override
    public void onSuccess() {
        onBackPressed();
    }

    @Override
    public void onCancelar() {
        customDialog = new CustomDialog(this, "deseja realmente cancelar esta demanda?", "sim, desistir", "não, quero continuar", new CustomDialog.CustomDialogInterface() {
            @Override
            public void onAccepted() {
                mPresenter.cancelar();
                onBackPressed();
            }

            @Override
            public void onRefused() {
                customDialog.dismiss();
            }
        });
        customDialog.show();
    }

    @Override
    public void onAvaliar() {
        CustomRatingDialog.getDialog().create(DemandaDetalheActivity.this).show();
    }

    @Override
    public void hideButton() {
        demandaDetalheBtnCancelar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideEntrega() {
        demandaDetalheEstadoEntrega.setVisibility(View.GONE);
    }

    @OnClick(R.id.demanda_detalhe_btn_cancelar)
    public void onViewClicked() {
        mPresenter.onClick();
    }

    @Override
    public void onNegativeButtonClicked() {

    }

    @Override
    public void onNeutralButtonClicked() {

    }

    @Override
    public void onPositiveButtonClicked(int i, String s) {
        mPresenter.avaliar(i, s);
    }
}
