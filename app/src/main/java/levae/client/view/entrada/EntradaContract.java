package levae.client.view.entrada;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.model.usuarios.Usuario;

/**
 * Created by txring on 29/01/2019.
 */
public interface EntradaContract {

    interface LoginViewInterface<LoginPresenter> extends BaseView<LoginPresenterInterface> {
        void toSignUp();
        void toMain();
        void onErro();
    }

    interface CadastroViewInterface<CadastroPresenter> extends BaseView<CadastroPresenterInterface> {
        void toLogin();
    }

    interface CadastroPresenterInterface extends BasePresenter{
        void cadastrar(Usuario usuario);
    }

    interface LoginPresenterInterface extends BasePresenter{
        void logar (Usuario usuario);
    }
}
