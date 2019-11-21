package levae.client.view.demandaNova.demandaForm;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.libraries.places.api.model.Place;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.veiculo.TipoVeiculo;
import levae.client.view.demandaNova.DemandaNovaInterface;

/**
 * Created by txring on 12/08/2019.
 */
public class DemandaFormPresenter implements DemandaFormInterface.Presenter {

    private DemandaFormInterface.View mView;
    private DemandaNovaInterface.View mRoot;
    private Context mContext;
    private TipoVeiculo tipoVeiculo;
    private Place coletaPlace;
    private Place entregaPlace;
    private Calendar coletaCalendar;
    private Calendar entregaCalendar;
    private String nomeDe;
    private String nomePara;

    DemandaFormPresenter(DemandaFormInterface.View view, DemandaNovaInterface.View root, Context context) {
        this.mRoot = root;
        this.mView = view;
        this.mContext = context;
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

        nomeDe = nomeColeta;
        nomePara = nomeEntrega;

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

        try {
            demanda.setCidadeColeta(getPlaceCity(coletaPlace.getLatLng().latitude, coletaPlace.getLatLng().longitude));
            demanda.setCidadeEntrega(getPlaceCity(entregaPlace.getLatLng().latitude, entregaPlace.getLatLng().longitude));

            System.out.println(demanda.getCidadeColeta() + "/ " + demanda.getCidadeEntrega());
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
            e.getCause().printStackTrace();
        }

        demanda.setNomeDe(nomeDe);
        demanda.setNomePara(nomePara);

        demanda.setTipoVeiculo(tipoVeiculo);

        mRoot.setDemanda(demanda);

        mRoot.prepareConfirmacao();
    }

    @Override
    public String getPlaceCity(double latitude, double longitude) throws IOException {
        Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);

        if (addressList != null && addressList.size() > 0) {
            System.out.println("geocoder nulo");
            return addressList.get(0).getSubAdminArea();
        } else {
            return null;
        }
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
