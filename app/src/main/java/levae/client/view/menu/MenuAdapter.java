package levae.client.view.pagamento;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import levae.client.R;
import levae.client.core.enums.MenuEnum;
import levae.client.core.util.OnItemClickListener;

/**
 * Created by txring on 25/05/2019.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.CustomViewHolder> {

    private OnItemClickListener mListener;

    MenuAdapter(OnItemClickListener listener) {
        this.mListener = listener;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final View mView;
        ImageView img;
        TextView title;
        TextView text;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            img = mView.findViewById(R.id.row_menu_img);
            title = mView.findViewById(R.id.row_menu_title);
            text = mView.findViewById(R.id.row_menu_text);

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
        View view = layoutInflater.inflate(R.layout.row_menu, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.img.setImageResource(MenuEnum.values()[position].getImagem());
        holder.title.setText(MenuEnum.values()[position].getTitulo());
        holder.text.setText(MenuEnum.values()[position].getDescricao());
    }

    @Override
    public int getItemCount() {
        return MenuEnum.values().length;
    }
}