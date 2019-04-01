package levae.client.core.token;

import java.io.Serializable;

/**
 * Created by txring on 19/06/2018.
 */
public class Token implements Serializable {

    private String token;

    @Override
    public String toString() {
        return token;
    }
}
