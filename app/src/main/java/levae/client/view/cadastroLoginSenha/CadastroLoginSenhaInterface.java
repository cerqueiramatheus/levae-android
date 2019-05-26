package levae.client.view.cadastroLoginSenha;

import levae.client.core.base.BaseView;

/**
 * Created by txring on 01/05/2019.
 */
public class CadastroLoginSenhaInterface {

    interface View extends BaseView<Presenter> {
        void onCadastrar(String email, String senha);

        void onEmailErro(String msg);

        void onSenhaErro(String msg);

        void onSenhaConfirmaErro(String msg);
    }

    interface Presenter {
        void verificaLoginSenha(String email, String senha, String senhaConfirma);
    }
}
