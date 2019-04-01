package levae.client.view.entrada.cadastro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.view.entrada.EntradaContract;

public class CadastroFragment extends BaseFragment implements EntradaContract.CadastroViewInterface<CadastroPresenter> {

    private EntradaContract.CadastroPresenterInterface mPresenter;
    private View root;

    public CadastroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);
        return root;
    }

    @Override
    public void setPresenter(EntradaContract.CadastroPresenterInterface presenter) {
        mPresenter = presenter;
    }

    @Override
    public void toLogin() {

    }

    public static CadastroFragment novaInstancia() {
        return new CadastroFragment();
    }
}