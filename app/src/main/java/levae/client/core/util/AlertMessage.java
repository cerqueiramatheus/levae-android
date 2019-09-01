package levae.client.core.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by txring on 03/08/2019.
 */
public class AlertMessage {

    public static AlertDialog.Builder getAlertMessage(String title, String message, String positive, DialogInterface.OnClickListener positiveListener, String negative, DialogInterface.OnClickListener negativeListener, Context context) {

        AlertDialog.Builder alert = new AlertDialog.Builder(context);

        alert.setTitle(title);
        alert.setMessage(message);
        alert.setPositiveButton(positive, positiveListener);
        alert.setNegativeButton(negative, negativeListener);

        return alert;

    }
}
