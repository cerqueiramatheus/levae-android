package levae.client.view.cadastro;

import android.os.Bundle;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

public interface CadastroInterface {

    interface View extends BaseView<Presenter> {

        void goToDadosPessoais();

        void setDadosPessoais(String nome, String celular, String nascimento);

        void goToLoginSenha();

        void setLoginSenha(String email, String senha);

        void goToMain(Bundle bundle);

        void setError(String msg);
    }

    interface Presenter extends BasePresenter {

        void moveToDadosPessoais();

        void moveToLoginSenha(String nome, String celular, String nascimento);

        void moveToMain(String email, String senha);
    }

}
