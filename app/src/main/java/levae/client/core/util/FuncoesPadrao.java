package levae.client.core.util;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import levae.client.R;

/**
 * Created by txring on 27/01/19.
 */

public final class FuncoesPadrao {

    private static final String TAG = "FuncoesPadrao";

    private FuncoesPadrao() {
        // This utility class is not publicly instantiable
    }

    @SuppressLint("all")
    public static String pegaIdDispositivo(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static boolean validaEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date());
    }
}