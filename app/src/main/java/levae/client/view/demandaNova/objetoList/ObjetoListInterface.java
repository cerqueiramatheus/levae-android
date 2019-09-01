package levae.client.view.demandaNova.objetoList;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.util.OnItemClickListener;

/**
 * Created by txring on 07/08/2019.
 */
public interface ObjetoListInterface {

    interface View extends OnItemClickListener, BaseView<Presenter> {

        void onAdicionarErro(String erro);

        void onProximo();

        void populateView(ObjetoListAdapter adapter);

        void update();

    }

    interface Presenter extends BasePresenter {

        void moveToObjetoNovo();

        void moveToDemandaForm();

        void adicionar(String titulo, String valor, String foto);

    }
}
