package levae.client.view.demandaApresentacao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;

import levae.client.R;
import levae.client.core.enums.MenuEnum;
import levae.client.core.enums.SliderEnum;

/**
 * Created by txring on 22/07/2019.
 */
public class DemandaApresentacaoAdapter extends PagerAdapter {

    private Context context;

    DemandaApresentacaoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return MenuEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.pager_slider, null);

        LottieAnimationView lottieAnimationView = view.findViewById(R.id.pager_slider_img);

        lottieAnimationView.setAnimation(SliderEnum.values()[position].getImagem());

        TextView textView = view.findViewById(R.id.pager_slider_text);
        textView.setText(SliderEnum.values()[position].getDescricao());

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);

    }
}
