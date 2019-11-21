package levae.client.view.demandaNova.objetoList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.view.demandaNova.DemandaNovaActivity;

public class ObjetoListFragment extends BaseFragment implements ObjetoListInterface.View {

    @BindView(R.id.demanda_nova_objeto_list)
    RecyclerView objetoList;

    @BindView(R.id.demanda_nova_objeto_null)
    RelativeLayout nullLayout;

    @BindView(R.id.demanda_nova_objeto_btn_novo)
    MaterialButton btnNovo;

    @BindView(R.id.demanda_nova_objeto_btn_proximo)
    MaterialButton btnProximo;

    private ObjetoListInterface.Presenter mPresenter;

    private View view;

    public ObjetoListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_objeto_list, container, false);

        ((DemandaNovaActivity) getActivity()).getSupportActionBar().setTitle("lista de objetos");

        new ObjetoListPresenter(this, ((DemandaNovaActivity) getActivity()));

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((DemandaNovaActivity) getActivity()).getSupportActionBar().setTitle("lista de objetos");
        mPresenter.subscribe();
        getActivity().getFilesDir().delete();
    }

    @Override
    public void setPresenter(ObjetoListInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onAdicionarErro(String erro) {

    }

    @Override
    public void onProximo() {

    }

    @Override
    public void populateView(ObjetoListAdapter adapter) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        objetoList.setLayoutManager(layoutManager);
        objetoList.setAdapter(adapter);
        objetoList.addItemDecoration(new DividerItemDecoration(objetoList.getContext(), DividerItemDecoration.VERTICAL));

        if (adapter.getItemCount() == 0) {
            objetoList.setVisibility(View.INVISIBLE);
            nullLayout.setVisibility(View.VISIBLE);
        } else {
            btnProximo.setVisibility(View.VISIBLE);
            objetoList.setVisibility(View.VISIBLE);
            nullLayout.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void update() {
        mPresenter.subscribe();
    }

    @Override
    public void onItemClick(View view, int position) {
        System.out.println(position);
    }

    @OnClick(R.id.demanda_nova_objeto_btn_proximo)
    public void onProximoClick() {
        mPresenter.moveToDemandaForm();
    }

    @OnClick(R.id.demanda_nova_objeto_btn_novo)
    public void onNovoClick() {
        mPresenter.moveToObjetoNovo();
    }

}
