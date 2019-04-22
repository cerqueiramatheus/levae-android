package levae.client.core.dao;

import io.reactivex.Single;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.retrofit.Erro;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClienteService {

    @POST("cliente/senha")
    Call<Erro> alterarSenha(@Body Cliente cliente);

    @POST("cliente/login")
    Single<Cliente> login(@Body Cliente cliente);

    @POST("cliente/token")
    Single<String> token(@Body Cliente cliente);

    @POST("cliente/inserir")
    Single<Cliente> cadastrar(@Body Cliente cliente);

    @POST("cliente/alterar")
    Call<Erro> alterar(@Body Cliente cliente);

    @POST("cliente/excluir")
    Call<Erro> excluir(@Body Cliente cliente);

}