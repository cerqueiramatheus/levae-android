package levae.client.view.cadastro.cadastroLoginSenha;

import levae.client.core.util.EmailValidator;
import levae.client.core.util.PasswordValidator;

/**
 * Created by txring on 23/04/2019.
 */
public class CadastroLoginSenhaPresenter implements CadastroLoginSenhaInterface.Presenter {

    private CadastroLoginSenhaInterface.View mView;

    CadastroLoginSenhaPresenter(CadastroLoginSenhaInterface.View view) {
        view.setPresenter(this);
        mView = view;
    }

    @Override
    public void verificaLoginSenha(String email, String senha, String senhaConfirma) {

        EmailValidator emailValidator = new EmailValidator();
        PasswordValidator passwordValidator = new PasswordValidator(false, true, true, 6, 18);

        if (email != null && emailValidator.validateEmail(email)) {

            if (senha != null && passwordValidator.validatePassword(senha)) {

                if (senha.equals(senhaConfirma)) {

                    mView.onCadastrar(email, senha);

                } else {

                    mView.onSenhaConfirmaErro("a senha não confere");

                }

            } else {

                mView.onSenhaErro("a senha não pode ser nula e deve ter uma letra maiúscula, um número e de 8 a 18 dígitos");
            }

        } else {

            mView.onEmailErro("e-mail inválido");

        }
    }
}