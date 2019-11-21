package levae.client.core.retrofit;

import androidx.annotation.NonNull;

import java.io.IOException;

import levae.client.core.util.UserUtils;
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

        if (UserUtils.getToken() != null && !UserUtils.getToken().equals("")) {
            System.out.println("token");
            builder.header("Authorization", UserUtils.getToken());
        }

        return chain.proceed(builder.build());

    }
}