package levae.client.view.demandaNova.demandaForm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.fragment.app.Fragment;

import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.material.picker.MaterialStyledDatePickerDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import levae.client.R;
import levae.client.core.base.BaseFragment;
import levae.client.core.util.DateInputMask;
import levae.client.core.util.EditTextUtils;
import levae.client.core.util.PlacesAutoComplete;
import levae.client.view.demandaNova.DemandaNovaActivity;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class DemandaFormFragment extends BaseFragment implements DemandaFormInterface.View {

    @BindView(R.id.demanda_form_et_coleta_localizacao)
    TextInputEditText etColetaLocalizacao;

    @BindView(R.id.demanda_form_til_coleta_localizacao)
    TextInputLayout tilColetaLocalizacao;

    @BindView(R.id.demanda_form_et_coleta_pessoa)
    TextInputEditText etColetaPessoa;

    @BindView(R.id.demanda_form_til_coleta_pessoa)
    TextInputLayout tilColetaPessoa;

    @BindView(R.id.demanda_form_et_coleta_data)
    TextInputEditText etColetaData;

    @BindView(R.id.demanda_form_til_coleta_data)
    TextInputLayout tilColetaData;

    @BindView(R.id.demanda_form_et_entrega_localizacao)
    TextInputEditText etEntregaLocalizacao;

    @BindView(R.id.demanda_form_til_entrega_localizacao)
    TextInputLayout tilEntregaLocalizacao;

    @BindView(R.id.demanda_form_et_entrega_pessoa)
    TextInputEditText etEntregaPessoa;

    @BindView(R.id.demanda_form_til_entrega_pessoa)
    TextInputLayout tilEntregaPessoa;

    @BindView(R.id.demanda_form_et_entrega_data)
    TextInputEditText etEntregaData;

    @BindView(R.id.demanda_form_til_entrega_data)
    TextInputLayout tilEntregaData;

    @BindView(R.id.demanda_form_tamanho_title)
    TextView tamanhoTitle;

    @BindView(R.id.demanda_form_et_tamanho)
    AppCompatAutoCompleteTextView etTamanho;

    @BindView(R.id.demanda_form_til_tamanho)
    TextInputLayout tilTamanho;

    private DemandaFormInterface.Presenter mPresenter;

    public DemandaFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demanda_form, container, false);
        ButterKnife.bind(this, view);

        etTamanho.setOnItemClickListener((adapterView, view1, i, l) -> mPresenter.setTipoVeiculo(((TextView) view1.findViewById(R.id.row_dropdown_tipo_texto)).getText().toString()));

        etColetaLocalizacao.setKeyListener(null);
        etEntregaLocalizacao.setKeyListener(null);

        etEntregaData.setKeyListener(null);
        etColetaData.setKeyListener(null);

        new DateInputMask(etColetaData);
        new DateInputMask(etEntregaData);

        new DemandaFormPresenter(this, (DemandaNovaActivity) getActivity());
        mPresenter.subscribe();

        ((DemandaNovaActivity) getActivity()).getSupportActionBar().setTitle("formulário");

        return view;
    }

    @SuppressLint("RestrictedApi")
    @OnClick({R.id.demanda_form_et_coleta_localizacao,
            R.id.demanda_form_et_entrega_localizacao,
            R.id.demanda_form_btn_proximo,
            R.id.demanda_form_et_coleta_data,
            R.id.demanda_form_et_entrega_data})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.demanda_form_et_coleta_localizacao:
                new PlacesAutoComplete(this, 1);
                break;

            case R.id.demanda_form_et_entrega_localizacao:
                new PlacesAutoComplete(this, 2);
                break;

            case R.id.demanda_form_btn_proximo:
                EditTextUtils.cleanError(tilColetaData, tilColetaLocalizacao, tilColetaPessoa, tilEntregaData, tilEntregaLocalizacao, tilEntregaPessoa, tilTamanho);
                if (mPresenter.validaCampos(etEntregaPessoa.getText().toString(),
                        etColetaPessoa.getText().toString())) mPresenter.moveToConfirmacao();
                break;

            case R.id.demanda_form_et_coleta_data:
                new MaterialStyledDatePickerDialog(getContext(), R.style.DialogTheme,
                        (datePicker, i, i1, i2) -> mPresenter.setColetaData(i, i1, i2),
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_WEEK))
                        .show();
                break;

            case R.id.demanda_form_et_entrega_data:
                new MaterialStyledDatePickerDialog(getContext(), R.style.DialogTheme,
                        (datePicker, i, i1, i2) -> mPresenter.setEntregaData(i, i1, i2),
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_WEEK))
                        .show();
                break;
        }
    }

    @Override
    public void setEntregaNome(String nome) {
        etEntregaLocalizacao.setText(nome);
    }

    @Override
    public void setEntregaNomeErro(String erro) {
        EditTextUtils.setError(tilEntregaLocalizacao, erro);
    }

    @Override
    public void setColetaNome(String nome) {
        etColetaLocalizacao.setText(nome);
    }

    @Override
    public void setColetaNomeErro(String erro) {
        EditTextUtils.setError(tilColetaLocalizacao, erro);
    }

    @Override
    public void setListaVeiculo(ArrayList<String> tipoVeiculo) {
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.row_dropdown_tipo, tipoVeiculo);
        etTamanho.setAdapter(arrayAdapter);
    }

    @Override
    public void setColetaPessoaErro(String erro) {
        EditTextUtils.setError(tilColetaPessoa, erro);
    }

    @Override
    public void setEntregaPessoaErro(String erro) {
        EditTextUtils.setError(tilEntregaPessoa, erro);
    }

    @Override
    public void setColetaDataErro(String erro) {
        EditTextUtils.setError(tilColetaData, erro);
    }

    @Override
    public void setEntregaDataErro(String erro) {
        EditTextUtils.setError(tilEntregaData, erro);
    }

    @Override
    public void setTipoVeiculoErro(String erro) {
        EditTextUtils.setError(tilTamanho, erro);
    }

    @Override
    public void setTipoVeiculoNome(String nome) {
        etTamanho.setText(nome);
    }

    @Override
    public void setDataColeta(String data) {
        etColetaData.setText(data);
    }

    @Override
    public void setDataEntrega(String data) {
        etEntregaData.setText(data);
    }

    @Override
    public void setPresenter(DemandaFormInterface.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                mPresenter.setColetaPlace(Autocomplete.getPlaceFromIntent(data));
            }
        } else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                mPresenter.setEntregaPlace(Autocomplete.getPlaceFromIntent(data));
            }
        }
    }
}
