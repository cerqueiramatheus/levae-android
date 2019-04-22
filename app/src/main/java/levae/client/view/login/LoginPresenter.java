package levae.client.view.login;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;

/**
 * Created by txring on 28/01/2019.
 */

public class LoginPresenter implements LoginInterface.Presenter {

    private LoginInterface.View view;
    private CompositeDisposable mCompositeDisposable;
    private ClienteInteractor clienteInteractor;

    public LoginPresenter(LoginInterface.View<LoginInterface.Presenter> view) {
        view.setPresenter(this);
        this.view = view;
        clienteInteractor = new ClienteInteractor();
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
    public void logar(String email, String senha) {

        mCompositeDisposable.add(clienteInteractor.login(new Cliente(email, senha)).subscribeWith(new DisposableSingleObserver<Cliente>() {

            @Override
            public void onSuccess(Cliente cliente) {
                if (cliente.getMensagem() != null) {
                    view.onAccepted();
                } else {
                    view.onErro(cliente.getMensagem());
                }
            }

            @Override
            public void onError(Throwable e) {
                view.onErro("lala");
            }

        }));

    }
}