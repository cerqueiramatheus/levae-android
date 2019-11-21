package levae.client.view.perfil;

import androidx.fragment.app.Fragment;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 29/10/2019.
 */
public interface PerfilInterface {

    interface View extends BaseView<Presenter> {

        void setEmail(String email);

        void setSenha(String senha);

        void setCelular(String celular);

        void moveToEmail();

        void moveToSenha();

        void moveToCelular();

        void back(Fragment fragment);
    }

    interface Presenter extends BasePresenter {

        void onEmail();

        void onSenha();

        void onCelular();
    }
}
