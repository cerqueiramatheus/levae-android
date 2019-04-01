package levae.client.core.pagarme;

import android.webkit.JavascriptInterface;

/**
 * Created by txring on 10/03/2019.
 */

public class CreditCard  {

    private String cardNumber;
    private String name;
    private String month;
    private String year;
    private String cvv;
    private int parcels;
    private boolean error;
    private String token;

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
    public int getParcels() {
        return parcels;
    }

    public void setParcels(int parcels) {
        this.parcels = parcels;
    }

    public boolean getError() {
        return error;
    }

    @JavascriptInterface
    public void setError(boolean error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    @JavascriptInterface
    public void setToken(String token) {
        this.token = token;
        System.out.println("OLHA O TOKEN DESTA DESGRAÇA" +token);
    }
}