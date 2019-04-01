package levae.client.core.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import levae.client.core.util.NetworkUtils;
import levae.client.view.entrada.EntradaActivity;

/**
 * Created by txring on 23/01/2019.
 */
public class BaseActivity extends AppCompatActivity implements BaseView{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showSnack(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    public void onError(String message) {
        if (message != null) {
            showSnack(message);
        } else {
            showSnack("algum erro ocorreu");
        }
    }

    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "algum erro ocorreu", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkConnection() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }


    public void voltaLogin() {
        Intent intent = new Intent(this, EntradaActivity.class);
        startActivity(intent);
        this.finish();
    }
}