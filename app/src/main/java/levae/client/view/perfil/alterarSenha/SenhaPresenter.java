package levae.client.view.perfil.alterarSenha;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.util.Constantes;
import levae.client.core.util.PasswordValidator;
import levae.client.core.util.UserUtils;

/**
 * Created by txring on 29/10/2019.
 */
public class SenhaPresenter implements SenhaInterface.Presenter {

    private SenhaInterface.View mView;
    private CompositeDisposable compositeDisposable;
    private ClienteInteractor interactor;

    SenhaPresenter(SenhaInterface.View view) {
        mView = view;
        mView.setPresenter(this);
        compositeDisposable = new CompositeDisposable();
        interactor = new ClienteInteractor();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void checkSenhas(String velha, String nova) {

        PasswordValidator passwordValidator = new PasswordValidator(false, true, true, 8, 18);

        if (velha != null && !velha.equals("")) {

            if (nova != null && !nova.equals("")) {

                if (passwordValidator.validatePassword(nova)) {

                    compositeDisposable.add(interactor.alterarSenha(UserUtils.getCliente(), velha, nova).subscribeWith(new DisposableSingleObserver<Cliente>() {
                        @Override
                        public void onSuccess(Cliente cliente) {

                            if (cliente.getSituacao().equals(Constantes.USUARIO_CRIADO)) {

                                mView.onSuccess();

                            } else {

                                mView.setVelhaError(cliente.getSituacao());

                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }
                    }));

                } else {

                    mView.onError("a senha não pode ser nula e deve ter uma letra maiúscula, um número e de 8 a 18 dígitos");

                }

            } else {

                mView.setNovaError("senha nula");

            }

        } else {

            mView.setVelhaError("senha nula");

        }
    }
}
