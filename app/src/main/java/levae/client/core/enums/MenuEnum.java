package levae.client.core.enums;

import levae.client.R;

/**
 * Created by txring on 19/07/2019.
 */
public enum MenuEnum {

    CARD(R.drawable.ic_round_payment_24px, R.string.menu_card_title, R.string.menu_card_text),
    SHARE(R.drawable.ic_round_people_24px, R.string.menu_share_title, R.string.menus_share_text),
    INFO(R.drawable.ic_round_info_24px, R.string.menu_about_title, R.string.menu_about_text),
    LOGOUT(R.drawable.ic_logout, R.string.menu_logout_title, R.string.menu_logout_text);

    private final int imagem, titulo, descricao;

    MenuEnum(int imagem, int titulo, int descricao) {
        this.imagem = imagem;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getTitulo() {
        return titulo;
    }

    public int getDescricao() {
        return descricao;
    }

    public int getImagem() {
        return imagem;
    }

}

