package levae.client.view.demandaApresentacao;

import android.os.Bundle;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 01/05/2019.
 */
public interface DemandaApresentacaoInterface {

    interface View extends BaseView<Presenter> {

        void moveToNovaDemanda(Bundle bundle);

        void onError(String msg);

    }

    interface Presenter extends BasePresenter {

        void loadParts();
    }
}
