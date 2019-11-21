package levae.client.view.menu;

import levae.client.core.util.UserUtils;

/**
 * Created by txring on 01/05/2019.
 */
public class MenuPresenter implements MenuInterface.Presenter {

    private MenuInterface.View mView;

    MenuPresenter(MenuInterface.View view) {
        view.setPresenter(this);
        this.mView = view;
        subscribe();
    }

    @Override
    public void subscribe() {
        mView.setNome(UserUtils.getCliente().getNome());
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
        mView.startPerfil();
    }

}
