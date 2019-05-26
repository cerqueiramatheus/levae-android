package levae.client.view.cadastro;

import android.os.Bundle;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.util.EditTextUtils;

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

        mCompositeDisposable.add(mInteractor.cadastrar(cliente).subscribeWith(new DisposableSingleObserver<Cliente>() {
            @Override
            public void onSuccess(Cliente cliente) {
                if (cliente.getMensagem() == null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("cliente", cliente);
                    mView.goToMain(bundle);
                } else {
                    mView.setError(cliente.getMensagem());
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.setError("algo");
            }
        }));
    }

}