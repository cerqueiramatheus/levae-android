package levae.client.view.apresentacao;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.model.usuarios.Cliente;

/**
 * Created by txring on 29/01/2019.
 */
public interface ApresentacaoInterface {

    interface View<ApresentacaoPresenter> extends BaseView<Presenter> {
        void toLogin();
        void toCadastro();
        void toSaibaMais();
    }

    interface Presenter extends BasePresenter {
        void moveToLogin();
        void moveToCadastro();
        void moveToSaibaMais();
    }
}