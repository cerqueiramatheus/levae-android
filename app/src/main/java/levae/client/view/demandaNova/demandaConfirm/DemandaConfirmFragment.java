package levae.client.view.demandaNova.demandaConfirm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.util.CustomDialog;
import levae.client.core.util.CustomProgressBar;
import levae.client.view.demandaNova.DemandaNovaActivity;

public class DemandaConfirmFragment extends BaseFragment implements DemandaConfirmInterface.View {

    @BindView(R.id.demanda_confirm_txt_valor_total)
    TextView demandaConfirmTxtValorTotal;

    @BindView(R.id.demanda_confirm_txt_origem_local)
    TextView demandaConfirmTxtOrigemLocal;

    @BindView(R.id.demanda_confirm_txt_origem_data)
    TextView demandaConfirmTxtOrigemData;

    @BindView(R.id.demanda_confirm_txt_destino_local)
    TextView demandaConfirmTxtDestinoLocal;

    @BindView(R.id.demanda_confirm_txt_destino_data)
    TextView demandaConfirmTxtDestinoData;

    @BindView(R.id.demanda_confirm_btn_finalizar)
    ExtendedFloatingActionButton demandaConfirmBtnFinalizar;

    @BindView(R.id.demanda_confirm_et_cartao)
    TextInputEditText demandaConfirmEtCartao;

    @BindView(R.id.demanda_confirm_til_cartao)
    TextInputLayout demandaConfirmTilCartao;

    @BindView(R.id.demanda_confirm_valor_objeto_list)
    TextView demandaConfirmValorObjetoList;

    @BindView(R.id.demanda_confirm_layout)
    RelativeLayout mLayout;

    private String txt;

    private int resId;

    private DemandaConfirmInterface.Presenter mPresenter;

    private View view;

    private CustomProgressBar customProgressBar;

    private CustomDialog customDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_demanda_confirm, container, false);

        ButterKnife.bind(this, view);

        new DemandaConfirmPresenter(this, (DemandaNovaActivity) getActivity(), view.getContext());
        mPresenter.subscribe();


        ((DemandaNovaActivity) getActivity()).getSupportActionBar().setTitle("confirmação");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (txt != null) {
            demandaConfirmEtCartao.setHint(null);
            demandaConfirmEtCartao.setText(txt);
            demandaConfirmEtCartao.setCompoundDrawablesRelativeWithIntrinsicBounds(resId, 0, 0, 0);
        }
    }

    @Override
    public void setPresenter(DemandaConfirmInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void setValorTotal(String valor) {
        demandaConfirmTxtValorTotal.setText(valor);
    }

    @Override
    public void setEntregaLocal(String entregaLocal) {
        demandaConfirmTxtDestinoLocal.setText(entregaLocal);
    }

    @Override
    public void setColetaLocal(String coletaLocal) {
        demandaConfirmTxtOrigemLocal.setText(coletaLocal);
    }

    @Override
    public void setEntregaData(String entregaData) {
        demandaConfirmTxtDestinoData.setText(entregaData);
    }

    @Override
    public void setColetaData(String coletaData) {
        demandaConfirmTxtOrigemData.setText(coletaData);
    }

    @Override
    public void update() {
        mPresenter.update();
    }

    @Override
    public void setEtPagamento(int resId, String txt) {
        this.txt = txt;
        this.resId = resId;
        showSnack(txt);
    }

    @Override
    public void message(String msg) {
        customProgressBar.hide();
        showSnack(msg);
    }

    @Override
    public void setObjetos(String objetos) {
        demandaConfirmValorObjetoList.setText(objetos);
    }

    @Override
    public void showConfirmation(String c) {
        customProgressBar.hide();
        while (showSnack(c).isShown()) {

        }
        mPresenter.end();
    }

    @Override
    public void onConfirm() {
        customProgressBar = new CustomProgressBar(getActivity(), mLayout, CustomProgressBar.ProgressBarEnum.CIRCULAR);
        customProgressBar.show();
        mPresenter.inserir();
    }


    @OnClick({R.id.demanda_confirm_et_cartao, R.id.demanda_confirm_btn_finalizar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.demanda_confirm_et_cartao:
                mPresenter.moveToPagamento();
                break;
            case R.id.demanda_confirm_btn_finalizar:
                customDialog = new CustomDialog(getActivity(), "deseja confirmar esta demanda?", "sim, confirmar", "ainda não", new CustomDialog.CustomDialogInterface() {
                    @Override
                    public void onAccepted() {
                        customDialog.hide();
                        onConfirm();
                    }

                    @Override
                    public void onRefused() {
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
                break;
        }
    }

}