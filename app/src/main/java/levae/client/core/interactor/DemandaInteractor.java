package levae.client.core.interactor;

import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import levae.client.core.dao.DemandaService;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.retrofit.Services;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;


/**
 * Created by txring on 26/11/2018.
 */
public class DemandaInteractor {

    private DemandaService service;

    public DemandaInteractor() {
        service = new Services().getDemandaService();
    }

    public Single<Demanda> getInfos(Demanda demanda) {
        return service.getValor(demanda)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Demanda> inserir(Demanda demanda) {
        List<MultipartBody.Part> imageParts = new ArrayList<>();

        for (Objeto objeto : demanda.getListaObjeto()) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), new File(objeto.getFoto().getPath()));
            imageParts.add(MultipartBody.Part.createFormData("listaFotoObjeto[]", objeto.getTitulo(), requestBody));
        }

        RequestBody demandaBody = RequestBody.create(MediaType.parse("text/json"), (new Gson()).toJson(demanda));

        return service.inserir(demandaBody, imageParts)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<Demanda>> getListaAberta(int id) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("id", id);

        return service.getListaAberta(hashMap)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<Demanda>> getListaTransporte(int id) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("id", id);

        return service.getListaTransporte(hashMap)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<Demanda>> getListaFinalizada(int id) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("id", id);

        return service.getListaFinalizada(hashMap)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public Single<Demanda> cancelarDemanda(Demanda demanda) {
        return service.cancelar(demanda)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Demanda> avaliarDemanda(Demanda demanda) {
        return service.avaliar(demanda)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}