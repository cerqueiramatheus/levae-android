package levae.client.view.demandaNova.demandaConfirm;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 13/08/2019.
 */
public class DemandaConfirmInterface {

    public interface View extends BaseView<Presenter> {

        void setValorTotal(String valor);

        void setEntregaLocal(String entregaLocal);

        void setColetaLocal(String coletaLocal);

        void setEntregaData(String entregaData);

        void setColetaData(String coletaData);

        void update();

        void setEtPagamento (int resId, String txt);

        void message(String msg);

        void setObjetos (String objetos);

        void showConfirmation (String c);

        void onConfirm();
    }

    interface Presenter extends BasePresenter {

        void moveToPagamento();

        void update();

        void inserir();

        void end();

    }
}
