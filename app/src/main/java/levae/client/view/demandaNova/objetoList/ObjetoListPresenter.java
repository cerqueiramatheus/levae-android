package levae.client.view.demandaNova.objetoList;

import levae.client.view.demandaNova.DemandaNovaInterface;

/**
 * Created by txring on 07/08/2019.
 */
public class ObjetoListPresenter implements ObjetoListInterface.Presenter {

    private ObjetoListInterface.View mView;
    private DemandaNovaInterface.View mRoot;

    ObjetoListPresenter(ObjetoListInterface.View view, DemandaNovaInterface.View root) {
        this.mRoot = root;
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        mView.populateView(new ObjetoListAdapter(mRoot.getLista(), mView));
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void moveToObjetoNovo() {
        mRoot.moveToObjetoNovo();
    }

    @Override
    public void moveToDemandaForm() {
        mRoot.moveToDemandaForm();
    }

    @Override
    public void adicionar(String titulo, String valor, String foto) {

    }
}
