package levae.client.core.token;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.IOException;

import androidx.annotation.NonNull;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by txring on 24/07/2018.
 */
public class MandaToken implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request requestInicial = chain.request();
        Request.Builder builder = requestInicial.newBuilder();

        if (Sessao.localToken != null) {
            builder.header("Authorization", Sessao.localToken);
        }

        return chain.proceed(builder.build());

    }
}