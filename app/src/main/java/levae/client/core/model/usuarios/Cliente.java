package levae.client.core.model.usuarios;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by txring on 19/06/2018.
 */

public class Cliente extends Pessoa implements Serializable {

    public Cliente(){

    }

    public Cliente(String email, String senha){
        this.setEmail(email);
        this.setSenha(senha);
    }

    @SerializedName("idUsuario")
    @Expose
    private int idUsuario;

    @SerializedName("reputacao")
    private double reputacao;


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getReputacao() {
        return reputacao;
    }

    public void setReputacao(double reputacao) {
        this.reputacao = reputacao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idUsuario=" + getIdUsuario() +
                ", email=" + getEmail() +
                ", senha=" + getSenha() +
                ", reputacao=" + getReputacao() +
                ", reputacao=" + getReputacao() +
                '}';
    }
}