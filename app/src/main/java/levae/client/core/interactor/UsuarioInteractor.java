package levae.client.core.interactor;


import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import levae.client.core.dao.UsuarioService;
import levae.client.core.model.usuarios.Usuario;
import levae.client.core.retrofit.Erro;
import levae.client.core.retrofit.Services;
import retrofit2.Call;

/**
 * Created by txring on 26/11/2018.
 */
public class UsuarioInteractor {

    private UsuarioService service;

    public UsuarioInteractor() {
        service = new Services().getUsuarioService();
    }

    public Single<Erro> cadastrar(Usuario usuario) {
        return service.cadastrar(usuario)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Call<Erro> alterar(Usuario usuario) {
        return service.alterar(usuario);
    }

    public Single<Usuario> login(Usuario usuario) {
        return service.login(usuario)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Call<Erro> logout(Usuario usuario) {
        return null;
    }

}