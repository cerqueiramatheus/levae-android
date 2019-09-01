package levae.client.core.dao;

import java.util.List;

import io.reactivex.Single;
import levae.client.core.model.veiculo.TipoVeiculo;
import retrofit2.http.GET;

public interface TipoVeiculoService {

    @GET("tipoveiculo/getlista")
    Single<List<TipoVeiculo>> getLista();

}
