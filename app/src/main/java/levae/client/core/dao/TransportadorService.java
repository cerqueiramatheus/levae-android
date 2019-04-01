package levae.client.core.dao;

import levae.client.core.model.usuarios.Transportador;
import levae.client.core.retrofit.Erro;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TransportadorService {

    @POST("transportador/cadastrar")
    Call<Erro> cadastrar(@Body Transportador transportador);

    @POST("transportador/alterar")
    Call<Erro> alterar(@Body Transportador transportador);

    @POST("transportador/excluir")
    Call<Erro> excluir(@Body Transportador transportador);

}
