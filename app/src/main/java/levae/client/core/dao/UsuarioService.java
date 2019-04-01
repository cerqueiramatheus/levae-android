package levae.client.core.dao;

import io.reactivex.Single;
import levae.client.core.model.usuarios.Usuario;
import levae.client.core.retrofit.Erro;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {

    @POST("usuario/senha")
    Call<Erro> alterarSenha(@Body Usuario usuario);

    @POST("usuario/login")
    Single<Usuario> login(@Body Usuario usuario);

    @POST("usuario/token")
    Single<String> token(@Body Usuario usuario);

    @POST("usuario/inserir")
    Single<Erro> cadastrar(@Body Usuario usuario);

    @POST("usuario/alterar")
    Call<Erro> alterar(@Body Usuario usuario);

    @POST("usuario/excluir")
    Call<Erro> excluir(@Body Usuario usuario);

}