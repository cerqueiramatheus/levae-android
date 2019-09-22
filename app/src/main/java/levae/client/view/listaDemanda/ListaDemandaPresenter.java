package levae.client.view.listaDemanda;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.DemandaInteractor;
import levae.client.core.model.demanda.Demanda;
import levae.client.view.historico.HistoricoInterface;

/**
 * Created by txring on 09/09/2019.
 */
public class ListaDemandaPresenter implements ListaDemandaInterface.Presenter {

    private ListaDemandaInterface.View mView;
    private HistoricoInterface.View mRoot;
    private List<Demanda> listaAberta;
    private List<Demanda> listaTransporte;
    private List<Demanda> listaFinalizada;
    private CompositeDisposable mCompositeDisposable;
    private DemandaInteractor demandaInteractor;

    ListaDemandaPresenter(ListaDemandaInterface.View view, HistoricoInterface.View root) {
        mView = view;
        mRoot = root;
        mView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
        demandaInteractor = new DemandaInteractor();
    }

    @Override
    public void subscribe() {
        switch (ListaDemandaFragment.TipoLista.values()[mRoot.getPosition()]) {
            case ABERTA:
                if (listaAberta == null) {
                    mCompositeDisposable.add(demandaInteractor.getListaAberta(0).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            if (demandas.size() != 0) {
                                listaAberta = demandas;
                                mView.setAdapter(new ListaDemandaAdapter(listaAberta, mView));
                            } else {
                                mView.setNullList("não há demanda aberta");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.setNullList("não há demanda aberta");
                        }
                    }));
                }
                break;

            case FINALIZADA:
                if (listaFinalizada == null) {
                    mCompositeDisposable.add(demandaInteractor.getListaFinalizada(0).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            listaFinalizada = demandas;
                            if (demandas.size() != 0) {
                                mView.setAdapter(new ListaDemandaAdapter(listaFinalizada, mView));
                            } else {
                                mView.setNullList("não há demanda finalizada");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.setNullList("não há demanda finalizada");
                        }
                    }));
                }
                break;

            case TRANSPORTE:
                if (listaTransporte == null) {
                    mCompositeDisposable.add(demandaInteractor.getListaTransporte(0).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            if (demandas.size() != 0) {
                                listaTransporte = demandas;
                                mView.setAdapter(new ListaDemandaAdapter(listaTransporte, mView));
                            } else {
                                mView.setNullList("não há demanda em transporte");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.setNullList("não há demanda em transporte");
                        }
                    }));
                }
                break;
        }
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void updateList() {
        switch (ListaDemandaFragment.TipoLista.values()[mRoot.getPosition()]) {
            case ABERTA:
                if (listaAberta != null) {
                    mCompositeDisposable.add(demandaInteractor.getListaAberta(listaAberta.get(listaAberta.size() - 1).getIdDemanda()).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            if (demandas.size() != 0) {
                                listaAberta.addAll(demandas);
                                mView.updateList(listaAberta.size());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                        }
                    }));
                }
                break;

            case FINALIZADA:
                if (listaFinalizada != null) {
                    mView.setAdapter(new ListaDemandaAdapter(null, mView));
                    mCompositeDisposable.add(demandaInteractor.getListaFinalizada(listaFinalizada.get(listaFinalizada.size()).getIdDemanda()).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            if (demandas.size() != 0) {
                                listaFinalizada = demandas;
                                mView.setAdapter(new ListaDemandaAdapter(demandas, mView));
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                        }
                    }));
                }
                break;

            case TRANSPORTE:
                if (listaTransporte != null) {
                    mView.setAdapter(new ListaDemandaAdapter(null, mView));
                    mCompositeDisposable.add(demandaInteractor.getListaTransporte(listaTransporte.get(listaTransporte.size()).getIdDemanda()).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            if (demandas.size() != 0) {
                                listaTransporte = demandas;
                                mView.setAdapter(new ListaDemandaAdapter(demandas, mView));
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                        }
                    }));
                }
                break;
        }
    }

    @Override
    public void prepareDemandaDetalhe(Intent intent, int position) {

        Bundle bundle = new Bundle();

        switch (ListaDemandaFragment.TipoLista.values()[mRoot.getPosition()]) {
            case ABERTA:
                bundle.putSerializable("demanda", listaAberta.get(position));
                break;

            case FINALIZADA:
                bundle.putSerializable("demanda", listaFinalizada.get(position));
                break;

            case TRANSPORTE:
                bundle.putSerializable("demanda", listaTransporte.get(position));
                break;
        }
        intent.putExtras(bundle);

        mView.startDemandaDetalhe(intent);
    }
}
