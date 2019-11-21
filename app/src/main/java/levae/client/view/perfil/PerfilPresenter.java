package levae.client.view.perfil;

import levae.client.core.util.UserUtils;

/**
 * Created by txring on 29/10/2019.
 */
public class PerfilPresenter implements PerfilInterface.Presenter {

    private PerfilInterface.View mView;

    PerfilPresenter(PerfilInterface.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

        mView.setEmail(UserUtils.getCliente().getEmail());
        mView.setCelular(Long.toString(UserUtils.getCliente().getCelular()));
        mView.setSenha("*****");

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void onEmail() {
        mView.moveToEmail();
    }

    @Override
    public void onSenha() {
        mView.moveToSenha();
    }

    @Override
    public void onCelular() {
        mView.moveToCelular();
    }
}
