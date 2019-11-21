package levae.client.view.perfil.alterarEmail;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 29/10/2019.
 */
public interface EmailInterface {

    interface View extends BaseView<Presenter> {

        void onSuccess();

        void onError(String msg);

        void setEmail(String email);
    }

    interface Presenter extends BasePresenter {

        void checkEmail(String email);

    }
}
