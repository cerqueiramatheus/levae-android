package levae.client.core.enums;

import levae.client.R;

/**
 * Created by txring on 12/08/2019.
 */
public enum TipoVeiculoEnum {

    CAR(R.drawable.ic_car),
    BIKE(R.drawable.ic_bike),
    MOTORCYCLE(R.drawable.ic_motorcycle),
    TRUCK(R.drawable.ic_truck);

    private final int imagem;

    TipoVeiculoEnum(int imagem) {
        this.imagem = imagem;
    }

    public int getImagem() {
        return imagem;
    }

}