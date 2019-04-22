package levae.client.core.util;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Created by txring on 15/04/2019.
 */
public class EditTextUtils {

    public static void setError(TextInputLayout til, String msg){
        if (til.getError() == null) {
            til.setError(msg);
        } else {
            til.setError(null);
        }
    }

    public static String getString(TextInputEditText et){
        return et.getText().toString();
    }
}
