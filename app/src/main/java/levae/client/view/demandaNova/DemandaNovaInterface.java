package levae.client.view.demandaNova;

import android.content.Context;

import com.google.android.libraries.places.api.model.Place;

import java.util.Calendar;
import java.util.List;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.model.veiculo.TipoVeiculo;

/**
 * Created by txring on 07/08/2019.
 */
public class DemandaNovaInterface {

    public interface View extends BaseView<Presenter> {

        void moveToObjetoNovo();

        void moveToDemandaForm();

        void moveToConfirmacao();

        void moveToPagamento();

        Demanda getDemanda();

        void setDemanda(Demanda demanda);

        void prepareConfirmacao();

        void backToList();

        void backToConfirmacao();

        List<Objeto> getLista();

        void addObjeto(Objeto objeto);

        Place getColetaPlace();

        void setColetaPlace(Place p);

        Place getEntregaPlace();

        void setEntregaPlace(Place p);

        Calendar getColetaCalendar();

        void setColetaCalendar(Calendar c);

        Calendar getEntregaCalendar();

        void setEntregaCalendar(Calendar c);

        TipoVeiculo getTipoVeiculo();

        void setTipoVeiculo(TipoVeiculo tipoVeiculo);

        void backToMain();

    }

    interface Presenter extends BasePresenter {

        void getValor(Demanda demanda);

    }
}
