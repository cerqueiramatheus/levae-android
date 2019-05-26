package levae.client.view.pagamento;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.CartaoInteractor;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.pagamento.Cartao;

/**
 * Created by txring on 22/04/2019.
 */
class PagamentoPresenter implements PagamentoInterface.Presenter {

    private PagamentoInterface.View mView;
    private CompositeDisposable mCompositeDisposable;
    private CartaoInteractor cartaoInteractor;

    PagamentoPresenter(PagamentoInterface.View<PagamentoInterface.Presenter> view) {
        view.setPresenter(this);
        this.mView = view;
        mCompositeDisposable = new CompositeDisposable();
        cartaoInteractor = new CartaoInteractor();
    }

    @Override
    public void subscribe() {
        mCompositeDisposable.add(
                cartaoInteractor.getListaCartao().subscribeWith(new DisposableSingleObserver<List<Cartao>>() {
                    @Override
                    public void onSuccess(List<Cartao> listaCartao) {
                        mView.populateView(listaCartao);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        System.out.println("alalalala");
                    }
                }));
    }

    @Override
    public void unsubscribe() {

    }
}
