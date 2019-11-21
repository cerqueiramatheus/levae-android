package levae.client.view.historico;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 01/05/2019.
 */
public interface HistoricoInterface {

    interface View extends BaseView<Presenter> {
        int getPosition();

        void update();
    }

    interface Presenter extends BasePresenter {

    }
}