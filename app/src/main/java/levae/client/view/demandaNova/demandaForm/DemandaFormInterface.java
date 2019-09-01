package levae.client.view.demandaNova.demandaForm;

import com.google.android.libraries.places.api.model.Place;

import java.util.ArrayList;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 13/08/2019.
 */
public interface DemandaFormInterface {

    public interface View extends BaseView<Presenter> {

        void setEntregaNome(String nome);

        void setEntregaNomeErro(String erro);

        void setColetaNome(String nome);

        void setColetaNomeErro(String erro);

        void setListaVeiculo(ArrayList<String> arrayList);

        void setColetaPessoaErro(String erro);

        void setEntregaPessoaErro(String erro);

        void setColetaDataErro(String erro);

        void setEntregaDataErro(String erro);

        void setTipoVeiculoErro(String erro);

        void setTipoVeiculoNome(String nome);

        void setDataColeta(String data);

        void setDataEntrega(String data);
    }

    interface Presenter extends BasePresenter {

        void setColetaData(int ano, int mes, int dia);

        void setEntregaData(int ano, int mes, int dia);

        void setEntregaPlace(Place place);

        void setColetaPlace(Place place);

        void setTipoVeiculo(String tipoVeiculo);

        boolean validaCampos(String nomeEntrega, String nomeColeta);

        void moveToConfirmacao();
    }

}
