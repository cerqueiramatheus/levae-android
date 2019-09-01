package levae.client.view.demandaNova.demandaCartao;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.CartaoInteractor;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.pagamento.Cartao;
import levae.client.view.demandaNova.DemandaNovaInterface;
import levae.client.view.pagamento.PagamentoAdapter;

/**
 * Created by txring on 22/04/2019.
 */
class DemandaCartaoPresenter implements DemandaCartaoInterface.Presenter {

    private DemandaCartaoInterface.View mView;
    private CompositeDisposable mCompositeDisposable;
    private CartaoInteractor cartaoInteractor;
    private List<Cartao> cartaoList;
    private DemandaNovaInterface.View mRoot;

    DemandaCartaoPresenter(DemandaCartaoInterface.View view, DemandaNovaInterface.View root) {
        view.setPresenter(this);
        this.mView = view;
        this.mRoot = root;
        mCompositeDisposable = new CompositeDisposable();
        cartaoInteractor = new CartaoInteractor();
    }

    @Override
    public void subscribe() {
        mCompositeDisposable.add(
                cartaoInteractor.getLista().subscribeWith(new DisposableSingleObserver<List<Cartao>>() {
                    @Override
                    public void onSuccess(List<Cartao> listaCartao) {
                        cartaoList = listaCartao;
                        mView.populateView(new PagamentoAdapter(listaCartao, mView));
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                }));
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void onItemClick(int position) {
        Demanda demanda = mRoot.getDemanda();
        demanda.setCartao(cartaoList.get(position));
        mRoot.setDemanda(demanda);
        mRoot.backToConfirmacao();
    }

    @Override
    public void backToConfirm() {
        mRoot.backToConfirmacao();
    }
}
