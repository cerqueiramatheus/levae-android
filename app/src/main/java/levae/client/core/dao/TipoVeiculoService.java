package levae.client.core.dao;

import java.util.List;

import levae.client.core.model.veiculo.TipoVeiculo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TipoVeiculoService {

    @GET("tipoveiculo/getlista")
    Call<List<TipoVeiculo>> getlista();

}
