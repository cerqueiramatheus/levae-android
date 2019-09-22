package levae.client.view.historico;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricoFragment extends BaseFragment implements HistoricoInterface.View {


    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.main_layout)
    RelativeLayout mainLayout;

    private HistoricoInterface.Presenter mPresenter;

    private HistoricoAdapter adapter;

    public HistoricoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historico, container, false);

        ButterKnife.bind(this, view);
        tabLayout.addTab(tabLayout.newTab().setText("abertas"));
        tabLayout.addTab(tabLayout.newTab().setText("em transporte"));
        tabLayout.addTab(tabLayout.newTab().setText("finalizadas"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        adapter = new HistoricoAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        new HistoricoPresenter(this);
        return view;
    }

    @Override
    public void setPresenter(HistoricoInterface.Presenter presenter) {

    }

    @Override
    public int getPosition() {
        System.out.println("VIEW PAGER ITEM: " + viewPager.getCurrentItem());
        System.out.println("TAB ITEM: " + tabLayout.getSelectedTabPosition());
        System.out.println("ADAPTER " + adapter.getItemPosition(tabLayout));
        return viewPager.getCurrentItem();
    }
}
