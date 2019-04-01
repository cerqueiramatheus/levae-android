package levae.client.view.entrada.cadastro;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.UsuarioInteractor;
import levae.client.core.model.usuarios.Usuario;
import levae.client.core.retrofit.Erro;
import levae.client.view.entrada.EntradaContract;

/**
 * Created by txring on 04/02/2019.
 */
public class CadastroPresenter implements EntradaContract.CadastroPresenterInterface {

    private EntradaContract.CadastroViewInterface mView;
    private CompositeDisposable mCompositeDisposable;
    private UsuarioInteractor mInteractor;


    public CadastroPresenter(EntradaContract.CadastroViewInterface view) {
        mView = view;
        mCompositeDisposable = new CompositeDisposable();
        mInteractor = new UsuarioInteractor();
        view.setPresenter(this);
    }

    @Override
    public void cadastrar(Usuario usuario) {
        mCompositeDisposable.add(mInteractor.cadastrar(usuario).subscribeWith(new DisposableSingleObserver<Erro>() {
            @Override
            public void onSuccess(Erro erro) {
                System.out.println("a");
            }

            @Override
            public void onError(Throwable e) {

            }
        }));
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}