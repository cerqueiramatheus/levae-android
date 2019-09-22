package levae.client.view.cadastro;

import io.reactivex.disposables.CompositeDisposable;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.retrofit.Services;
import levae.client.core.util.Constantes;
import levae.client.core.util.EditTextUtils;
import levae.client.core.util.UserUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroPresenter implements CadastroInterface.Presenter {

    private CadastroInterface.View mView;
    private CompositeDisposable mCompositeDisposable;
    private ClienteInteractor mInteractor;
    private Cliente cliente;

    CadastroPresenter(CadastroInterface.View view) {
        mView = view;
        mCompositeDisposable = new CompositeDisposable();
        mInteractor = new ClienteInteractor();
        cliente = new Cliente();
        view.setPresenter(this);
        mView.goToDadosPessoais();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void moveToDadosPessoais() {
        mView.goToDadosPessoais();
    }

    @Override
    public void moveToLoginSenha(String nome, String celular, String nascimento) {
        cliente.setNome(nome);
        cliente.setCelular(Long.parseLong(celular));
        cliente.setNascimento(EditTextUtils.getDate(nascimento));
        mView.goToLoginSenha();
    }

    @Override
    public void moveToMain(String email, String senha) {
        cliente.setEmail(email);
        cliente.setSenha(senha);

        (new Services().getUsuarioService()).cadastrar(cliente)
                .enqueue(new Callback<Cliente>() {
                    @Override
                    public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                        if (response.body() != null) {
                            if (!response.body().getSituacao().equals(Constantes.USUARIO_REJEITADO)) {
                                UserUtils.setToken(response.headers().get("Authorization"));
                                UserUtils.setCliente(response.body());
                                mView.goToMain();
                            } else {
                                mView.setError(response.body().getMensagem());
                            }
                        } else {
                            mView.setError("houve um erro...");
                        }
                    }

                    @Override
                    public void onFailure(Call<Cliente> call, Throwable t) {
                        t.printStackTrace();
                        mView.setError("houve um erro...");
                    }
                });
    }
}