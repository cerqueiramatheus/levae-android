package levae.client.core.util;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import levae.client.R;

/**
 * Created by txring on 05/08/2019.
 */
public class CustomDialog extends BottomSheetDialog {

    @BindView(R.id.bottom_dialog_title)
    TextView tvTitle;

    @BindView(R.id.bottom_dialog_confirm)
    TextView tvConfirm;

    @BindView(R.id.bottom_dialog_cancel)
    TextView tvCancel;

    @BindView(R.id.bottom_dialog_row_confirm)
    LinearLayout rowConfirm;

    @BindView(R.id.bottom_dialog_row_cancel)
    LinearLayout rowCancel;

    private BottomSheetDialog mBottomDialog;

    public CustomDialog(Activity activity, String title, String positive, String negative, CustomDialogInterface customDialogInterface) {

        super(activity);

        mBottomDialog = new BottomSheetDialog(activity);
        View sheetView = activity.getLayoutInflater().inflate(R.layout.bottom_dialog, null);
        mBottomDialog.setContentView(sheetView);

        ButterKnife.bind(this, sheetView);

        tvTitle.setText(title);

        tvCancel.setText(negative);
        rowCancel.setOnClickListener(view -> {
            System.out.println("cancela");
            customDialogInterface.onRefused();
        });

        tvConfirm.setText(positive);
        rowConfirm.setOnClickListener(view -> {
            System.out.println("confirma");
            customDialogInterface.onAccepted();
        });
    }

    public void show() {
        if (!mBottomDialog.isShowing()) {
            mBottomDialog.show();
        }
    }

    public void hide() {
        if (mBottomDialog.isShowing()) {
            mBottomDialog.hide();
        }
    }

    public interface CustomDialogInterface {
        void onAccepted();

        void onRefused();
    }
}