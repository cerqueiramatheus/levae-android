package levae.client.core.dao;

import java.util.List;

import io.reactivex.Single;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.retrofit.Erro;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DemandaService {

    @Multipart
    @POST("demanda/solicitacao/inserir")
    Single<Demanda> inserir(@Part ("demanda") RequestBody demanda,
                            @Part List<MultipartBody.Part> listaFoto);

    @POST("demanda/pesquisar")
    Call<Demanda> pesquisar(@Body Demanda demanda);

    @POST("demanda/setHash")
    Call<Erro> cadastrar(@Body Demanda demanda);

    @POST("demanda/alterar")
    Call<Erro> alterar(@Body Demanda demanda);

    @POST("demanda/excluir")
    Call<Erro> excluir(@Body Demanda demanda);

    @POST("demanda/solicitacao/getinfos")
    Single<Demanda> getValor(@Body Demanda demanda);
}