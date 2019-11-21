package levae.client.view.perfil.alterarEmail;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.util.Constantes;
import levae.client.core.util.UserUtils;

/**
 * Created by txring on 29/10/2019.
 */
public class EmailPresenter implements EmailInterface.Presenter {

    private EmailInterface.View mView;
    private CompositeDisposable compositeDisposable;
    private ClienteInteractor interactor;

    EmailPresenter(EmailInterface.View view) {
        mView = view;
        mView.setPresenter(this);
        compositeDisposable = new CompositeDisposable();
        interactor = new ClienteInteractor();
    }

    @Override
    public void subscribe() {
        mView.setEmail(UserUtils.getCliente().getEmail());
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void checkEmail(String email) {
        if (email != null && !email.equals("")) {

            compositeDisposable.add(interactor.alterarEmail(UserUtils.getCliente(), email).subscribeWith(new DisposableSingleObserver<Cliente>() {
                @Override
                public void onSuccess(Cliente cliente) {

                    if (cliente.getSituacao().equals(Constantes.USUARIO_CRIADO)) {

                        compositeDisposable.add(interactor.getInfos().subscribeWith(new DisposableSingleObserver<Cliente>() {
                            @Override
                            public void onSuccess(Cliente cliente) {
                                if (!cliente.getSituacao().equals(Constantes.USUARIO_NOT_FOUND)) {
                                    UserUtils.setCliente(cliente);
                                    mView.onSuccess();
                                } else {
                                    UserUtils.logout();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                UserUtils.logout();
                            }
                        }));

                    } else {

                        mView.onError(cliente.getSituacao());

                    }

                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                }
            }));

        } else {

            mView.onError("o e-mail é nulo");

        }
    }
}