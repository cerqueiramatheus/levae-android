package levae.client.view.splash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.LocationServices;

import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.util.ContextUtil;
import levae.client.view.apresentacao.ApresentacaoActivity;
import levae.client.view.main.MainActivity;

/**
 * Created by txring on 03/06/2019.
 */

public class SplashActivity extends BaseActivity implements SplashInterface.View {

    private SplashInterface.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission();
        }

        new ContextUtil();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Handler handler = new Handler();
        handler.postDelayed(() -> mPresenter.moveTo(), 2000);
    }

    private void moveToActivity(Intent it) {
        mPresenter.unsubscribe();
        this.finish();
        startActivity(it);
    }

    @Override
    public void moveToMain() {
        Intent it = new Intent(SplashActivity.this, MainActivity.class);
        moveToActivity(it);
    }

    @Override
    public void moveToApresentacao() {
        Intent it = new Intent(SplashActivity.this, ApresentacaoActivity.class);
        moveToActivity(it);
    }

    @Override
    public void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 123);


            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                new SplashPresenter(this, LocationServices.getFusedLocationProviderClient(this));
            }
        } else {
            new SplashPresenter(this, LocationServices.getFusedLocationProviderClient(this));
        }
    }

    @Override
    public void setPresenter(SplashInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
