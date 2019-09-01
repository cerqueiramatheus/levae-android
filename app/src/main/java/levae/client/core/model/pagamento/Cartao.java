package levae.client.core.model.pagamento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by txring on 25/05/2019.
 */
public class Cartao implements Serializable {

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

    @SerializedName("validade")
    @Expose
    private String validade;


    @SerializedName("estado")
    @Expose
    private String estado;


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

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
                ", validade=" + validade +
                ", estado=" + estado +
                '}';
    }
}
