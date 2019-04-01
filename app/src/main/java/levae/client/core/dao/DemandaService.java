package levae.client.core.dao;

import levae.client.core.model.demanda.Demanda;
import levae.client.core.retrofit.Erro;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DemandaService {

    @POST("demanda/pesquisar")
    Call<Demanda> pesquisar(@Body Demanda demanda);

    @POST("demanda/cadastrar")
    Call<Erro> cadastrar(@Body Demanda demanda);

    @POST("demanda/alterar")
    Call<Erro> alterar(@Body Demanda demanda);

    @POST("demanda/excluir")
    Call<Erro> excluir(@Body Demanda demanda);
}