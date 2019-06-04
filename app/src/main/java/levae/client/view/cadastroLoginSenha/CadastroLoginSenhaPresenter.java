package levae.client.view.cadastroLoginSenha;

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
        mView.onCadastrar(email, senha);
    }
}