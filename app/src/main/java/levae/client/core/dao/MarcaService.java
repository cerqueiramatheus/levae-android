package levae.client.core.dao;

import java.util.List;

import levae.client.core.model.veiculo.Marca;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MarcaService {

    @GET("marca/getLista")
    Call<List<Marca>> getlista();

}
