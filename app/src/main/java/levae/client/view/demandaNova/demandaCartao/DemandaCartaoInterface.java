package levae.client.view.demandaNova.demandaCartao;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.util.OnItemClickListener;
import levae.client.view.pagamento.PagamentoAdapter;

/**
 * Created by txring on 22/04/2019.
 */
public interface DemandaCartaoInterface {

    interface View extends BaseView<DemandaCartaoInterface.Presenter>, OnItemClickListener {
        void populateView(PagamentoAdapter pagamentoAdapter);
    }

    interface Presenter extends BasePresenter {
        void onItemClick(int position);

        void backToConfirm();
    }
}
