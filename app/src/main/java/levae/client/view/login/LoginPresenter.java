package levae.client.view.login;

import androidx.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.retrofit.Services;
import levae.client.core.util.Constantes;
import levae.client.core.util.UserUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by txring on 28/01/2019.
 */

public class LoginPresenter implements LoginInterface.Presenter {

    private LoginInterface.View view;
    private CompositeDisposable mCompositeDisposable;

    LoginPresenter(LoginInterface.View view) {
        view.setPresenter(this);
        this.view = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
    }

    @Override
    public void logar(String email, String senha) {
        (new Services().getUsuarioService()).login(new Cliente(email, senha))
                .enqueue(new Callback<Cliente>() {
                    @Override
                    public void onResponse(@NonNull Call<Cliente> call, @NonNull Response<Cliente> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getSituacao().equals(Constantes.USUARIO_NOT_FOUND)) {
                                view.onErro(response.body().getMensagem());
                            } else {
                                UserUtils.setToken(response.headers().get("Authorization"));
                                UserUtils.setCliente(response.body());
                                view.onAccepted();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Cliente> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}