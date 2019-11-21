package levae.client.view.historico;

/**
 * Created by txring on 01/05/2019.
 */
public class HistoricoPresenter implements HistoricoInterface.Presenter {

    private HistoricoInterface.View mView;

    HistoricoPresenter(HistoricoInterface.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
