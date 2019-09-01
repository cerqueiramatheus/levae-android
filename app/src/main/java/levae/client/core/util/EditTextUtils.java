package levae.client.core.util;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by txring on 15/04/2019.
 */
public class EditTextUtils {

    public static void cleanError(TextInputLayout... editTexts) {
        for (TextInputLayout editText : editTexts
        ) {
            editText.setError("");
        }
    }

    public static void setError(TextInputLayout til, String msg) {
        if (til.getError() == null) {
            til.setError(msg);
        } else {
            til.setError(null);
        }
    }

    public static Date getDate(String data) {
        try {
            return (new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"))).parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getString(TextInputEditText et) {
        return et.getText().toString();
    }
}
