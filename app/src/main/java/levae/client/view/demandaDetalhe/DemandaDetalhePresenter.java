package levae.client.view.demandaDetalhe;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import levae.client.core.interactor.DemandaInteractor;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.util.FuncoesPadrao;

/**
 * Created by txring on 22/04/2019.
 */
public class DemandaDetalhePresenter implements DemandaDetalheInterface.Presenter {

    private DemandaDetalheInterface.View mView;
    private Demanda mDemanda;
    private CompositeDisposable mCompositeDisposable;
    private DemandaInteractor mInteractor;

    DemandaDetalhePresenter(DemandaDetalheInterface.View view, Demanda demanda) {
        this.mView = view;
        this.mDemanda = demanda;
        this.mCompositeDisposable = new CompositeDisposable();
        this.mInteractor = new DemandaInteractor();
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        List<String> listaFoto = new ArrayList<>();
        for (Objeto objeto : mDemanda.getListaObjeto()) {
            String url = "http://200.17.101.22/api/public/demanda/helper/getfoto?" + "iddemanda=" + mDemanda.getIdDemanda() + "&idobjeto=" + objeto.getIdObjeto();
            listaFoto.add(url);
        }
        mView.setAdapter(new DemandaDetalheAdapter(listaFoto));
        mView.setLocalizacao("De " + mDemanda.getLocalColeta() + " para " + mDemanda.getLocalEntrega());

        String objetos = null;

        System.out.println(mDemanda.getListaObjeto().size());
        for (Objeto objeto : mDemanda.getListaObjeto()) {
            if (objetos == null) {
                objetos = objeto.getTitulo();
                System.out.println(objetos);
            } else {
                objetos = objetos + ", " + objeto.getTitulo();
            }
        }
        mView.setObjetos(objetos);
        mView.setData(FuncoesPadrao.getData(mDemanda.getDataColeta(), mDemanda.getDataLimite()));
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void prepareTitle() {
        mView.setTitle(mDemanda.getTituloDemanda());
    }

}