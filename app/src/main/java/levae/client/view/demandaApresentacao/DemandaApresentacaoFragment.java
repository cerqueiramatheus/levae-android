package levae.client.view.demandaApresentacao;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.enums.SliderEnum;
import levae.client.view.demandaNova.DemandaNovaActivity;

public class DemandaApresentacaoFragment extends BaseFragment implements DemandaApresentacaoInterface.View {

    @BindView(R.id.demanda_nova_view_pager)
    ViewPager viewPager;

    private DemandaApresentacaoInterface.Presenter mPresenter;

    private Timer timer;

    private int index;

    public DemandaApresentacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_demanda_apresentacao, container, false);

        ButterKnife.bind(this, view);

        DemandaApresentacaoAdapter viewPagerAdapter = new DemandaApresentacaoAdapter(view.getContext());

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);

        new DemandaApresentacaoPresenter(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.purge();
        timer.cancel();
    }

    @Override
    public void onStop() {
        super.onStop();
        timer.purge();
        timer.cancel();
    }

    @OnClick(R.id.demanda_apresentacao_btn_mandar)
    public void onMandarClick() {
        mPresenter.loadParts();
    }

    @Override
    public void setPresenter(DemandaApresentacaoInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void moveToNovaDemanda(Bundle bundle) {
        Intent intent = new Intent(getActivity(), DemandaNovaActivity.class);
        intent.putExtras(bundle);
        Objects.requireNonNull(getActivity()).startActivity(intent);
    }

    public class SliderTimer extends TimerTask {

        @Override
        public void run() {

            try {
                DemandaApresentacaoFragment.this.getActivity().runOnUiThread(() -> {
                    if ((index + 1) < SliderEnum.values().length) {
                        System.out.println("a");
                        viewPager.setCurrentItem(index);
                        index++;
                    } else {
                        System.out.println("b");
                        index = 0;
                    }
                });
            } catch (NullPointerException n) {
                n.printStackTrace();
            }
        }
    }
}
