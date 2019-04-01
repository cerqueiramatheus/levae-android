package levae.client.core.model.demanda;

import java.util.List;

import levae.client.core.model.usuarios.Usuario;
import levae.client.core.model.veiculo.Veiculo;


/**
 * Created by txring on 19/06/2018.
 */
public class Demanda {

    private int idDemanda;

    private String estado;

    private String nota;

    private String comentario;

    private Usuario usuario;

    private Veiculo veiculo;

    private List<Objeto> listaObjeto;

    public int getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(int idDemanda) {
        this.idDemanda = idDemanda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Objeto> getListaObjeto() {
        return listaObjeto;
    }

    public void setListaObjeto(List<Objeto> listaObjeto) {
        this.listaObjeto = listaObjeto;
    }

    @Override
    public String toString() {
        return "Demanda{" +
                "idDemanda=" + idDemanda +
                ", estado='" + estado + '\'' +
                ", nota='" + nota + '\'' +
                ", comentario='" + comentario + '\'' +
                ", usuario=" + usuario +
                ", veiculo=" + veiculo +
                ", listaObjeto=" + listaObjeto +
                '}';
    }
}