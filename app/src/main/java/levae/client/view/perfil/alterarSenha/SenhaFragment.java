package levae.client.view.perfil.alterarSenha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.util.EditTextUtils;
import levae.client.view.perfil.PerfilActivity;
import levae.client.view.perfil.PerfilInterface;

public class SenhaFragment extends BaseFragment implements SenhaInterface.View {

    @BindView(R.id.alterar_senha_et_senha)
    TextInputEditText alterarSenhaEtSenha;

    @BindView(R.id.alterar_senha_til_senha)
    TextInputLayout alterarSenhaTilSenha;

    @BindView(R.id.alterar_senha_et_nova)
    TextInputEditText alterarSenhaEtNova;

    @BindView(R.id.alterar_senha_til_nova)
    TextInputLayout alterarSenhaTilNova;

    private SenhaInterface.Presenter mPresenter;

    private PerfilInterface.View mRoot;

    public SenhaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_senha, container, false);

        ButterKnife.bind(this, view);

        mRoot = (PerfilActivity) getActivity();

        ((PerfilActivity) getActivity()).getSupportActionBar().setTitle("alterar senha");

        new SenhaPresenter(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(SenhaInterface.Presenter presenter) {
        mPresenter = presenter;
    }

    @OnClick(R.id.alterar_senha_btn_confirmar)
    public void onViewClicked() {
        mPresenter.checkSenhas(alterarSenhaEtSenha.getText().toString(), alterarSenhaEtNova.getText().toString());
    }

    @Override
    public void onSuccess() {
        mRoot.back(this);
    }

    @Override
    public void setVelhaError(String msg) {
        EditTextUtils.setError(alterarSenhaTilSenha, msg);
    }

    @Override
    public void setNovaError(String msg) {
        EditTextUtils.setError(alterarSenhaTilNova, msg);
    }
}
