package levae.client.view.splash;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 03/06/2019.
 */
class SplashInterface {
    interface View extends BaseView<SplashInterface.Presenter> {
        void moveToMain();

        void moveToApresentacao();

        void checkPermission();
    }

    interface Presenter extends BasePresenter {
        void moveTo();
    }
}
