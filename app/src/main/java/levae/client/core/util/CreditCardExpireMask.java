package levae.client.core.util;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/**
 * Created by txring on 26/07/2019.
 * Use phone as type!
 */
public class CreditCardExpireMask implements TextWatcher {


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.length() > 0 && (editable.length() % 3) == 0) {
            final char c = editable.charAt(editable.length() - 1);
            if ('/' == c) {
                editable.delete(editable.length() - 1, editable.length());
            }
        }
        if (editable.length() > 0 && (editable.length() % 3) == 0) {
            char c = editable.charAt(editable.length() - 1);
            if (Character.isDigit(c) && TextUtils.split(editable.toString(), String.valueOf("/")).length <= 2) {
                editable.insert(editable.length() - 1, String.valueOf("/"));
            }
        }

        System.out.println(editable.toString());
    }
}
