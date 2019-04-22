package levae.client.core.interactor;

import android.util.Pair;

import java.util.List;

import levae.client.core.dao.DemandaService;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.retrofit.Erro;
import levae.client.core.retrofit.Services;
import retrofit2.Call;


/**
 * Created by txring on 26/11/2018.
 */
public class DemandaInteractor {

    private DemandaService service;

    DemandaInteractor() {
        service = new Services().getDemandaService();
    }

    Call<Erro> gerarDemanda(Cliente cliente, List<Objeto> listaObjeto, Pair<Long, Long> localizacao) {

        Demanda demanda = new Demanda();
        demanda.setCliente(cliente);
        demanda.setListaObjeto(listaObjeto);

        return service.cadastrar(demanda);

    }
}