package levae.client.view.demandaNova;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.libraries.places.api.model.Place;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.model.veiculo.TipoVeiculo;
import levae.client.core.util.ActivityUtils;
import levae.client.core.util.CustomDialog;
import levae.client.view.demandaNova.demandaCartao.DemandaCartaoFragment;
import levae.client.view.demandaNova.demandaConfirm.DemandaConfirmFragment;
import levae.client.view.demandaNova.demandaForm.DemandaFormFragment;
import levae.client.view.demandaNova.objetoList.ObjetoListFragment;
import levae.client.view.demandaNova.objetoNovo.ObjetoNovoFragment;
import levae.client.view.main.MainActivity;

public class DemandaNovaActivity extends BaseActivity implements DemandaNovaInterface.View {

    private List<Objeto> listaObjeto;
    private ObjetoListFragment objetoListFragment;
    private DemandaConfirmFragment demandaConfirmFragment;
    private CustomDialog customDialog;
    private boolean valida;
    private DemandaNovaInterface.Presenter mPresenter;
    private Demanda demanda;
    private Place coletaPlace;
    private Place entregaPlace;
    private Calendar coletaCalendar;
    private Calendar entregaCalendar;
    private TipoVeiculo tipoVeiculo;
    private List<TipoVeiculo> tipoVeiculoList;
    private List<Cartao> cartaoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demanda_nova);

        this.demanda = new Demanda();

        this.cartaoList = (ArrayList<Cartao>) getIntent().getExtras().get("listaCartao");
        this.tipoVeiculoList = (ArrayList<TipoVeiculo>) getIntent().getExtras().get("listaTipo");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaObjeto = new ArrayList<>();

        if (objetoListFragment == null) {
            objetoListFragment = new ObjetoListFragment();
            ActivityUtils.addFragment(getSupportFragmentManager(), objetoListFragment, R.id.demanda_nova_layout);
        }

        new DemandaNovaPresenter(this);

    }

    public List<TipoVeiculo> getListaTipoVeiculo() {
        return tipoVeiculoList;
    }

    public List<Cartao> getListaCartao() {
        return cartaoList;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public void backToMain() {
        Intent it = new Intent(DemandaNovaActivity.this, MainActivity.class);
        startActivity(it);
    }

    public Place getColetaPlace() {
        return coletaPlace;
    }

    public void setColetaPlace(Place coletaPlace) {
        this.coletaPlace = coletaPlace;
    }

    public Place getEntregaPlace() {
        return entregaPlace;
    }

    public void setEntregaPlace(Place entregaPlace) {
        this.entregaPlace = entregaPlace;
    }

    public Calendar getColetaCalendar() {
        return coletaCalendar;
    }

    public void setColetaCalendar(Calendar coletaCalendar) {
        this.coletaCalendar = coletaCalendar;
    }

    public Calendar getEntregaCalendar() {
        return entregaCalendar;
    }

    public void setEntregaCalendar(Calendar entregaCalendar) {
        this.entregaCalendar = entregaCalendar;
    }

    @Override
    public void setPresenter(DemandaNovaInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public Demanda getDemanda() {
        return demanda;
    }

    @Override
    public void setDemanda(Demanda demanda) {
        this.demanda = demanda;
    }

    @Override
    public void moveToObjetoNovo() {
        ActivityUtils.replaceFragment(getSupportFragmentManager(), new ObjetoNovoFragment(), R.id.demanda_nova_layout, true);
    }

    @Override
    public void moveToDemandaForm() {
        ActivityUtils.replaceFragment(getSupportFragmentManager(), new DemandaFormFragment(), R.id.demanda_nova_layout, true);
    }

    @Override
    public void moveToConfirmacao() {
        demandaConfirmFragment = new DemandaConfirmFragment();
        ActivityUtils.replaceFragment(getSupportFragmentManager(), demandaConfirmFragment, R.id.demanda_nova_layout, true);
    }

    @Override
    public void moveToPagamento() {
        ActivityUtils.replaceFragment(getSupportFragmentManager(), new DemandaCartaoFragment(), R.id.demanda_nova_layout, true);
    }

    @Override
    public void prepareConfirmacao() {
        mPresenter.getValor(demanda);
    }

    @Override
    public void backToList() {
        objetoListFragment.update();
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void backToConfirmacao() {
        demandaConfirmFragment.update();
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public List<Objeto> getLista() {
        return listaObjeto;
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            if (!valida) {
                customDialog = new CustomDialog(this, "deseja realmente abandonar esta demanda?", "sim, desistir", "não, quero continuar", new CustomDialog.CustomDialogInterface() {
                    @Override
                    public void onAccepted() {
                        customDialog.dismiss();
                        valida = true;
                        onBackPressed();
                    }

                    @Override
                    public void onRefused() {
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
            } else {
                super.onBackPressed();
                valida = false;
            }
        }
    }

    @Override
    public void addObjeto(Objeto objeto) {
        listaObjeto.add(objeto);
    }
}