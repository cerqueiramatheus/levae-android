package levae.client.core.model.pagamento;

/**
 * Created by txring on 19/06/2018.
 */
public class FormaPagamento {

    private int idForma;

    private String descricao;

    private TipoPagamento tipo;

    public int getIdForma() {
        return idForma;
    }

    public void setIdForma(int idForma) {
        this.idForma = idForma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" +
                "idForma=" + idForma +
                ", descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
