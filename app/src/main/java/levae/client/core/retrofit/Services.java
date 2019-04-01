package levae.client.core.retrofit;

import levae.client.core.dao.DemandaService;
import levae.client.core.dao.MarcaService;
import levae.client.core.dao.TipoVeiculoService;
import levae.client.core.dao.TransportadorService;
import levae.client.core.dao.UsuarioService;
import levae.client.core.dao.VeiculoService;

public class Services {

    private RetrofitConfig retrofitConfig;

    public Services() {
        this.retrofitConfig = new RetrofitConfig();
    }

    public VeiculoService getVeiculoService() {
        return retrofitConfig.config().create(VeiculoService.class);
    }

    public UsuarioService getUsuarioService() {
        return retrofitConfig.config().create(UsuarioService.class);
    }

    public TransportadorService getTransportadorService() {
        return retrofitConfig.config().create(TransportadorService.class);
    }

    public TipoVeiculoService getTipoVeiculoService() {
        return retrofitConfig.config().create(TipoVeiculoService.class);
    }

    public MarcaService getMarcaService() {
        return retrofitConfig.config().create(MarcaService.class);
    }

    public DemandaService getDemandaService() {
        return retrofitConfig.config().create(DemandaService.class);
    }
}