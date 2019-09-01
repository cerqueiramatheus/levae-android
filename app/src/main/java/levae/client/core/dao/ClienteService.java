package levae.client.core.dao;

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

    @POST("cliente/senha")
    Call<Erro> alterarSenha(@Body Cliente cliente);

    @POST("cliente/login")
    Call<Cliente> login(@Body Cliente cliente);

    @POST("cliente/getinfos")
    Single<Cliente> getInfos();

    @POST("cliente/token")
    Single<String> token(@Body Cliente cliente);

    @POST("cliente/inserir")
    Call<Cliente> cadastrar(@Body Cliente cliente);

    @POST("cliente/alterar")
    Call<Erro> alterar(@Body Cliente cliente);

    @POST("cliente/excluir")
    Call<Erro> excluir(@Body Cliente cliente);

    @POST("cliente/getlistacartao")
    Single<List<Cartao>> getListaCartao();

}