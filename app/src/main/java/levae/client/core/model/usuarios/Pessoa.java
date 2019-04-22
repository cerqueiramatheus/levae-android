package levae.client.core.model.usuarios;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by txring on 03/05/2018.
 */
public class Pessoa {

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("senha")
    @Expose
    private String senha;

    @SerializedName("nome")
    @Expose
    private String nome;

    @SerializedName("cpf")
    @Expose
    private Long cpf;

    @SerializedName("mensagem")
    @Expose
    private String mensagem;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                ", email='" + email +
                ", senha='" + senha +
                ", nome='" + nome +
                ", cpf=" + cpf +
                ", mensagem=" + mensagem +
                '}';
    }
}
