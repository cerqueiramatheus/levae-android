package levae.client.core.model.demanda;


/**
 * Created by txring on 19/06/2018.
 */
public class Objeto {

    private int idObjeto;

    private String descricao;

    private String tamanho;

    private double valor;

    private double peso;

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "idObjeto=" + idObjeto +
                ", descricao='" + descricao + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", valor=" + valor +
                ", peso=" + peso +
                '}';
    }
}
