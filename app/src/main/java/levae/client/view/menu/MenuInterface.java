package levae.client.view.menu;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.util.OnItemClickListener;

/**
 * Created by txring on 01/05/2019.
 */
public interface MenuInterface {

    interface View extends BaseView<Presenter>, OnItemClickListener {
        void startCartoes();

        void startCompartilhar();

        void startSobre();
    }

    interface Presenter extends BasePresenter {
        void onCartoesClick();

        void onCompartilharClick();

        void onSobreClick();

        void onPerfilClick();
    }
}
