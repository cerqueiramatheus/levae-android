package levae.client.view.pagamentoNovo;

/**
 * Created by txring on 22/04/2019.
 */
public class PagamentoNovoPresenter implements PagamentoNovoInterface.Presenter{

    private PagamentoNovoInterface.View mView;

    PagamentoNovoPresenter(PagamentoNovoInterface.View view){
        this.mView = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
