package levae.client.core.model.demanda;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.Serializable;

/**
 * Created by txring on 19/06/2018.
 */
public class Objeto implements Serializable {

    @SerializedName("idObjeto")
    @Expose
    private int idObjeto;

    @SerializedName("tituloObjeto")
    @Expose
    private String titulo;

    @SerializedName("foto")
    @Expose
    private File foto;

    @SerializedName("valor")
    @Expose
    private double valor;

    public Objeto(int idObjeto, String descricao, double valor, File foto) {
        this.idObjeto = idObjeto;
        this.titulo = descricao;
        this.valor = valor;
        this.foto = foto;
    }

    public Objeto() {

    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "Objeto{" +
                "idObjeto=" + idObjeto +
                ", titulo='" + titulo +
                ", valor=" + valor +
                '}';
    }
}
