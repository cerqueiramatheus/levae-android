package levae.client.core.pagarme;

import android.webkit.JavascriptInterface;

/**
 * Created by txring on 10/03/2019.
 */

public class CreditCard {

    private String cardNumber;
    private String name;
    private String month;
    private String year;
    private String cvv;
    private CreditCardInterface creditCardInterface;

    public CreditCard(CreditCardInterface creditCardInterface) {
        this.creditCardInterface = creditCardInterface;
    }

    @JavascriptInterface
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JavascriptInterface
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JavascriptInterface
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @JavascriptInterface
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @JavascriptInterface
    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @JavascriptInterface
    public void setError() {
        creditCardInterface.onError();
    }

    @JavascriptInterface
    public void setToken(String token) {
        creditCardInterface.onSuccess(token);
    }

}