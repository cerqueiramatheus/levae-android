package levae.client.view.demandaApresentacao;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.CartaoInteractor;
import levae.client.core.interactor.TipoVeiculoInteractor;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.model.veiculo.TipoVeiculo;

/**
 * Created by txring on 01/05/2019.
 */
public class DemandaApresentacaoPresenter implements DemandaApresentacaoInterface.Presenter {

    private DemandaApresentacaoInterface.View mView;
    private CartaoInteractor cartaoInteractor;
    private TipoVeiculoInteractor tipoVeiculoInteractor;
    private CompositeDisposable compositeDisposable;

    public DemandaApresentacaoPresenter(DemandaApresentacaoInterface.View view) {
        mView = view;
        mView.setPresenter(this);
        tipoVeiculoInteractor = new TipoVeiculoInteractor();
        cartaoInteractor = new CartaoInteractor();
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void loadParts() {
        compositeDisposable.add(cartaoInteractor.getLista().subscribeWith(new DisposableSingleObserver<List<Cartao>>() {
            @Override
            public void onSuccess(List<Cartao> cartaos) {

                if (cartaos.size() > 0) {

                    compositeDisposable.add(tipoVeiculoInteractor.getLista().subscribeWith(new DisposableSingleObserver<List<TipoVeiculo>>() {
                        @Override
                        public void onSuccess(List<TipoVeiculo> tipoVeiculos) {

                            Bundle bundle = new Bundle();
                            bundle.putSerializable("listaCartao", new ArrayList<>(cartaos));
                            bundle.putSerializable("listaTipo", new ArrayList<>(tipoVeiculos));

                            mView.moveToNovaDemanda(bundle);
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.onError("algum erro ocorreu");
                        }
                    }));
                }

            }

            @Override
            public void onError(Throwable e) {
                mView.onError("cadastre um cartão antes");
            }
        }));
    }
}
