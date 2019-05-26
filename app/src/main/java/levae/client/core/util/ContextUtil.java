package levae.client.core.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by txring on 16/05/2019.
 */
public class ContextUtil extends Application {

    private static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static Context getContext() {
        return mApplication.getApplicationContext();
    }
}