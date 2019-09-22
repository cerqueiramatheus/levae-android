package levae.client.view.demandaNova.objetoList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import levae.client.R;
import levae.client.core.model.demanda.Objeto;
import levae.client.core.util.OnItemClickListener;

/**
 * Created by txring on 07/08/2019.
 */
public class ObjetoListAdapter extends RecyclerView.Adapter<ObjetoListAdapter.CustomViewHolder> {

    private List<Objeto> listaObjeto;
    private OnItemClickListener mListener;

    ObjetoListAdapter(List<Objeto> dataList, OnItemClickListener listener) {
        this.listaObjeto = dataList;
        this.mListener = listener;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final View mView;
        TextView titulo;
        TextView valor;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            titulo = mView.findViewById(R.id.row_objeto_titulo);
            valor = mView.findViewById(R.id.row_objeto_valor);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_objeto, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        String valor = "R$" + listaObjeto.get(position).getValor();
        holder.titulo.setText(listaObjeto.get(position).getTitulo());
        holder.valor.setText(valor);
    }

    @Override
    public int getItemCount() {
        return listaObjeto.size();
    }
}