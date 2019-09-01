package levae.client.view.menu;

/**
 * Created by txring on 01/05/2019.
 */
public class MenuPresenter implements MenuInterface.Presenter {

    private MenuInterface.View mView;

    MenuPresenter(MenuInterface.View view) {
        view.setPresenter(this);
        this.mView = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void onCartoesClick() {
        mView.startCartoes();
    }

    @Override
    public void onCompartilharClick() {
        mView.startCompartilhar();
    }

    @Override
    public void onSobreClick() {
        mView.startSobre();
    }

    @Override
    public void onPerfilClick() {

    }
}
