package levae.client.core.token;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import levae.client.core.dao.UsuarioService;
import levae.client.core.model.usuarios.Usuario;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by txring on 24/07/2018.
 */

public class TrocaToken implements Authenticator {

    private Usuario usuario;

    private CompositeDisposable disposable = new CompositeDisposable();

    private UsuarioService service;

    @Override
    public Request authenticate(Route route, Response response) {

        usuario = new Usuario();

        usuario.setEmail(Sessao.getEmail());

        usuario.setSenha(Sessao.getSenha());

        if ((usuario.getEmail() != null && usuario.getSenha() != null)) {
            disposable.add(
                    service.token(usuario)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<String>() {
                                @Override
                                public void accept(String s) throws Exception {

                                }
                            }));

        }

        return response.request()
                .newBuilder()
                .header("Authorization", Sessao.getToken())
                .build();
    }

    public SingleObserver<String> getObserver() {
        return new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(String s) {
                Sessao.localToken = "Bearer " + s;
            }

            @Override
            public void onError(Throwable e) {
            }
        };
    }
}