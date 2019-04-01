package levae.client.core.retrofit;


import java.io.Serializable;

/**
 * Created by txring on 01/05/2018.
 */
public class Erro implements Serializable {

    private boolean erro;

    private String mensagem;

    public boolean isErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Erro{" +
                "erro=" + erro +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}