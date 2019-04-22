package levae.client.core.model.veiculo;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

import levae.client.core.model.usuarios.Transportador;

/**
 * Created by txring on 21/02/2018.
 */

public class Veiculo implements Serializable {

    private int idVeiculo;
    private Marca marca;
    private String modelo;
    private String cor;
    private String placa;
    private TipoVeiculo tipo;
    private Transportador transportador;

    public Veiculo(int idVeiculo, Marca marca, String modelo, String cor, String placa, TipoVeiculo tipo, Transportador transportador) {
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.tipo = tipo;
        this.transportador = transportador;
    }

    public Veiculo(){

    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Transportador getTransportador() {
        return transportador;
    }

    public void setTransportador(Transportador transportador) {
        this.transportador = transportador;
    }

    @NonNull
    @Override
    public String toString() {
        return "Veiculo{" +
                "idVeiculo=" + idVeiculo +
                ", marca=" + marca +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", placa='" + placa + '\'' +
                ", tipo=" + tipo +
                ", transportador=" + transportador +
                '}';
    }
}