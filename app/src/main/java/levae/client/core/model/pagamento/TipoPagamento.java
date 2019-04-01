package levae.client.core.model.pagamento;

/**
 * Created by txring on 19/06/2018.
 */
public class TipoPagamento {

    private int idTipo;

    private int descricao;

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getDescricao() {
        return descricao;
    }

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoPagamento{" +
                "idTipo=" + idTipo +
                ", descricao=" + descricao +
                '}';
    }
}
