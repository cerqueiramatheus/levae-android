package levae.client.view.pagamento;

import android.os.Bundle;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.util.OnItemClickListener;

/**
 * Created by txring on 22/04/2019.
 */
public interface PagamentoInterface {

    interface View extends BaseView<PagamentoInterface.Presenter>, OnItemClickListener {
        void populateView(PagamentoAdapter pagamentoAdapter);

        void navigateToEditar(Bundle bundle);

        void navigateToCadastrar();
    }

    interface Presenter extends BasePresenter {
        void onItemClick(int position);

        void onButtonClick();
    }
}
