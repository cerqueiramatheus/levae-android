package levae.client.view.historico;


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
public class HistoricoFragment extends BaseFragment implements HistoricoInterface.View {


    public HistoricoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historico, container, false);
    }

    @Override
    public void setPresenter(HistoricoInterface.Presenter presenter) {

    }
}
