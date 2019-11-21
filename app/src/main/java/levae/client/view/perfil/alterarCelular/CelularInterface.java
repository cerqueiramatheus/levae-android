package levae.client.view.perfil.alterarCelular;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 29/10/2019.
 */
public interface CelularInterface {

    interface View extends BaseView<Presenter> {

        void onSuccess();

        void onError(String msg);

        void setCelular(String celular);

    }

    interface Presenter extends BasePresenter {

        void checkCelular(String celular);

    }
}