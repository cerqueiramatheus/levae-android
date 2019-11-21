package levae.client.view.demandaNova.demandaConfirm;

import android.content.Context;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.enums.CreditCardEnum;
import levae.client.core.interactor.DemandaInteractor;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.util.EditTextUtils;
import levae.client.view.demandaNova.DemandaNovaInterface;

/**
 * Created by txring on 13/08/2019.
 */
public class DemandaConfirmPresenter implements DemandaConfirmInterface.Presenter {

    private DemandaConfirmInterface.View mView;

    private DemandaNovaInterface.View mRoot;

    private CompositeDisposable mCompositeDisposable;

    private DemandaInteractor demandaInteractor;

    DemandaConfirmPresenter(DemandaConfirmInterface.View view, DemandaNovaInterface.View root, Context c) {
        mRoot = root;
        mCompositeDisposable = new CompositeDisposable();
        demandaInteractor = new DemandaInteractor();
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

        mView.setValorTotal("R$" + mRoot.getDemanda().getValorCliente().toString());
        mView.setColetaLocal(mRoot.getDemanda().getLocalColeta());
        mView.setEntregaLocal(mRoot.getDemanda().getLocalEntrega());

        mView.setColetaData(EditTextUtils.beautifyDate(mRoot.getDemanda().getDataColeta()));
        mView.setEntregaData(EditTextUtils.beautifyDate(mRoot.getDemanda().getDataLimite()));

        String a = null;

        for (Objeto objeto : mRoot.getLista()) {
            if (a == null) {
                a = objeto.getTitulo();
            } else {
                a = a + ", " + objeto.getTitulo();
            }
        }

        mView.setObjetos(a);
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void moveToPagamento() {
        mRoot.moveToPagamento();
    }

    @Override
    public void update() {
        mView.setEtPagamento(CreditCardEnum.valueOf(mRoot.getDemanda().getCartao().getBandeira()).getMiniIcon(),
                mRoot.getDemanda().getCartao().getSequencia());
    }

    @Override
    public void inserir() {

        Demanda demanda = mRoot.getDemanda();
        demanda.setListaObjeto(mRoot.getLista());
        demanda.setTipoVeiculo(mRoot.getTipoVeiculo());

        mCompositeDisposable.add(demandaInteractor.inserir(demanda).subscribeWith(new DisposableSingleObserver<Demanda>() {
            @Override
            public void onSuccess(Demanda demanda) {
                mView.showConfirmation("cadastrado com sucesso!");
            }

            @Override
            public void onError(Throwable e) {
                mView.message("error");
                e.printStackTrace();
            }
        }));
    }

    @Override
    public void end() {
        mRoot.backToMain();
    }
}