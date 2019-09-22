package levae.client.view.historico;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import levae.client.view.listaDemanda.ListaDemandaFragment;

/**
 * Created by txring on 09/09/2019.
 */
public class HistoricoAdapter extends FragmentStatePagerAdapter {

    HistoricoAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new ListaDemandaFragment();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return 3;
    }
}