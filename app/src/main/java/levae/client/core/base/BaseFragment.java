
package levae.client.core.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import levae.client.R;

public class BaseFragment extends Fragment {

    private BaseActivity mActivity;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
        }
    }

    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    public Snackbar showSnack(String msg) {
        return mActivity.showSnack(msg);
    }

    public boolean checkConnection() {
        if (mActivity != null) {
            return mActivity.checkConnection();
        }
        return false;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    public void voltaLogin() {
        if (mActivity != null) {
            mActivity.voltaLogin();
        }
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }
}