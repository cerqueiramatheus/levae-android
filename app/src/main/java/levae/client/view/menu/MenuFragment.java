package levae.client.view.menu;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.enums.MenuEnum;
import levae.client.view.pagamento.MenuAdapter;
import levae.client.view.pagamento.PagamentoActivity;

/**
 * A simple {@link Fragment} subclass.
 */

public class MenuFragment extends BaseFragment implements MenuInterface.View {

    @BindView(R.id.fragment_menu_recycler)
    RecyclerView mRecycler;

    private MenuInterface.Presenter mPresenter;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this, mView);

        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.setAdapter(new MenuAdapter(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(mRecycler.getContext(), DividerItemDecoration.VERTICAL));

        new MenuPresenter(this);

        return mView;
    }

    @Override
    public void setPresenter(MenuInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onItemClick(View view, int position) {

        MenuEnum row = MenuEnum.values()[position];

        switch (row) {

            case SHARE:
                break;

            case CARD:
                System.out.println("cartãaaaaao");
                mPresenter.onCartoesClick();
                break;

            case INFO:
                break;

        }

        System.out.println(position);
    }

    @Override
    public void startCartoes() {
        Intent intent = new Intent(this.getActivity(), PagamentoActivity.class);
        startActivity(intent);
    }

    @Override
    public void startCompartilhar() {

    }

    @Override
    public void startSobre() {

    }
}
