package levae.client.core.dao;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.model.usuarios.Cliente;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by txring on 25/05/2019.
 */
public interface CartaoService {

    @POST("cartao/getlista")
    Single<List<Cartao>> getLista();

    @POST("cartao/cadastrar")
    Single<Cartao> cadastrar(@Body HashMap<String, Object> body);

    @POST("cartao/inativar")
    Single<Cartao> inativar(@Body Cartao cartao);
}
