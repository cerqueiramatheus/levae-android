package levae.client.core.enums;

import levae.client.R;

/**
 * Created by txring on 19/07/2019.
 */
public enum SliderEnum {

    ADD(R.raw.check_items, R.string.slider_add),
    PICK(R.raw.pick_location, R.string.slider_pick),
    PAY(R.raw.credit_card, R.string.slider_pay);

    private final int imagem, descricao;

    SliderEnum(int imagem, int descricao) {
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public int getDescricao() {
        return descricao;
    }

    public int getImagem() {
        return imagem;
    }

}

