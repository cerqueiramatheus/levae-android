package levae.client.core.pagarme;

/**
 * Created by txring on 06/08/2019.
 */
public interface CreditCardInterface {
    void onSuccess(String token);

    void onError();
}
