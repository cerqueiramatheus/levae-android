package levae.client.view.splash;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.util.Constantes;
import levae.client.core.util.UserUtils;

/**
 * Created by txring on 03/06/2019.
 */
public class SplashPresenter implements SplashInterface.Presenter {

    private SplashInterface.View mView;
    private ClienteInteractor mInteractor;
    private CompositeDisposable mCompositeDisposable;

    SplashPresenter(SplashInterface.View view) {
        view.setPresenter(this);
        mInteractor = new ClienteInteractor();
        mCompositeDisposable = new CompositeDisposable();
        this.mView = view;
    }

    @Override
    public void moveTo() {
        System.out.println("o que é? " +UserUtils.getToken().equals(""));
        if (UserUtils.getToken() == null) {
            mView.moveToApresentacao();
            System.out.println("é nulo mermo");
        } else {
            mCompositeDisposable.add(mInteractor.getInfos().subscribeWith(new DisposableSingleObserver<Cliente>() {
                @Override
                public void onSuccess(Cliente cliente) {
                    if (!cliente.getSituacao().equals(Constantes.USUARIO_NOT_FOUND)) {
                        UserUtils.setCliente(cliente);
                        System.out.println("foi");
                        mView.moveToMain();
                    } else {
                        UserUtils.logout();
                        System.out.println("rodou aqui");
                        mView.moveToApresentacao();
                    }
                }

                @Override
                public void onError(Throwable e) {
                    UserUtils.logout();
                    mView.moveToApresentacao();
                }
            }));
        }
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
