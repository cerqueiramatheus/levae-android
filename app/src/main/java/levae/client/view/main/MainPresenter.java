package levae.client.view.main;

/**
 * Created by txring on 01/05/2019.
 */
public class MainPresenter implements MainInterface.Presenter {

    private MainInterface.View mView;

    MainPresenter(MainInterface.View view){
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
