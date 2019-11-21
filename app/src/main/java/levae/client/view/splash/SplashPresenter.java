package levae.client.view.splash;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.model.LatLng;

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

    SplashPresenter(SplashInterface.View view, FusedLocationProviderClient fusedLocationProviderClient) {
        view.setPresenter(this);
        mInteractor = new ClienteInteractor();
        mCompositeDisposable = new CompositeDisposable();
        this.mView = view;

        try {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(location -> UserUtils.setmLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mView.setPresenter(this);
    }

    @Override
    public void moveTo() {
        if (UserUtils.getToken() == null) {
            mView.moveToApresentacao();
        } else {
            mCompositeDisposable.add(mInteractor.getInfos().subscribeWith(new DisposableSingleObserver<Cliente>() {
                @Override
                public void onSuccess(Cliente cliente) {
                    if (!cliente.getSituacao().equals(Constantes.USUARIO_NOT_FOUND)) {
                        UserUtils.setCliente(cliente);
                        mView.moveToMain();
                    } else {
                        UserUtils.logout();
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
