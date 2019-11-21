package levae.client.core.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import io.reactivex.observers.DisposableSingleObserver;
import levae.client.R;
import levae.client.core.interactor.ClienteInteractor;
import levae.client.core.model.usuarios.Cliente;

/**
 * Created by txring on 16/05/2019.
 */
public class UserUtils {

    private static Cliente mCliente;
    private static LatLng mLatLng;

    private static SharedPreferences getSharedPrefs() {
        return getContext().getSharedPreferences(
                getContext().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    private static Context getContext() {
        return ContextUtil.getContext();
    }

    public static void setToken(String token) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(getContext().getString(R.string.preference_file_key), 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getContext().getString(
                R.string.user_token), token);
        editor.apply();
        if (editor.commit()) {
            System.out.println("O TOKEN FOI SETADO?" + getToken());
        }
        System.out.println("O TOKEN FOI SETADO?" + getToken());
    }

    public static String getToken() {

        System.out.println("há token?" + getContext().getSharedPreferences(
                getContext().getString(R.string.preference_file_key), 0)
                .getString(getContext().getString(R.string.user_token), ""));

        return getContext().getSharedPreferences(
                getContext().getString(R.string.preference_file_key), 0)
                .getString(getContext().getString(R.string.user_token), "");
    }

    public static Cliente getCliente() {
        return mCliente;
    }

    @SuppressLint("CheckResult")
    public static void setCliente(Cliente cliente) {
        mCliente = cliente;
        if (mCliente != null) {
            mCliente.setLatitudeAtual(mLatLng.latitude);
            mCliente.setLongitudeAtual(mLatLng.longitude);
            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(task -> {
                mCliente.setFirebaseToken(task.getResult().getToken());
                (new ClienteInteractor()).setInfos(mCliente).subscribeWith(new DisposableSingleObserver<Boolean>() {
                    @Override
                    public void onSuccess(Boolean aBoolean) {
                        if (aBoolean){
                            System.out.println("cadastrado");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
            });

        }
    }

    public static LatLng getmLatLng() {
        return mLatLng;
    }

    public static void setmLatLng(LatLng latLng) {
        mLatLng = latLng;
    }

    public static void logout() {
        setCliente(null);
        setToken("");
    }
}
