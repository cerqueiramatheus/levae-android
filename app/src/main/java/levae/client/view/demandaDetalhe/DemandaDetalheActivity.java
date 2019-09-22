package levae.client.view.demandaDetalhe;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.model.demanda.Demanda;

import static levae.client.core.util.ContextUtil.getContext;

public class DemandaDetalheActivity extends BaseActivity implements DemandaDetalheInterface.View {

    @BindView(R.id.demanda_detalhe_objeto_fotos)
    RecyclerView demandaDetalheObjetoFotos;

    @BindView(R.id.demanda_detalhe_objetos)
    TextView demandaDetalheObjetos;

    @BindView(R.id.demanda_detalhe_localizacao)
    TextView demandaDetalheLocalizacao;

    @BindView(R.id.demanda_detalhe_data)
    TextView demandaDetalheData;

    @BindView(R.id.demanda_detalhe_btn_localizacao)
    Button demandaDetalheBtnLocalizacao;

    private DemandaDetalheInterface.Presenter mPresenter;

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
}
