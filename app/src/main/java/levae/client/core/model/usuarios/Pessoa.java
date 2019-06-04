package levae.client.core.model.usuarios;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

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

    @SerializedName("celular")
    @Expose
    private Long celular;

    @SerializedName("nascimento")
    @Expose
    private Date nascimento;

    @SerializedName("situacao")
    @Expose
    private String situacao;

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

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

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @NonNull
    @Override
    public String toString() {
        return "Pessoa{" +
                ", email='" + email +
                ", senha='" + senha +
                ", nome='" + nome +
                ", cpf=" + cpf +
                ", celular=" + celular +
                ", mensagem=" + mensagem +
                '}';
    }
}
