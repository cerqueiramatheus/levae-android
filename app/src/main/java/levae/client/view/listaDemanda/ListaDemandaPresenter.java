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
        mView.showProgress();
        switch (ListaDemandaFragment.TipoLista.values()[mRoot.getPosition()]) {
            case ABERTA:
                if (listaAberta == null) {
                    mCompositeDisposable.add(demandaInteractor.getListaAberta(0).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            if (demandas != null && demandas.size() > 0) {
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
                } else {
                    mView.hideProgress();
                }
                break;

            case FINALIZADA:
                if (listaFinalizada == null) {
                    mCompositeDisposable.add(demandaInteractor.getListaFinalizada(0).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            listaFinalizada = demandas;
                            if (demandas != null && demandas.size() > 0) {
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
                } else {
                    mView.hideProgress();
                }
                break;

            case TRANSPORTE:
                if (listaTransporte == null) {
                    mCompositeDisposable.add(demandaInteractor.getListaTransporte(0).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            listaTransporte = demandas;
                            if (demandas != null && demandas.size() > 0) {
                                mView.setAdapter(new ListaDemandaAdapter(listaTransporte, mView));
                            } else {
                                mView.setNullList("não há demanda em transporte");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.setNullList("não há demanda em transporte");
                            e.printStackTrace();
                        }
                    }));
                } else {
                    mView.hideProgress();
                }
                break;

            default:
                mView.hideProgress();
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
                            if (demandas != null && demandas.size() > 0) {
                                listaAberta.addAll(demandas);
                                mView.updateList(listaAberta.size());
                            } else {
                                mView.hideProgress();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.hideProgress();
                        }
                    }));
                } else {
                    mView.hideProgress();
                }
                break;

            case FINALIZADA:
                if (listaFinalizada != null) {
                    mCompositeDisposable.add(demandaInteractor.getListaFinalizada(listaFinalizada.get(listaFinalizada.size() - 1).getIdDemanda()).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            if (demandas != null && demandas.size() > 0) {
                                listaFinalizada.addAll(demandas);
                                mView.updateList(listaFinalizada.size());
                            } else {
                                mView.hideProgress();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.hideProgress();
                        }
                    }));
                } else {
                    mView.hideProgress();
                }
                break;

            case TRANSPORTE:
                if (listaTransporte != null) {
                    mCompositeDisposable.add(demandaInteractor.getListaTransporte(listaTransporte.get(listaTransporte.size() - 1).getIdDemanda()).subscribeWith(new DisposableSingleObserver<List<Demanda>>() {
                        @Override
                        public void onSuccess(List<Demanda> demandas) {
                            System.out.println((demandas == null) + " nula? ");
                            if (demandas != null && demandas.size() > 0) {
                                listaTransporte.addAll(demandas);
                                mView.updateList(listaTransporte.size());
                            } else {
                                System.out.println("aqui");
                                mView.hideProgress();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.hideProgress();
                        }
                    }));
                } else {
                    mView.hideProgress();
                }
                break;

            default:
                mView.hideProgress();
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