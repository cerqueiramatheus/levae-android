package levae.client.view.demandaDetalhe;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.DemandaInteractor;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.util.Constantes;
import levae.client.core.util.EditTextUtils;
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


        switch (mDemanda.getEstadoDemanda()) {
            case Constantes.DEMANDA_ACEITA:
                mView.setTransportador(mDemanda.getVeiculo().getTransportador().getNome(),
                        mDemanda.getVeiculo().getMarca().getDescricao() + " " +
                                mDemanda.getVeiculo().getModelo() + " " +
                                mDemanda.getVeiculo().getCor() + " (" +
                                mDemanda.getVeiculo().getPlaca() + ")");
                mView.hideButton();
                break;

            case Constantes.DEMANDA_CANCELADA:
                mView.hideButton();
                break;

            case Constantes.DEMANDA_CARTAO:

                break;

            case Constantes.DEMANDA_FINALIZADA:
                mView.setTransportador(mDemanda.getVeiculo().getTransportador().getNome(),
                        mDemanda.getVeiculo().getMarca().getDescricao() + " " +
                                mDemanda.getVeiculo().getModelo() + " " +
                                mDemanda.getVeiculo().getCor() + " (" +
                                mDemanda.getVeiculo().getPlaca() + ")");
                mView.setDataColeta("coletado em: " + EditTextUtils.getTimestamp(mDemanda.getDataInicio().toString()));
                mView.setDataEntrega("entregue em: " + EditTextUtils.getTimestamp(mDemanda.getDataTransporte().toString()));

                if (mDemanda.getNota() == null) {
                    mView.setAvaliar();
                } else {
                    mView.hideButton();
                }

                break;

            case Constantes.DEMANDA_CRIADA:
                mView.setCancelar();
                break;

            case Constantes.DEMANDA_TRANSPORTE:
                mView.setTransportador(mDemanda.getVeiculo().getTransportador().getNome(),
                        mDemanda.getVeiculo().getMarca().getDescricao() + " " +
                                mDemanda.getVeiculo().getModelo() + " " +
                                mDemanda.getVeiculo().getCor() + " (" +
                                mDemanda.getVeiculo().getPlaca() + ")");
                mView.setDataColeta("coletado em: " + EditTextUtils.getTimestamp(mDemanda.getDataInicio().toString()));
                mView.hideButton();
                mView.hideEntrega();
                break;
        }
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void prepareTitle() {
        mView.setTitle(mDemanda.getTituloDemanda());
    }

    @Override
    public void onClick() {
        if (mDemanda.getEstadoDemanda().equals(Constantes.DEMANDA_CRIADA)) {
            mView.onCancelar();
        } else {
            mView.onAvaliar();
        }
    }

    @Override
    public void cancelar() {
        mCompositeDisposable.add(mInteractor.cancelarDemanda(mDemanda).subscribeWith(new DisposableSingleObserver<Demanda>() {
            @Override
            public void onSuccess(Demanda demanda) {
                if (demanda.getEstadoDemanda().equals(Constantes.DEMANDA_CANCELADA)) {
                    mView.onSuccess();
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public void avaliar(int rating, String comment) {
        mDemanda.setNota((double) rating);
        mDemanda.setComentario(comment);

        mCompositeDisposable.add(mInteractor.avaliarDemanda(mDemanda).subscribeWith(new DisposableSingleObserver<Demanda>() {
            @Override
            public void onSuccess(Demanda demanda) {
                if (demanda.getEstadoDemanda() == null) {
                    mView.onSuccess();
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
        }));
    }
}