package levae.client.view.listaDemanda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import levae.client.R;
import levae.client.core.model.demanda.Demanda;
import levae.client.core.util.OnBotttomReachedListener;
import levae.client.core.util.OnItemClickListener;

/**
 * Created by txring on 09/09/2019.
 */
public class ListaDemandaAdapter extends RecyclerView.Adapter<ListaDemandaAdapter.CustomViewHolder> {

    private List<Demanda> listaDemanda;
    private OnItemClickListener onItemClickListener;
    private OnBotttomReachedListener onBotttomReachedListener;

    ListaDemandaAdapter(List<Demanda> dataList, OnItemClickListener listener) {
        this.listaDemanda = dataList;
        this.onItemClickListener = listener;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final View mView;
        ImageView veiculo;
        TextView localizacao;
        TextView data;
        TextView titulo;
        CardView cardView;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            veiculo = mView.findViewById(R.id.row_demanda_veiculo);
            localizacao = mView.findViewById(R.id.row_demanda_localizacao);
            data = mView.findViewById(R.id.row_demanda_nome);
            titulo = mView.findViewById(R.id.row_demanda_titulo);
            cardView = mView.findViewById(R.id.row_demanda_card);
            itemView.setOnClickListener(this);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_demanda, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.titulo.setText(listaDemanda.get(position).getTituloDemanda());

        String local;

        if (listaDemanda.get(position).getCidadeEntrega().equals(listaDemanda.get(position).getCidadeColeta())) {
            local = listaDemanda.get(position).getLocalColeta() + " para " + listaDemanda.get(position).getLocalEntrega();

        } else {
            local = listaDemanda.get(position).getCidadeColeta() + " para " + listaDemanda.get(position).getCidadeEntrega();
        }

        holder.localizacao.setText(local);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date dataColeta = new Date(Timestamp.valueOf(listaDemanda.get(position).getDataColeta()).getTime());
        Date dataLimite = null;

        try {
            dataLimite = new SimpleDateFormat("yyyy-MM-dd").parse(listaDemanda.get(position).getDataLimite());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String data = format.format(dataColeta) + " até " + format.format(dataLimite);
        holder.data.setText(data);

        if (position == (listaDemanda.size() - 1)) {
            onBotttomReachedListener.onBottomReached(position);
        }
    }

    @Override
    public int getItemCount() {
        return listaDemanda.size();
    }

    void setOnBotttomReachedListener(OnBotttomReachedListener onBotttomReachedListener) {
        this.onBotttomReachedListener = onBotttomReachedListener;
    }
}