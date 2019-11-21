package levae.client.view.perfil.alterarCelular;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.util.Constantes;
import levae.client.core.util.UserUtils;

/**
 * Created by txring on 29/10/2019.
 */
public class CelularPresenter implements CelularInterface.Presenter {

    private CelularInterface.View mView;
    private CompositeDisposable compositeDisposable;
    private ClienteInteractor interactor;

    CelularPresenter(CelularInterface.View view) {
        mView = view;
        mView.setPresenter(this);
        compositeDisposable = new CompositeDisposable();
        interactor = new ClienteInteractor();
    }

    @Override
    public void subscribe() {
        mView.setCelular(Long.toString(UserUtils.getCliente().getCelular()));
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void checkCelular(String celular) {
        if (celular != null && !celular.equals("")) {
            if (celular.length() == 9) {
                compositeDisposable.add(interactor.alterarCelular(UserUtils.getCliente(), celular).subscribeWith(new DisposableSingleObserver<Cliente>() {
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
            }
        } else {
            mView.onError("o celular é nulo");
        }
    }
}
