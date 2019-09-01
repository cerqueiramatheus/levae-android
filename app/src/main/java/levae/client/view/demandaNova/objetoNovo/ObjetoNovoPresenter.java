package levae.client.view.demandaNova.objetoNovo;

import android.content.Context;
import android.net.Uri;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import id.zelory.compressor.Compressor;
import levae.client.core.model.demanda.Objeto;
import levae.client.view.demandaNova.DemandaNovaInterface;

/**
 * Created by txring on 07/08/2019.
 */
public class ObjetoNovoPresenter implements ObjetoNovoInterface.Presenter {

    private ObjetoNovoInterface.View mView;
    private DemandaNovaInterface.View mRoot;
    private File objectPicture;

    ObjetoNovoPresenter(ObjetoNovoInterface.View view, DemandaNovaInterface.View root) {
        this.mRoot = root;
        this.mView = view;
        objectPicture = null;
        mView.setPresenter(this);
    }

    @Override
    public boolean onAdicionar(String titulo, String valor) {

        boolean valida = false;

        if (titulo != null) {
            if (!titulo.equals("") && titulo.length() > 1) {
                valida = true;
            } else {
                mView.setTituloError("título inválido");
            }
        } else {
            mView.setTituloError("título inválido");
        }

        if (valor != null) {
            if (!valor.equals("") && valor.length() > 1) {
                valida = true;
            } else {
                mView.setValorError("valor inválido");
            }
        } else {
            mView.setValorError("valor inválido");
        }

        if (objectPicture == null) {
            mView.setFotoError("tire uma foto do seu objeto");
            valida = false;
        }

        if (valida) {
            Objeto objeto = new Objeto();
            objeto.setTitulo(titulo);
            objeto.setFoto(objectPicture);
            objeto.setValor(Double.valueOf(valor));
            mRoot.addObjeto(objeto);
        }

        return valida;

    }

    @Override
    public void backToList() {
        mRoot.backToList();
    }

    @Override
    public void resizeImg(Context context, Uri img) {

        File file = new File(Objects.requireNonNull(img.getPath()));

        try {

            objectPicture = new Compressor(context).compressToFile(file);
            mView.setImage(Uri.fromFile(objectPicture));
            System.out.println(objectPicture.length());

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}