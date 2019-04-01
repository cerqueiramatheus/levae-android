package levae.client.core.interactor;

import android.util.Pair;

import java.util.List;

import levae.client.core.dao.DemandaService;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.model.usuarios.Usuario;
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

    Call<Erro> gerarDemanda(Usuario usuario, List<Objeto> listaObjeto, Pair<Long, Long> localizacao) {

        Demanda demanda = new Demanda();
        demanda.setUsuario(usuario);
        demanda.setListaObjeto(listaObjeto);

        return service.cadastrar(demanda);

    }
}