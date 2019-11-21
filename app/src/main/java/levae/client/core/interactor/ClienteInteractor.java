package levae.client.core.interactor;


import java.util.HashMap;

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

    public Single<Cliente> getInfos() {
        return service.getInfos()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Boolean> setInfos(Cliente cliente) {
        return service.setInfos(cliente)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Cliente> alterarSenha(Cliente cliente, String senhaAntiga, String senhaNova) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cliente", cliente);
        hashMap.put("senhaAntiga", senhaAntiga);
        hashMap.put("senhaNova", senhaNova);

        return service.alterarSenha(hashMap)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Cliente> alterarEmail(Cliente cliente, String email) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cliente", cliente);
        hashMap.put("email", email);

        return service.alterarEmail(hashMap)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Cliente> alterarCelular(Cliente cliente, String celular) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cliente", cliente);
        hashMap.put("celular", celular);

        return service.alterarCelular(hashMap)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}