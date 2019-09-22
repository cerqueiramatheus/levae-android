package levae.client.view.demandaDetalhe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import levae.client.R;

/**
 * Created by txring on 16/09/2019.
 */
public class DemandaDetalheAdapter extends RecyclerView.Adapter<DemandaDetalheAdapter.CustomViewHolder> {

    private List<String> listaFoto;

    DemandaDetalheAdapter(List<String> dataList) {
        this.listaFoto = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        ImageView foto;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            foto = mView.findViewById(R.id.column_foto_objeto);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.column_foto_objeto, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Picasso.get().load(listaFoto.get(position)).fit().centerCrop().into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return listaFoto.size();
    }
}