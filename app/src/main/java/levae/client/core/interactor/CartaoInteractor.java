package levae.client.core.interactor;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import levae.client.core.dao.CartaoService;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.retrofit.Services;
import levae.client.core.util.UserUtils;

/**
 * Created by txring on 25/05/2019.
 */
public class CartaoInteractor {

    private CartaoService service;

    public CartaoInteractor() {
        service = new Services().getCartaoService();
    }

    public Single<List<Cartao>> getLista() {
        return service.getLista()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Cartao> cadastrar(String hash) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("hash", hash);
        hashMap.put("cliente", UserUtils.getCliente());

        return service.cadastrar(hashMap)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Cartao> inativar(Cartao cartao) {
        return service.inativar(cartao)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
