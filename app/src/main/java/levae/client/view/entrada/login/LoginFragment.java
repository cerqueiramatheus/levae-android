package levae.client.view.entrada.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.model.usuarios.Usuario;
import levae.client.core.util.ActivityUtils;
import levae.client.view.entrada.EntradaContract;
import levae.client.view.entrada.cadastro.CadastroFragment;

public class LoginFragment extends BaseFragment implements EntradaContract.LoginViewInterface<LoginPresenter> {

    @BindView(R.id.password_edit_text)
    TextInputEditText senha;

    @BindView(R.id.email_edit_text)
    TextInputEditText email;

    private View root;
    private EntradaContract.LoginPresenterInterface mPresenter;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, root);
        (root.findViewById(R.id.btn_logar)).setOnClickListener(__ -> onLogar());
        setPresenter(new LoginPresenter(this));
        return root;
    }

    @Override
    public void toSignUp() {
        ActivityUtils.replaceFragment(getFragmentManager(),
                CadastroFragment.novaInstancia(), R.id.frame_entrada);
    }

    @Override
    public void toMain() {
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                System.out.println("Place: " + place.getName() + ", " + place.getId());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
            }
        });
        
        showSnack("DAORA");
        System.out.println("alog");
    }

    @Override
    public void onErro() {
        showSnack("deu ruim, paê");

    }

    private void onLogar() {
        Usuario u = new Usuario();

        u.setEmail(email.getText().toString());
        u.setSenha(senha.getText().toString());

        mPresenter.logar(u);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.unsubscribe();
    }

    public static LoginFragment novaInstancia() {
        return new LoginFragment();
    }

    @Override
    public void setPresenter(EntradaContract.LoginPresenterInterface presenter) {
        this.mPresenter = presenter;
    }
}