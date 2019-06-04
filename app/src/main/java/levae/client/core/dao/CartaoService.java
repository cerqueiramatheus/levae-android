package levae.client.core.dao;

import java.util.List;

import io.reactivex.Single;
import levae.client.core.model.pagamento.Cartao;
import retrofit2.http.POST;

/**
 * Created by txring on 25/05/2019.
 */
public interface CartaoService {

    @POST("cartao/getlista")
    Single<List<Cartao>> getListaCartao();
}
