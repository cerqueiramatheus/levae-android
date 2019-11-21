package levae.client.view.login;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 22/04/2019.
 */

public interface LoginInterface {

    interface View extends BaseView<Presenter> {
        void toSignUp();

        void onAccepted();

        void onErro(String erro);
    }

    interface Presenter extends BasePresenter {
        void logar(String email, String senha);
    }
}
