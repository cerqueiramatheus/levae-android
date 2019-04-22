package levae.client.view.cadastro;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;

/**
 * Created by txring on 04/02/2019.
 */
public class CadastroPresenter implements CadastroInterface.Presenter {

    private CadastroInterface.View mView;
    private CompositeDisposable mCompositeDisposable;
    private ClienteInteractor mInteractor;


    public CadastroPresenter(CadastroInterface.View view) {
        mView = view;
        mCompositeDisposable = new CompositeDisposable();
        mInteractor = new ClienteInteractor();
        view.setPresenter(this);
    }

    @Override
    public void cadastrar(Cliente cliente) {
        mCompositeDisposable.add(mInteractor.cadastrar(cliente).subscribeWith(new DisposableSingleObserver<Cliente>() {
            @Override
            public void onSuccess(Cliente cliente) {
                if (cliente.getMensagem() == null) {

                }
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