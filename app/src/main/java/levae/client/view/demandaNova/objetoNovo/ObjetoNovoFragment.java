package levae.client.view.demandaNova.objetoNovo;


import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.util.ContextUtil;
import levae.client.core.util.EditTextUtils;
import levae.client.view.demandaNova.DemandaNovaActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObjetoNovoFragment extends BaseFragment implements ObjetoNovoInterface.View {

    @BindView(R.id.objeto_novo_til_titulo)
    TextInputLayout tilTitulo;

    @BindView(R.id.objeto_novo_et_titulo)
    TextInputEditText etTitulo;

    @BindView(R.id.objeto_novo_til_valor)
    TextInputLayout tilValor;

    @BindView(R.id.objeto_novo_et_valor)
    TextInputEditText etValor;

    @BindView(R.id.objeto_novo_btn_adicionar)
    MaterialButton btnAdicionar;

    @BindView(R.id.objeto_novo_btn_camera)
    MaterialButton btnFoto;

    @BindView(R.id.objeto_novo_img)
    ImageView imgObjeto;

    private ObjetoNovoInterface.Presenter mPresenter;

    public ObjetoNovoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_objeto_novo, container, false);

        ((DemandaNovaActivity) getActivity()).getSupportActionBar().setTitle("adicionar objeto");

        ButterKnife.bind(this, view);

        new ObjetoNovoPresenter(this, (DemandaNovaActivity) getActivity());

        return view;
    }

    @OnClick(R.id.objeto_novo_btn_adicionar)
    public void onAdicionarClick() {
        EditTextUtils.cleanError(tilTitulo, tilValor);
        if (mPresenter.onAdicionar(etTitulo.getText().toString(), etValor.getText().toString())) {
            mPresenter.backToList();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick(R.id.objeto_novo_btn_camera)
    public void onCameraClick() {

        if (ContextCompat.checkSelfPermission(ContextUtil.getContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    100);
        } else {
            PickSetup setup = new PickSetup();
            setup.setTitle("adicione uma foto")
                    .setFlip(false)
                    .setTitleColor(ResourcesCompat.getColor(getResources(), R.color.textColorSecondary, null))
                    .setCameraButtonText("câmera")
                    .setGalleryButtonText("galeria")
                    .setCancelText("cancelar")
                    .setProgressText("em progresso");
            PickImageDialog.build(setup).show(this.getFragmentManager()).setOnPickResult(pickResult -> {
                if (pickResult.getError() == null)
                    mPresenter.resizeImg(getContext(), pickResult.getUri());
            });
        }
    }

    @Override
    public void setTituloError(String error) {
        EditTextUtils.setError(tilTitulo, error);
    }

    @Override
    public void setFotoError(String error) {
        showSnack(error);
    }

    @Override
    public void setValorError(String error) {
        EditTextUtils.setError(tilValor, error);
    }

    @Override
    public void setImage(Uri img) {
        Picasso.get().load(img).centerCrop().fit().into(imgObjeto);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, R.id.objeto_novo_img);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);

        btnAdicionar.setLayoutParams(params);
        btnFoto.setVisibility(View.INVISIBLE);
        imgObjeto.setVisibility(View.VISIBLE);
    }

    @Override
    public void setPresenter(ObjetoNovoInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
