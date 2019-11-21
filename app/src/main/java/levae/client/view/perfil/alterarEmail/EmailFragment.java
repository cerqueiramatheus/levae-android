package levae.client.view.perfil.alterarEmail;

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

public class EmailFragment extends BaseFragment implements EmailInterface.View {

    @BindView(R.id.alterar_email_et_text)
    TextInputEditText alterarEmailEtNumero;

    @BindView(R.id.alterar_email_til_text)
    TextInputLayout alterarEmailTilNumero;

    @BindView(R.id.alterar_email_layout)
    RelativeLayout alterarEmailLayout;

    private CustomProgressBar customProgressBar;

    private EmailInterface.Presenter mPresenter;

    private PerfilInterface.View mRoot;

    public EmailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_email, container, false);

        ButterKnife.bind(this, view);

        mRoot = (PerfilActivity) getActivity();

        ((PerfilActivity) getActivity()).getSupportActionBar().setTitle("alterar e-mail");

        customProgressBar = new CustomProgressBar(getActivity(), alterarEmailLayout, CustomProgressBar.ProgressBarEnum.HORIZONTAL, false);

        new EmailPresenter(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(EmailInterface.Presenter presenter) {
        mPresenter = presenter;
    }

    @OnClick(R.id.alterar_email_btn_confirmar)
    public void onViewClicked() {
        customProgressBar.show();
        mPresenter.checkEmail(alterarEmailEtNumero.getText().toString());
    }

    @Override
    public void onSuccess() {
        System.out.println("akjdfjksd");
        customProgressBar.hide();
        mRoot.back(this);
    }

    @Override
    public void onError(String message) {
        customProgressBar.hide();
        EditTextUtils.setError(alterarEmailTilNumero, message);
    }

    @Override
    public void setEmail(String email) {
        alterarEmailEtNumero.setText(email);
    }
}
