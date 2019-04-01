package levae.client.core.model.veiculo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by txring on 19/06/2018.
 */
public class TipoVeiculo implements Serializable {

    private int idTipo;

    private String descricao;

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
