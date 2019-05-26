package levae.client.view.main;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.util.ActivityUtils;
import levae.client.view.demandaNovaVeiculo.DemandaNovaVeiculoFragment;
import levae.client.view.historico.HistoricoFragment;
import levae.client.view.perfil.PerfilFragment;

public class MainActivity extends BaseActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                ActivityUtils.replaceFragment(getSupportFragmentManager(), new HistoricoFragment(), R.id.main_layout);
                return true;
            case R.id.navigation_dashboard:
                ActivityUtils.replaceFragment(getSupportFragmentManager(), new DemandaNovaVeiculoFragment(), R.id.main_layout);
                return true;
            case R.id.navigation_notifications:
                ActivityUtils.replaceFragment(getSupportFragmentManager(), new PerfilFragment(), R.id.main_layout);
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.right_nav);
        ActivityUtils.addFragment(getSupportFragmentManager(), new HistoricoFragment(), R.id.main_layout);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}