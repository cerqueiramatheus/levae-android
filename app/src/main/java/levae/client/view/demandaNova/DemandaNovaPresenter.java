package levae.client.view.demandaNova;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.DemandaInteractor;
import levae.client.core.model.demanda.Demanda;

/**
 * Created by txring on 07/08/2019.
 */
public class DemandaNovaPresenter implements DemandaNovaInterface.Presenter {

    private DemandaNovaInterface.View mView;
    private CompositeDisposable mCompositeDisposable;
    private DemandaInteractor demandaInteractor;

    DemandaNovaPresenter(DemandaNovaInterface.View view) {
        this.mView = view;
        mView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
        this.demandaInteractor = new DemandaInteractor();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void getValor(Demanda demanda) {
        System.out.println((demanda == null) + " a demanda é nula?");
        mCompositeDisposable.add(demandaInteractor.getInfos(demanda).subscribeWith(new DisposableSingleObserver<Demanda>() {
            @Override
            public void onSuccess(Demanda demanda) {

                Demanda novaDemanda = mView.getDemanda();

                novaDemanda.setValorCliente(demanda.getValorCliente());
                novaDemanda.setValorSistema(demanda.getValorSistema());
                novaDemanda.setValorTotal(demanda.getValorSistema());
                novaDemanda.setValorTransportador(demanda.getValorTransportador());

                novaDemanda.setDistancia(demanda.getDistancia());

                mView.moveToConfirmacao();

            }

            @Override
            public void onError(Throwable e) {

            }
        }));
    }
}