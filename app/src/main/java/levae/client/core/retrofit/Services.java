package levae.client.core.retrofit;

import levae.client.core.dao.CartaoService;
import levae.client.core.dao.ClienteService;
import levae.client.core.dao.DemandaService;
import levae.client.core.dao.TipoVeiculoService;

public class Services {

    private RetrofitConfig retrofitConfig;

    public Services() {
        this.retrofitConfig = new RetrofitConfig();
    }

    public ClienteService getUsuarioService() {
        return retrofitConfig.config().create(ClienteService.class);
    }

    public TipoVeiculoService getTipoVeiculoService() {
        return retrofitConfig.config().create(TipoVeiculoService.class);
    }

    public DemandaService getDemandaService() {
        return retrofitConfig.config().create(DemandaService.class);
    }

    public CartaoService getCartaoService() {
        return retrofitConfig.config().create(CartaoService.class);
    }
}