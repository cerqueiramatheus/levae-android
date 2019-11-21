package levae.client.core.util;

import com.stepstone.apprating.AppRatingDialog;

import java.util.Arrays;

import levae.client.R;

/**
 * Created by txring on 29/10/2019.
 */
public class CustomRatingDialog {

    public static AppRatingDialog.Builder getDialog() {
        return new AppRatingDialog.Builder()
                .setPositiveButtonText("confirmar")
                .setNegativeButtonText("cancelar")
                .setNoteDescriptions(Arrays.asList("péssima", "ruim", "ok", "boa", "excelente"))
                .setDefaultRating(2)
                .setTitle("avalie esta demanda")
                .setDescription("selecione estrelas e dê sua opinião")
                .setCommentInputEnabled(true)
                .setStarColor(R.color.colorPrimary)
                .setNoteDescriptionTextColor(R.color.textColorSecondary)
                .setTitleTextColor(R.color.textColorSecondary)
                .setDescriptionTextColor(R.color.textColorSecondary)
                .setHint("escreva sua opinião aqui")
                .setDefaultComment("ocorreu tudo dentro do esperado.")
                .setHintTextColor(R.color.textColorSecondary)
                .setCommentTextColor(R.color.textColorSecondary)
                .setCommentBackgroundColor(R.color.textColorPrimary)
                .setWindowAnimation(R.style.MyDialogFadeAnimation)
                .setCancelable(false)
                .setCanceledOnTouchOutside(false);
    }
}
