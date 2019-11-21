package levae.client.core.util;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public static String getDateToString(Date data) {
        return (new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"))).format(data);
    }

    public static String getTimestamp(String data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Timestamp.valueOf(data));

        String result = calendar.get(Calendar.DAY_OF_MONTH) + "/" +
                calendar.get(Calendar.MONTH) + " (" +
                calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE) + ")";

        return result;
    }

    public static Date getStringToDate(String data) {
        try {
            return (new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"))).parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String beautifyDate(String data) {
        try {
            return (new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"))
                    .format(new SimpleDateFormat("yyyy-MM-dd", new Locale("pt", "BR")).parse(data)));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getString(TextInputEditText et) {
        return et.getText().toString();
    }
}
