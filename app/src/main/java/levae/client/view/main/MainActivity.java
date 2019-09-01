package levae.client.view.main;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.util.ActionBarUtils;
import levae.client.core.util.ActivityUtils;
import levae.client.view.demandaApresentacao.DemandaApresentacaoFragment;
import levae.client.view.historico.HistoricoFragment;
import levae.client.view.menu.MenuFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNav;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.nav_history:
                ActivityUtils.replaceFragment(getSupportFragmentManager(), new HistoricoFragment(), R.id.main_layout, false);
                ActionBarUtils.setTitle(getSupportActionBar(), "histórico de transportes");
                return true;
            case R.id.nav_send:
                getSupportActionBar().setShowHideAnimationEnabled(false);
                ActionBarUtils.hide(getSupportActionBar());
                ActivityUtils.replaceFragment(getSupportFragmentManager(), new DemandaApresentacaoFragment(), R.id.main_layout, false);
                //ActionBarUtils.setTitle(getSupportActionBar(), "adicione objetos");
                return true;
            case R.id.nav_menu:
                ActivityUtils.replaceFragment(getSupportFragmentManager(), new MenuFragment(), R.id.main_layout, false);
                ActionBarUtils.setTitle(getSupportActionBar(), "menu");
                return true;

            case R.id.nav_explore:
                return false;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ActivityUtils.addFragment(getSupportFragmentManager(), new HistoricoFragment(), R.id.main_layout);
        getSupportActionBar().setTitle("histórico");

        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}