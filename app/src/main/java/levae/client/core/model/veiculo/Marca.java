package levae.client.core.model.veiculo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by txring on 19/06/2018.
 */
public class Marca implements Serializable {

    @SerializedName("idMarca")
    @Expose
    private int idMarca;

    @SerializedName("descricaoMarca")
    @Expose
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
