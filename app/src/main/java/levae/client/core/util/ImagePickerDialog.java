package levae.client.core.util;

import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;

/**
 * Created by txring on 19/04/2019.
 */
public class ImagePickerDialog {

    public static PickImageDialog getDialog() {

        PickSetup pickSetup = new PickSetup();
        pickSetup.setCancelText("cancelar");
        pickSetup.setProgressText("em andamento");
        pickSetup.setCameraButtonText("Câmera");
        pickSetup.setGalleryButtonText("Galeria");
        pickSetup.setTitle("Escolha");
        return PickImageDialog.build(pickSetup);
    }
}
