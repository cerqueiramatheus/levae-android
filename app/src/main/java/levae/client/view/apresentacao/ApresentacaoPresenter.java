package levae.client.view.apresentacao;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by txring on 22/04/2019.
 */
public class ApresentacaoPresenter implements ApresentacaoInterface.Presenter {

    private ApresentacaoInterface.View view;
    private CompositeDisposable mCompositeDisposable;

    ApresentacaoPresenter(ApresentacaoInterface.View<ApresentacaoInterface.Presenter> view) {
        view.setPresenter(this);
        this.view = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void moveToLogin() {
        view.toLogin();
    }

    @Override
    public void moveToCadastro() {
        view.toCadastro();
    }

    @Override
    public void moveToSaibaMais() {
        view.toSaibaMais();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
