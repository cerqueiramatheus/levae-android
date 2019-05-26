package levae.client.view.perfil;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import levae.client.R;
import levae.client.core.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends BaseFragment implements PerfilInterface.View {


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void setPresenter(PerfilInterface.Presenter presenter) {

    }
}
