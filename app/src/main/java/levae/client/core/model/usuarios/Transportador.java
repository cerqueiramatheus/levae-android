package levae.client.core.model.usuarios;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

import levae.client.core.model.veiculo.Veiculo;

/**
 * Created by txring on 19/06/2018.
 */
public class Transportador extends Pessoa implements Serializable {

    private int idTransportador;

    private int cnh;

    private double reputacao;

    private List<Veiculo> listaVeiculo;

    public int getIdTransportador() {
        return idTransportador;
    }

    public void setIdTransportador(int idTransportador) {
        this.idTransportador = idTransportador;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public double getReputacao() {
        return reputacao;
    }

    public void setReputacao(double reputacao) {
        this.reputacao = reputacao;
    }

    public List<Veiculo> getListaVeiculo() {
        return listaVeiculo;
    }

    public void setListaVeiculo(List<Veiculo> listaVeiculo) {
        this.listaVeiculo = listaVeiculo;
    }

    @NonNull
    @Override
    public String toString() {
        return "Transportador{" +
                "idTransportador=" + idTransportador +
                ", cnh=" + cnh +
                ", reputacao=" + reputacao +
                ", listaVeiculo=" + listaVeiculo +
                '}';
    }
}
