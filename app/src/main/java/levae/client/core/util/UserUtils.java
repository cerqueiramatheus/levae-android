package levae.client.core.util;

import android.content.Context;
import android.content.SharedPreferences;

import levae.client.R;

/**
 * Created by txring on 16/05/2019.
 */
public class UserUtils {

    private static SharedPreferences getSharedPrefs() {
        return getContext().getSharedPreferences(
                getContext().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    private static Context getContext() {
        return ContextUtil.getContext();
    }

    public static void setToken(String token) {
        SharedPreferences sharedPreferences = getSharedPrefs();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getContext().getString(
                R.string.user_token), token);
        editor.commit();

    }

    public static String getToken() {
        return getSharedPrefs().getString(
                getContext().getString(R.string.user_token), "");
    }
}
