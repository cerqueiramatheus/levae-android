package levae.client.core.interactor;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import levae.client.core.dao.TipoVeiculoService;
import levae.client.core.model.veiculo.TipoVeiculo;
import levae.client.core.retrofit.Services;

/**
 * Created by txring on 13/08/2019.
 */
public class TipoVeiculoInteractor {

    private TipoVeiculoService service;

    public TipoVeiculoInteractor() {
        service = new Services().getTipoVeiculoService();
    }

    public Single<List<TipoVeiculo>> getLista(){
        return service.getLista()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
