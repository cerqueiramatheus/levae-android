package levae.client.view.pagamento;

import android.os.Bundle;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.CartaoInteractor;
import levae.client.core.model.pagamento.Cartao;

/**
 * Created by txring on 22/04/2019.
 */
class PagamentoPresenter implements PagamentoInterface.Presenter {

    private PagamentoInterface.View mView;
    private CompositeDisposable mCompositeDisposable;
    private CartaoInteractor cartaoInteractor;
    private List<Cartao> cartaoList;

    PagamentoPresenter(PagamentoInterface.View view) {
        view.setPresenter(this);
        this.mView = view;
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
        Bundle bundle = new Bundle();
        System.out.println(cartaoList.get(position).toString());
        bundle.putSerializable("cartao", cartaoList.get(position));
        bundle.putBoolean("isNew", true);
        mView.navigateToEditar(bundle);
    }

    @Override
    public void onButtonClick() {
        mView.navigateToCadastrar();
    }
}
