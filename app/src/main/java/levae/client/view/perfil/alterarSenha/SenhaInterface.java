package levae.client.view.perfil.alterarSenha;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 29/10/2019.
 */
public interface SenhaInterface {

    interface View extends BaseView<Presenter> {

        void onSuccess();

        void onError(String msg);

        void setVelhaError(String msg);

        void setNovaError(String msg);

    }

    interface Presenter extends BasePresenter {

        void checkSenhas(String velha, String nova);
    }
}
