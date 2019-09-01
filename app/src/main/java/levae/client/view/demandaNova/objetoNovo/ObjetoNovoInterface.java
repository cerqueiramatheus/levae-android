package levae.client.view.demandaNova.objetoNovo;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.vansuita.pickimage.listeners.IPickResult;

import java.io.File;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;

/**
 * Created by txring on 07/08/2019.
 */
class ObjetoNovoInterface {

    interface View extends BaseView<Presenter> {

        void setTituloError(String error);

        void setFotoError(String error);

        void setValorError(String error);

        void setImage(Uri img);
    }

    interface Presenter extends BasePresenter {

        boolean onAdicionar(String titulo, String valor);

        void backToList();


        void resizeImg(Context context, Uri img);

    }
}
