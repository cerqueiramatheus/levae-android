package levae.client.view.pagamento;

import java.util.List;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.model.pagamento.Cartao;
import levae.client.view.login.LoginInterface;

/**
 * Created by txring on 22/04/2019.
 */
public interface PagamentoInterface {

    interface View<PagamentoPresenter> extends BaseView<PagamentoInterface.Presenter> {
        void populateView(List<Cartao> listaCartao);
    }

    interface Presenter extends BasePresenter {

    }
}
