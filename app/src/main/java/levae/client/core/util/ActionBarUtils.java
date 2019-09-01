package levae.client.core.util;


import androidx.appcompat.app.ActionBar;

/**
 * Created by txring on 07/05/2019.
 */
public class ActionBarUtils {

    public static void show(ActionBar actionBar) {
        if (!actionBar.isShowing()) {
            actionBar.show();
        }
    }

    public static void hide(ActionBar actionBar) {
        if (actionBar.isShowing()) {
            actionBar.hide();
        }
    }

    public static void setTitle(ActionBar actionBar, String title) {
        if (actionBar.isShowing()) {
            actionBar.setTitle(title);
        } else {
            actionBar.show();
            actionBar.setTitle(title);
        }
    }
}