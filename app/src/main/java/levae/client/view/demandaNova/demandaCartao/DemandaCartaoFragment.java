package levae.client.view.demandaNova.demandaCartao;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.util.CustomProgressBar;
import levae.client.view.demandaNova.DemandaNovaActivity;
import levae.client.view.pagamento.PagamentoAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DemandaCartaoFragment extends BaseFragment implements DemandaCartaoInterface.View {


    @BindView(R.id.demanda_cartao_list)
    RecyclerView demandaCartaoList;

    @BindView(R.id.demanda_cartao_layout)
    RelativeLayout mLayout;

    private RecyclerView.LayoutManager layoutManager;

    private DemandaCartaoInterface.Presenter mPresenter;

    private CustomProgressBar customProgressBar;

    public DemandaCartaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demanda_cartao, container, false);
        layoutManager = new LinearLayoutManager(getActivity());
        ButterKnife.bind(this, view);
        new DemandaCartaoPresenter(this, (DemandaNovaActivity) getActivity());

        view.setOnKeyListener((view1, i, keyEvent) -> {
            if ((i == KeyEvent.KEYCODE_BACK) && (keyEvent.getAction() == KeyEvent.ACTION_UP)) {
                mPresenter.backToConfirm();
            }
            return false;
        });

        ((DemandaNovaActivity) getActivity()).getSupportActionBar().setTitle("selecione um cartão");

        customProgressBar = new CustomProgressBar(getActivity(), mLayout, CustomProgressBar.ProgressBarEnum.CIRCULAR, false);
        customProgressBar.show();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void populateView(PagamentoAdapter pagamentoAdapter) {
        demandaCartaoList.setLayoutManager(layoutManager);
        demandaCartaoList.setAdapter(pagamentoAdapter);
        demandaCartaoList.addItemDecoration(new DividerItemDecoration(demandaCartaoList.getContext(), DividerItemDecoration.VERTICAL));
        if (customProgressBar != null) {
            customProgressBar.hide();
        }
    }

    @Override
    public void setPresenter(DemandaCartaoInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onItemClick(View view, int position) {
        mPresenter.onItemClick(position);
    }
}
