package levae.client.view.entrada.login;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.UsuarioInteractor;
import levae.client.core.model.usuarios.Usuario;
import levae.client.view.entrada.EntradaContract;

/**
 * Created by txring on 28/01/2019.
 */

public class LoginPresenter implements EntradaContract.LoginPresenterInterface {

    private EntradaContract.LoginViewInterface view;
    private CompositeDisposable mCompositeDisposable;
    private UsuarioInteractor usuarioInteractor;

    public LoginPresenter(EntradaContract.LoginViewInterface<LoginPresenter> view) {
        view.setPresenter(this);
        this.view = view;
        usuarioInteractor = new UsuarioInteractor();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void logar(Usuario usuario) {

        mCompositeDisposable.add(usuarioInteractor.login(usuario).subscribeWith(new DisposableSingleObserver<Usuario>(){

                    @Override
                    public void onSuccess(Usuario usuario) {
                        view.toMain();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onErro();
                    }
                }));

    }
}