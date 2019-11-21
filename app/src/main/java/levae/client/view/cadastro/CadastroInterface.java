package levae.client.view.cadastro;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

public interface CadastroInterface {

    interface View extends BaseView<Presenter> {

        void goToDadosPessoais();

        void setDadosPessoais(String nome, String celular, String nascimento, String cpf);

        void goToLoginSenha();

        void setLoginSenha(String email, String senha);

        void goToMain();

        void setError(String msg);
    }

    interface Presenter extends BasePresenter {

        void moveToDadosPessoais();

        void moveToLoginSenha(String nome, String celular, String nascimento, String cpf);

        void moveToMain(String email, String senha);
    }

}
