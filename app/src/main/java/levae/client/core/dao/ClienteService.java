package levae.client.core.dao;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.retrofit.Erro;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClienteService {

    @POST("cliente/login")
    Call<Cliente> login(@Body Cliente cliente);

    @POST("cliente/getinfos")
    Single<Cliente> getInfos();

    @POST("cliente/inserir")
    Call<Cliente> cadastrar(@Body Cliente cliente);

    @POST("cliente/setinfos")
    Single<Boolean> setInfos(@Body Cliente cliente);

    @POST("cliente/alterarsenha")
    Single<Cliente> alterarSenha(@Body HashMap<String, Object> hashMap);

    @POST("cliente/alteraremail")
    Single<Cliente> alterarEmail(@Body HashMap<String, Object> hashMap);

    @POST("cliente/alterarcelular")
    Single<Cliente> alterarCelular(@Body HashMap<String, Object> hashMap);
}