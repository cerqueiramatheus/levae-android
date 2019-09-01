package levae.client.core.interactor;

import android.util.Pair;

import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import levae.client.core.dao.DemandaService;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.retrofit.Erro;
import levae.client.core.retrofit.Services;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;


/**
 * Created by txring on 26/11/2018.
 */
public class DemandaInteractor {

    private DemandaService service;

    public DemandaInteractor() {
        service = new Services().getDemandaService();
    }

    public Call<Erro> gerarDemanda(Cliente cliente, List<Objeto> listaObjeto, Pair<Long, Long> localizacao) {

        Demanda demanda = new Demanda();
        demanda.setCliente(cliente);
        demanda.setListaObjeto(listaObjeto);

        return service.cadastrar(demanda);

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
}