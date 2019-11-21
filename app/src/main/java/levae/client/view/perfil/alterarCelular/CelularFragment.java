package levae.client.view.perfil.alterarCelular;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.util.CustomProgressBar;
import levae.client.core.util.EditTextUtils;
import levae.client.view.perfil.PerfilActivity;
import levae.client.view.perfil.PerfilInterface;

public class CelularFragment extends BaseFragment implements CelularInterface.View {

    @BindView(R.id.alterar_celular_et_numero)
    TextInputEditText alterarCelularEtNumero;

    @BindView(R.id.alterar_celular_til_numero)
    TextInputLayout alterarCelularTilNumero;

    @BindView(R.id.alterar_celular_layout)
    RelativeLayout alterarCelularLayout;

    private CelularInterface.Presenter mPresenter;

    private CustomProgressBar customProgressBar;

    private PerfilInterface.View mRoot;

    public CelularFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_celular, container, false);

        ButterKnife.bind(this, view);

        mRoot = (PerfilActivity) getActivity();

        ((PerfilActivity) getActivity()).getSupportActionBar().setTitle("alterar celular");

        new CelularPresenter(this);

        customProgressBar = new CustomProgressBar(getActivity(), alterarCelularLayout, CustomProgressBar.ProgressBarEnum.CIRCULAR, false);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(CelularInterface.Presenter presenter) {
        mPresenter = presenter;
    }

    @OnClick(R.id.alterar_celular_btn_confirmar)
    public void onViewClicked() {
        customProgressBar.show();
        mPresenter.checkCelular(alterarCelularEtNumero.getText().toString());
    }

    @Override
    public void onSuccess() {
        customProgressBar.hide();
        mRoot.back(this);
    }

    @Override
    public void onError(String message) {
        customProgressBar.hide();
        EditTextUtils.setError(alterarCelularTilNumero, message);
    }

    @Override
    public void setCelular(String celular) {
        alterarCelularEtNumero.setText(celular);
    }
}
