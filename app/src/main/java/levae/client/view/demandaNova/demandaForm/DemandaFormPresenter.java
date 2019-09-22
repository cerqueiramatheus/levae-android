package levae.client.view.demandaNova.demandaForm;

import com.google.android.libraries.places.api.model.Place;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.veiculo.TipoVeiculo;
import levae.client.view.demandaNova.DemandaNovaInterface;

/**
 * Created by txring on 12/08/2019.
 */
public class DemandaFormPresenter implements DemandaFormInterface.Presenter {

    private DemandaFormInterface.View mView;
    private DemandaNovaInterface.View mRoot;
    private TipoVeiculo tipoVeiculo;
    private Place coletaPlace;
    private Place entregaPlace;
    private Calendar coletaCalendar;
    private Calendar entregaCalendar;

    DemandaFormPresenter(DemandaFormInterface.View view, DemandaNovaInterface.View root) {
        this.mRoot = root;
        this.mView = view;
        mView.setPresenter(this);

        if (mRoot.getColetaCalendar() != null && mRoot.getEntregaCalendar() != null && mRoot.getColetaPlace() != null && mRoot.getEntregaPlace() != null && mRoot.getTipoVeiculo() != null) {
            this.coletaCalendar = mRoot.getColetaCalendar();
            this.entregaCalendar = mRoot.getEntregaCalendar();
            this.coletaPlace = mRoot.getColetaPlace();
            this.entregaPlace = mRoot.getEntregaPlace();
            this.tipoVeiculo = mRoot.getTipoVeiculo();
        }
    }

    @Override
    public void setColetaData(int ano, int mes, int dia) {
        coletaCalendar = Calendar.getInstance();
        coletaCalendar.set(ano, mes, dia);
        mRoot.setColetaCalendar(coletaCalendar);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        mView.setDataColeta(dateFormat.format(coletaCalendar.getTime()));
    }

    @Override
    public void setEntregaData(int ano, int mes, int dia) {
        entregaCalendar = Calendar.getInstance();
        entregaCalendar.set(ano, mes, dia);
        mRoot.setEntregaCalendar(entregaCalendar);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        mView.setDataEntrega(dateFormat.format(entregaCalendar.getTime()));
    }

    @Override
    public void setEntregaPlace(Place place) {
        this.entregaPlace = place;
        mRoot.setEntregaPlace(place);
        mView.setEntregaNome(place.getName());
    }

    @Override
    public void setColetaPlace(Place place) {
        this.coletaPlace = place;
        mRoot.setColetaPlace(place);
        mView.setColetaNome(place.getName());
    }

    @Override
    public void setTipoVeiculo(String tipo) {
        for (TipoVeiculo tp : mRoot.getListaTipoVeiculo()) {
            if (tp.getDescricao().equals(tipo)) {
                this.tipoVeiculo = tp;
                mRoot.setTipoVeiculo(tipoVeiculo);
            }
        }
        mView.setTipoVeiculoNome(this.tipoVeiculo.getDescricao());
    }

    @Override
    public boolean validaCampos(String nomeEntrega, String nomeColeta) {

        if (coletaPlace == null) {
            mView.setColetaNomeErro("selecione um local de coleta");
            return false;
        }

        if (coletaCalendar != null) {
            if (coletaCalendar.before(Calendar.getInstance()) || coletaCalendar.equals(Calendar.getInstance())) {
                mView.setColetaDataErro("data retroativa");
                return false;
            }
        } else {
            mView.setColetaDataErro("insira uma data de coleta");
            return false;
        }

        if (nomeColeta.length() < 2) {
            mView.setColetaPessoaErro("nome inválido");
            return false;
        }

        if (entregaPlace == null) {
            mView.setEntregaNomeErro("selecione um local de entrega");
            return false;
        }

        if (entregaCalendar != null) {
            if (entregaCalendar.before(Calendar.getInstance()) || entregaCalendar.equals(Calendar.getInstance())) {
                mView.setEntregaDataErro("data retroativa");
                return false;
            }
        } else {
            mView.setEntregaDataErro("insira uma data de entrega");
        }

        if (entregaCalendar != null && coletaCalendar != null) {
            if (entregaCalendar.equals(coletaCalendar) || entregaCalendar.before(coletaCalendar)) {
                mView.setEntregaDataErro("insira uma data válida");
                return false;
            }
        }

        if (nomeEntrega.length() < 2) {
            mView.setEntregaPessoaErro("nome inválido");
            return false;
        }

        if (tipoVeiculo == null) {
            mView.setTipoVeiculoErro("selecione um tipo de veículo");
            return false;
        }

        return true;

    }

    @Override
    public void moveToConfirmacao() {
        Demanda demanda = mRoot.getDemanda();

        demanda.setLocalColeta(coletaPlace.getName());
        demanda.setLatitudeColeta(coletaPlace.getLatLng().latitude);
        demanda.setLongitudeColeta(coletaPlace.getLatLng().longitude);

        demanda.setLocalEntrega(entregaPlace.getName());
        demanda.setLatitudeEntrega(entregaPlace.getLatLng().latitude);
        demanda.setLongitudeEntrega(entregaPlace.getLatLng().longitude);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(("yyyy-MM-dd"));

        demanda.setDataColeta(simpleDateFormat.format(new Date(coletaCalendar.getTimeInMillis())));
        demanda.setDataLimite(simpleDateFormat.format(new Date(entregaCalendar.getTimeInMillis())));

        demanda.setTipoVeiculo(tipoVeiculo);

        mRoot.setDemanda(demanda);

        mRoot.prepareConfirmacao();
    }

    @Override
    public void subscribe() {

        ArrayList<String> stringArrayList = new ArrayList<>();

        for (TipoVeiculo tpVeiculo : mRoot.getListaTipoVeiculo()) {
            stringArrayList.add(tpVeiculo.getDescricao());
        }

        mView.setListaVeiculo(stringArrayList);
    }

    @Override
    public void unsubscribe() {

    }
}
