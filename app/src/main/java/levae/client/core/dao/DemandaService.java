package levae.client.core.dao;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.retrofit.Erro;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
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

    @POST("demanda/solicitacao/cancelar")
    Single<Demanda> cancelar(@Body Demanda demanda);

    @POST("demanda/solicitacao/getinfos")
    Single<Demanda> getValor(@Body Demanda demanda);

    @POST("demanda/solicitacao/getlistaaberta")
    Single<List<Demanda>> getListaAberta(@Body HashMap<String, Integer> hashMap);

    @POST("demanda/solicitacao/getlistatransporte")
    Single<List<Demanda>> getListaTransporte(@Body HashMap<String, Integer> hashMap);

    @POST("demanda/solicitacao/getlistafinalizada")
    Single<List<Demanda>> getListaFinalizada(@Body HashMap<String, Integer> hashMap);

    @POST("demanda/helper/getfoto")
    Call<ResponseBody> getFoto(@Body HashMap<String, Integer> hashMap);

}