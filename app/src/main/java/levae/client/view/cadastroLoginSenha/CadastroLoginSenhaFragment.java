package levae.client.view.cadastroLoginSenha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.util.EditTextUtils;
import levae.client.view.cadastro.CadastroActivity;
import levae.client.view.cadastro.CadastroInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroLoginSenhaFragment extends Fragment implements CadastroLoginSenhaInterface.View {

    @BindView(R.id.cadastro_btn_cadastro)
    MaterialButton btnCadastrar;

    @BindView(R.id.cadastro_et_email)
    TextInputEditText etEmail;

    @BindView(R.id.cadastro_til_email)
    TextInputLayout tilEmail;

    @BindView(R.id.cadastro_et_senha)
    TextInputEditText etSenha;

    @BindView(R.id.cadastro_til_senha)
    TextInputLayout tilSenha;

    @BindView(R.id.cadastro_et_senha_confirma)
    TextInputEditText etSenhaConfirma;

    @BindView(R.id.cadastro_til_senha_confirma)
    TextInputLayout tilSenhaConfirma;

    private CadastroLoginSenhaInterface.Presenter mPresenter;

    private CadastroInterface.View mView;

    public CadastroLoginSenhaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastro_login_senha, container, false);
        ButterKnife.bind(this, view);
        mView = (CadastroActivity) getActivity();
        if (mPresenter == null) {
            mPresenter = new CadastroLoginSenhaPresenter(this);
        }
        return view;
    }

    @OnClick(R.id.cadastro_btn_cadastro)
    void cadastrar() {
        mPresenter.verificaLoginSenha(
                EditTextUtils.getString(etEmail),
                EditTextUtils.getString(etSenha),
                EditTextUtils.getString(etSenhaConfirma)
        );
    }


    @Override
    public void onCadastrar(String email, String senha) {
        mView.setLoginSenha(email, senha);
    }

    @Override
    public void onEmailErro(String msg) {

    }

    @Override
    public void onSenhaErro(String msg) {

    }

    @Override
    public void onSenhaConfirmaErro(String msg) {

    }

    @Override
    public void setPresenter(CadastroLoginSenhaInterface.Presenter presenter) {
        mPresenter = presenter;
    }
}