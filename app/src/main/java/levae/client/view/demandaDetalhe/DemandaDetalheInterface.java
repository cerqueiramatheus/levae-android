package levae.client.view.demandaDetalhe;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 22/04/2019.
 */
public interface DemandaDetalheInterface {

    interface View extends BaseView<Presenter> {
        void setTitle(String title);

        void setAdapter(DemandaDetalheAdapter adapter);

        void setLocalizacao(String localizacao);

        void setObjetos(String objetos);

        void setData(String data);
    }

    interface Presenter extends BasePresenter {
        void prepareTitle();
    }

}
