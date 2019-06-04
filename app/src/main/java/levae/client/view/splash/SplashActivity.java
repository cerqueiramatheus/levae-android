package levae.client.view.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.util.ContextUtil;
import levae.client.core.util.UserUtils;
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
        showMessage(UserUtils.getToken());
        setPresenter(new SplashPresenter(this));
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
        showSnack("token: "+UserUtils.getToken());
        Intent it = new Intent(SplashActivity.this, MainActivity.class);
        moveToActivity(it);
    }

    @Override
    public void moveToApresentacao() {
        showSnack("token: "+UserUtils.getToken());
        Intent it = new Intent(SplashActivity.this, ApresentacaoActivity.class);
        moveToActivity(it);
    }

    @Override
    public void setPresenter(SplashInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
