package levae.client.core.model.pagamento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by txring on 25/05/2019.
 */
public class Cartao {

    @SerializedName("idCartao")
    @Expose
    private int idCartao;

    @SerializedName("cardId")
    @Expose
    private String cardId;

    @SerializedName("bandeira")
    @Expose
    private String bandeira;

    @SerializedName("sequencia")
    @Expose
    private String sequencia;

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "idCartao=" + idCartao +
                ", cardId='" + cardId + '\'' +
                ", bandeira='" + bandeira + '\'' +
                ", sequencia=" + sequencia +
                '}';
    }
}
