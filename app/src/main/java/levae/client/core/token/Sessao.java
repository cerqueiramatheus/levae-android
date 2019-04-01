package levae.client.core.token;

import levae.client.core.model.usuarios.Usuario;

/**
 * Created by txring on 25/07/2018.
 */
public class Sessao {

    public static Usuario usuario;

    public static String localToken;

    public static String email;

    public static String senha;

    public static String getEmail() {
        return email;
    }

    public static String getSenha() {
        return senha;
    }

    public static String getToken() {
        return localToken;
    }
}
