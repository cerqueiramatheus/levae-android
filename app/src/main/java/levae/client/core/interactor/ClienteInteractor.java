package levae.client.core.interactor;


import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import levae.client.core.dao.ClienteService;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.retrofit.Erro;
import levae.client.core.retrofit.Services;
import retrofit2.Call;

/**
 * Created by txring on 26/11/2018.
 */
public class ClienteInteractor {

    private ClienteService service;

    public ClienteInteractor() {
        service = new Services().getUsuarioService();
    }

    public Single<Cliente> getInfos(){
        return service.getInfos()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Call<Erro> alterar(Cliente cliente) {
        return service.alterar(cliente);
    }

    public Call<Erro> logout(Cliente cliente) {
        return null;
    }

}