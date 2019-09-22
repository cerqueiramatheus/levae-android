package levae.client.view.listaDemanda;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLOutput;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.view.demandaDetalhe.DemandaDetalheActivity;
import levae.client.view.historico.HistoricoInterface;

public class ListaDemandaFragment extends BaseFragment implements ListaDemandaInterface.View {

    @BindView(R.id.lista_demanda_list)
    RecyclerView listaDemandaList;

    @BindView(R.id.lista_demanda_text)
    TextView listaDemandaText;

    @BindView(R.id.lista_demanda_null_list)
    RelativeLayout listaDemandaNullList;

    private ListaDemandaInterface.Presenter mPresenter;

    private ListaDemandaAdapter listaDemandaAdapter;

    public ListaDemandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_demanda, container, false);
        new ListaDemandaPresenter(this, (HistoricoInterface.View) getParentFragment());
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(ListaDemandaInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void setAdapter(ListaDemandaAdapter adapter) {
        listaDemandaNullList.setVisibility(View.INVISIBLE);
        listaDemandaList.setVisibility(View.VISIBLE);
        this.listaDemandaAdapter = adapter;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        listaDemandaList.setLayoutManager(layoutManager);
        listaDemandaList.setAdapter(listaDemandaAdapter);
        listaDemandaAdapter.setOnBotttomReachedListener(position -> mPresenter.updateList());
    }

    @Override
    public void updateList(int count) {
        listaDemandaAdapter.notifyItemChanged(count - 1);
    }

    @Override
    public void setNullList(String txt) {
        listaDemandaNullList.setVisibility(View.VISIBLE);
        listaDemandaList.setVisibility(View.INVISIBLE);
        listaDemandaText.setText(txt);
    }

    @Override
    public void startDemandaDetalhe(Intent it) {
        getActivity().startActivity(it);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), DemandaDetalheActivity.class);
        mPresenter.prepareDemandaDetalhe(intent, position);
     }

    public enum TipoLista {

        ABERTA(1),
        TRANSPORTE(2),
        FINALIZADA(3);

        private int opt;

        TipoLista(int opt) {
            this.opt = opt;
        }
    }
}