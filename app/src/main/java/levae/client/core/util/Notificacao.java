package levae.client.core.util;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by txring on 16/01/2019.
 */
public class Notificacao extends FirebaseMessagingService {

    public Notificacao() {
        super();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        System.out.println("Não tinha medo tal João de Santo Cristo");
    }
}
