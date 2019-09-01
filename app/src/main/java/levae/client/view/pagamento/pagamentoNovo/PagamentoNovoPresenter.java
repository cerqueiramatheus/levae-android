package levae.client.view.pagamento.pagamentoNovo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import levae.client.core.interactor.CartaoInteractor;
import levae.client.core.model.pagamento.Cartao;
import levae.client.core.pagarme.CreditCard;
import levae.client.core.util.Constantes;
import levae.client.core.util.UserUtils;

/**
 * Created by txring on 22/04/2019.
 */
public class PagamentoNovoPresenter implements PagamentoNovoInterface.Presenter {

    private PagamentoNovoInterface.View mView;
    private CreditCard creditCard;
    private Cartao cartao;
    private CompositeDisposable mCompositeDisposable;

    PagamentoNovoPresenter(PagamentoNovoInterface.View view, Bundle bundle) {
        this.mView = view;
        mView.setPresenter(this);
        cartao = (Cartao) bundle.get("cartao");
        mView.populateItems(cartao);
        creditCard = new CreditCard(mView);
        mCompositeDisposable = new CompositeDisposable();
    }

    PagamentoNovoPresenter(PagamentoNovoInterface.View view) {
        this.mView = view;
        mView.setPresenter(this);
        creditCard = new CreditCard(mView);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
        mCompositeDisposable.dispose();
    }

    @Override
    public void cadastrar(String hash) {
        mCompositeDisposable.add(new CartaoInteractor().cadastrar(hash).subscribeWith(new DisposableSingleObserver<Cartao>() {
            @Override
            public void onSuccess(Cartao cartao) {
                if (cartao.getIdCartao() != 0) {
                    mView.onFinished();
                } else {
                    mView.setError(cartao.getEstado());
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.setError("erro");
            }
        }));
    }

    @Override
    public boolean validaNumero(TextInputEditText etNumero) {

        if (etNumero.getText() == null || (etNumero.getText().toString().equals(""))) {
            mView.setNumeroError("número vazio");
            return false;
        } else if (etNumero.getText().toString().length() < 19) {
            mView.setNumeroError("número incompleto");
            return false;
        }
        return true;
    }

    @Override
    public boolean validaCvv(TextInputEditText etCvv) {

        if ((etCvv.getText() == null || etCvv.getText().toString().equals(""))) {
            mView.setCvvError("CVV vazio");
            return false;
        } else if (etCvv.getText().toString().length() < 3) {
            mView.setCvvError("CVV incompleto");
            return false;
        }
        return true;
    }

    @Override
    public boolean validaValidade(TextInputEditText etValidade) {

        if ((etValidade.getText() == null || etValidade.getText().toString().equals(""))) {
            mView.setValidadeError("data vazia");
            return false;
        } else if (etValidade.getText().toString().length() < 5) {
            mView.setValidadeError("data incompleta");
            return false;
        } else if (
                (
                        (Integer.parseInt(etValidade.getText().toString().charAt(0) +
                                (Character.toString((etValidade.getText().toString().charAt(1)))))) > 12)) {
            mView.setValidadeError("mês inválido");
            return false;
        } else if (
                ((Integer.parseInt("20" + etValidade.getText().toString().charAt(3) +
                        (etValidade.getText().toString().charAt(4))))
                        < Calendar.getInstance().get(Calendar.YEAR))) {

            mView.setValidadeError("ano retroativo");
            return false;
        }
        return true;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void setHash(WebView webView, String validade, String cvv, String numero) {
        creditCard.setCardNumber(numero);
        creditCard.setCvv(cvv);
        creditCard.setMonth((String.valueOf(validade.charAt(0)) + validade.charAt(1)));
        creditCard.setYear(String.valueOf(validade.charAt(3)) + validade.charAt(4));
        creditCard.setName(UserUtils.getCliente().getNome());

        System.out.println(creditCard.getYear());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(creditCard, "Android");

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage.lineNumber() == 60) {
                    mView.setError("cartão inválido");
                }
                return super.onConsoleMessage(consoleMessage);
            }
        });
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void excluir() {
        mCompositeDisposable.add(new CartaoInteractor().inativar(cartao).subscribeWith(new DisposableSingleObserver<Cartao>() {
            @Override
            public void onSuccess(Cartao cartao) {
                if (cartao.getEstado().equals(Constantes.CARTAO_INATIVO)) {
                    mView.onFinished();
                } else {
                    mView.setError(cartao.getEstado());
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.setError("traaaaaaaaaaaaaaaa");

            }
        }));
    }
}
