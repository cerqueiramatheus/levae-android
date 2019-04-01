package levae.client.core.model.veiculo;

import java.io.Serializable;

/**
 * Created by txring on 19/06/2018.
 */
public class Marca implements Serializable {

    private int idMarca;

    private String descricao;

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
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
}
