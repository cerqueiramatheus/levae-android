package levae.client.core.model.veiculo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by txring on 19/06/2018.
 */
public class TipoVeiculo implements Serializable {

    @SerializedName("idTipo")
    @Expose
    private int idTipo;

    @SerializedName("descricao")
    @Expose
    private String descricao;

    @SerializedName("taxaKm")
    @Expose
    private Double taxaKm;

    @SerializedName("taxaFixa")
    @Expose
    private Double taxaFixa;

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTaxaKm() {
        return taxaKm;
    }

    public void setTaxaKm(Double taxaKm) {
        this.taxaKm = taxaKm;
    }

    public Double getTaxaFixa() {
        return taxaFixa;
    }

    public void setTaxaFixa(Double taxaFixa) {
        this.taxaFixa = taxaFixa;
    }

    @Override
    public String toString() {
        return descricao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipo, descricao);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;

        if (!(obj instanceof TipoVeiculo)) return false;

        TipoVeiculo tipoVeiculo = (TipoVeiculo) obj;

        return idTipo == tipoVeiculo.idTipo &&
                Objects.equals(descricao, tipoVeiculo.descricao);
    }
}
