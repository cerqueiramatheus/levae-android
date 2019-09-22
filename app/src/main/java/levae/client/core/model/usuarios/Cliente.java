package levae.client.core.model.usuarios;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by txring on 19/06/2018.
 */

public class Cliente extends Pessoa implements Serializable {

    public Cliente() {

    }

    public Cliente(String email, String senha) {
        this.setEmail(email);
        this.setSenha(senha);
    }

    @SerializedName("idCliente")
    @Expose
    private int idCliente;

    @SerializedName("reputacao")
    @Expose
    private double reputacao;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getReputacao() {
        return reputacao;
    }

    public void setReputacao(double reputacao) {
        this.reputacao = reputacao;
    }

    @NonNull
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + getIdCliente() +
                ", email=" + getEmail() +
                ", senha=" + getSenha() +
                ", nome=" + getNome() +
                ", reputacao=" + getReputacao() +
                '}';
    }
}