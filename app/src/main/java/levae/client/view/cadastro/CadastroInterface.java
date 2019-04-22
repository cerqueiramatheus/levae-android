package levae.client.view.cadastro;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.model.usuarios.Cliente;

/**
 * Created by txring on 22/04/2019.
 */
public interface CadastroInterface {

    interface View <CadastroPresenter> extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void cadastrar(Cliente cliente);
    }
}
