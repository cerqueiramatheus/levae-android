package levae.client.view.pagamento;

import java.util.List;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.util.OnItemClickListener;
import levae.client.view.login.LoginInterface;

/**
 * Created by txring on 22/04/2019.
 */
public interface PagamentoInterface {

    interface View extends BaseView<PagamentoInterface.Presenter>, OnItemClickListener {
        void populateView(PagamentoAdapter pagamentoAdapter);
    }

    interface Presenter extends BasePresenter {

    }
}
