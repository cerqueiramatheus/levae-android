package levae.client.core.interactor;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import levae.client.core.dao.CartaoService;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.retrofit.Services;

/**
 * Created by txring on 25/05/2019.
 */
public class CartaoInteractor {

    private CartaoService service;

    public CartaoInteractor() {
        service = new Services().getCartaoService();
    }

    public Single<List<Cartao>> getListaCartao() {
        return service.getListaCartao()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
