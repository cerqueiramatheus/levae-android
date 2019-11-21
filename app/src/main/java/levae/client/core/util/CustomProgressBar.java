package levae.client.core.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import levae.client.R;

/**
 * Created by txring on 04/08/2019.
 */
public class CustomProgressBar {

    private ProgressBar mProgressBar;
    private Activity mActivity;
    private RelativeLayout.LayoutParams params;
    private ViewGroup mViewGroup;
    private boolean touchable = false;

    public CustomProgressBar(Activity activity, ViewGroup layout, ProgressBarEnum option, boolean isLight) {

        this.mActivity = activity;
        this.mViewGroup = layout;

        if (isLight) {
            if (option == ProgressBarEnum.CIRCULAR) {
                mProgressBar = (ProgressBar) mActivity.getLayoutInflater().inflate(R.layout.progress_bar_circular_light, null);
                params = new RelativeLayout.LayoutParams(100, 100);
                params.addRule(RelativeLayout.CENTER_IN_PARENT);
            } else if (option == ProgressBarEnum.HORIZONTAL) {
                mProgressBar = (ProgressBar) mActivity.getLayoutInflater().inflate(R.layout.progress_bar_horizontal_light, null);
                params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            }
        } else {
            if (option == ProgressBarEnum.CIRCULAR) {
                mProgressBar = (ProgressBar) mActivity.getLayoutInflater().inflate(R.layout.progress_bar_circular_dark, null);
                params = new RelativeLayout.LayoutParams(100, 100);
                params.addRule(RelativeLayout.CENTER_IN_PARENT);
            } else if (option == ProgressBarEnum.HORIZONTAL) {
                mProgressBar = (ProgressBar) mActivity.getLayoutInflater().inflate(R.layout.progress_bar_horizontal_dark, null);
                params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            }
        }

    }

    public void show() {
        if (mProgressBar.getVisibility() == View.INVISIBLE || !mProgressBar.isAttachedToWindow()) {
            mViewGroup.addView(mProgressBar, params);
            mProgressBar.setVisibility(View.VISIBLE);

            if (!touchable) {
                mActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        }
    }

    public void hide() {
        if (mProgressBar.getVisibility() == View.VISIBLE) {
            mViewGroup.removeView(mProgressBar);
            mProgressBar.setVisibility(View.INVISIBLE);
            mActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }

    public void setTouchable() {
        touchable = true;
    }

    public enum ProgressBarEnum {

        CIRCULAR(0),
        HORIZONTAL(1);

        private int mOption;

        ProgressBarEnum(int option) {
            this.mOption = option;
        }
    }
}