package levae.client.core.enums;

import levae.client.R;

/**
 * Created by txring on 30/07/2019.
 */
public enum CreditCardEnum {

    AMEX("amex", R.drawable.ic_amex, R.drawable.ic_amex_mini),
    AURA("aura", R.drawable.ic_aura, R.drawable.ic_aura_mini),
    DISCOVER("discover", R.drawable.ic_discover, R.drawable.ic_discover_mini),
    ELO("elo", R.drawable.ic_elo, R.drawable.ic_elo_mini),
    HIPERCARD("hipercard", R.drawable.ic_hipercard, R.drawable.ic_hipercard_mini),
    JCB("jcb", R.drawable.ic_jcb, R.drawable.ic_jcb_mini),
    VISA("visa", R.drawable.ic_visa, R.drawable.ic_visa_mini),
    MASTERCARD("mastercard", R.drawable.ic_mastercard, R.drawable.ic_mastercard_mini);

    private String nome;
    private int icon, miniIcon;

    CreditCardEnum(String nome, int icon, int miniIcon) {
        this.nome = nome;
        this.icon = icon;
        this.miniIcon = miniIcon;
    }

    public int getMiniIcon() {
        return miniIcon;
    }

    public String getNome() {
        return nome;
    }

    public int getIcon() {
        return icon;
    }
}
