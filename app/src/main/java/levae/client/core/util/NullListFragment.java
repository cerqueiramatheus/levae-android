package levae.client.core.util;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import levae.client.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NullListFragment extends Fragment {


    public NullListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_null_list, container, false);
    }

}
