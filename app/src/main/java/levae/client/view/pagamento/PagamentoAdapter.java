package levae.client.view.pagamento;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import levae.client.R;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.util.OnItemClickListener;

/**
 * Created by txring on 25/05/2019.
 */
public class PagamentoAdapter extends RecyclerView.Adapter<PagamentoAdapter.CustomViewHolder> {

    //Extend the RecyclerView.Adapter class
    private List<Cartao> listaCartao;
    private OnItemClickListener mListener;

    PagamentoAdapter(List<Cartao> dataList, OnItemClickListener listener) {
        this.listaCartao = dataList;
        this.mListener = listener;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Get a reference to the Views in our layout
        final View mView;
        TextView tvBandeira;
        TextView tvSequencia;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvBandeira = mView.findViewById(R.id.bandeira);
            tvSequencia = mView.findViewById(R.id.sequencia);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getAdapterPosition());
        }
    }

    //Construct a RecyclerView.ViewHolder
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_pagamento, parent, false);
        return new CustomViewHolder(view);
    }

    //Set the data
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvBandeira.setText(listaCartao.get(position).getBandeira());
        holder.tvSequencia.setText(listaCartao.get(position).getSequencia());
    }

    //Calculate the item count for the RecylerView
    @Override
    public int getItemCount() {
        return listaCartao.size();
    }
}