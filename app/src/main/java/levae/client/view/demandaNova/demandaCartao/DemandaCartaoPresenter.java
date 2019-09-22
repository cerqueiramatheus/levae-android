package levae.client.view.demandaNova.demandaCartao;

import io.reactivex.disposables.CompositeDisposable;
import levae.client.core.model.demanda.Demanda;
import levae.client.view.demandaNova.DemandaNovaInterface;
import levae.client.view.pagamento.PagamentoAdapter;

/**
 * Created by txring on 22/04/2019.
 */
class DemandaCartaoPresenter implements DemandaCartaoInterface.Presenter {

    private DemandaCartaoInterface.View mView;
    private CompositeDisposable mCompositeDisposable;
    private DemandaNovaInterface.View mRoot;

    DemandaCartaoPresenter(DemandaCartaoInterface.View view, DemandaNovaInterface.View root) {
        this.mView = view;
        mView.setPresenter(this);
        this.mRoot = root;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
        mView.populateView(new PagamentoAdapter(mRoot.getListaCartao(), mView));
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void onItemClick(int position) {
        Demanda demanda = mRoot.getDemanda();
        demanda.setCartao(mRoot.getListaCartao().get(position));
        mRoot.setDemanda(demanda);
        mRoot.backToConfirmacao();
    }

    @Override
    public void backToConfirm() {
        mRoot.backToConfirmacao();
    }
}
