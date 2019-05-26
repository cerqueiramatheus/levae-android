package levae.client.view.login;

import io.reactivex.disposables.CompositeDisposable;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.retrofit.Services;
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

    LoginPresenter(LoginInterface.View<LoginInterface.Presenter> view) {
        view.setPresenter(this);
        this.view = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void logar(String email, String senha) {

        Call<Cliente> clienteCallback = (new Services().getUsuarioService()).login(new Cliente(email, senha));
        clienteCallback.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {

                UserUtils.setToken(response.headers().get("Authorization"));
                System.out.println(UserUtils.getToken());
                view.onAccepted();
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {

            }
        });
    }
}