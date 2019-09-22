package levae.client.view.demandaNova.demandaConfirm;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;

import java.util.List;

import levae.client.R;
import levae.client.core.model.demanda.Objeto;

/**
 * Created by txring on 22/07/2019.
 */
public class DemandaConfirmAdapter extends PagerAdapter {

    private Context context;
    private List<Objeto> listaObjeto;

    DemandaConfirmAdapter(Context context, List<Objeto> lista) {
        this.context = context;
        this.listaObjeto = lista;
    }

    @Override
    public int getCount() {
        return listaObjeto.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.picture_slider, null);

        System.out.println("funcionou? " +
                view.isAttachedToWindow());

        ImageView imageView = view.findViewById(R.id.picture_slider_img);

        Picasso.get().load(Uri.fromFile(listaObjeto.get(position).getFoto())).centerCrop().fit().into(imageView);

        TextView textView = view.findViewById(R.id.picture_slider_text);
        textView.setText(listaObjeto.get(position).getTitulo());

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