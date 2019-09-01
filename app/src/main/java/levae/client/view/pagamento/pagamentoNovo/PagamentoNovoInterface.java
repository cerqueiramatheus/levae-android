package levae.client.view.pagamento.pagamentoNovo;

import android.webkit.WebView;

import com.google.android.material.textfield.TextInputEditText;

import levae.client.core.base.BasePresenter;
import levae.client.core.base.BaseView;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.pagarme.CreditCardInterface;

/**
 * Created by txring on 22/04/2019.
 */
public interface PagamentoNovoInterface {

    interface View extends BaseView<Presenter>, CreditCardInterface {
        void populateItems(Cartao cartao);

        void setError(String error);

        void onFinished();

        void setNumeroError(String erro);

        void setCvvError(String erro);

        void setValidadeError(String erro);

    }

    interface Presenter extends BasePresenter {
        void cadastrar(String hash);

        void setHash(WebView webView, String validade, String cvv, String numero);

        void excluir();

        boolean validaNumero(TextInputEditText etNumero);

        boolean validaCvv(TextInputEditText etCvv);

        boolean validaValidade(TextInputEditText etValidade);
    }
}
