package levae.client.core.util;

import android.content.Context;
import android.content.SharedPreferences;

import levae.client.R;
import levae.client.core.model.usuarios.Cliente;

/**
 * Created by txring on 16/05/2019.
 */
public class UserUtils {

    private static Cliente mCliente;

    private static SharedPreferences getSharedPrefs() {
        return getContext().getSharedPreferences(
                getContext().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    private static Context getContext() {
        return ContextUtil.getContext();
    }

    public static void setToken(String token) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(getContext().getString(R.string.preference_file_key), 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getContext().getString(
                R.string.user_token), token);
        editor.apply();
        if (editor.commit()){
            System.out.println("O TOKEN FOI SETADO?" + getToken());
        }
        System.out.println("O TOKEN FOI SETADO?" + getToken());
    }

    public static String getToken() {

        System.out.println("há token?" +getContext().getSharedPreferences(
                getContext().getString(R.string.preference_file_key), 0)
                .getString(getContext().getString(R.string.user_token), ""));

        return getContext().getSharedPreferences(
                getContext().getString(R.string.preference_file_key), 0)
                .getString(getContext().getString(R.string.user_token), "");
    }

    public static Cliente getCliente() {
        return mCliente;
    }

    public static void setCliente(Cliente cliente) {
        mCliente = cliente;
    }

    public static void logout() {
        setCliente(null);
        setToken("");
    }
}
