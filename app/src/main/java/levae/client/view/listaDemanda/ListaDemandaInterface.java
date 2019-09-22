package levae.client.view.listaDemanda;

import android.content.Intent;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.util.OnItemClickListener;

/**
 * Created by txring on 09/09/2019.
 */
public interface ListaDemandaInterface {

    interface View extends BaseView<Presenter>, OnItemClickListener {
        void setAdapter(ListaDemandaAdapter adapter);

        void updateList(int count);

        void setNullList(String txt);

        void startDemandaDetalhe(Intent it);
    }

    interface Presenter extends BasePresenter {

        void updateList();

        void prepareDemandaDetalhe(Intent intent, int position);
    }
}
