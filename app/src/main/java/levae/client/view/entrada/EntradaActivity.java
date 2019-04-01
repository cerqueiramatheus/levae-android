package levae.client.view.entrada;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

import androidx.annotation.NonNull;
import levae.client.R;
import levae.client.core.base.BaseActivity;
import levae.client.core.pagarme.CreditCard;
import levae.client.core.util.ActivityUtils;
import levae.client.view.entrada.login.LoginFragment;
import levae.client.view.entrada.login.LoginPresenter;

public class EntradaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        /*LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_entrada);

        if (loginFragment == null) {
            loginFragment = LoginFragment.novaInstancia();
            ActivityUtils.addFragment(getSupportFragmentManager(),
                    loginFragment, R.id.frame_entrada);
        }
        new LoginPresenter(loginFragment);*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        CreditCard creditCard = new CreditCard();
        Button b = findViewById(R.id.button);

        b.setOnClickListener(v -> {
            creditCard.setCardNumber("4001786300771149");
            creditCard.setCvv("712");
            creditCard.setMonth("12");
            creditCard.setYear("2021");
            creditCard.setName("Matheus H C Pinto");

            WebView webView = findViewById(R.id.web_view);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(creditCard, "Android");
            webView.loadUrl("file:///android_asset/index.html");
        });
    }

    /*@Override
    protected void onResume() {
        super.onResume();

        System.out.println(getApplicationContext().getPackageName());
        // Initialize Places.
        Places.initialize(getApplicationContext(), "AIzaSyCNTbwqIBGNvqpLTzmhgsVu7pgZssX4BjQ");

        // Create a new Places client instance.
        PlacesClient placesClient = Places.createClient(this);

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG));
        autocompleteFragment.setCountry("BR");

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO: Get info about the selected place.
                System.out.println("Place: " + place.getName() + ", " + place.getId());

                System.out.println("TRARRARARAR" +place.getLatLng().toString());
            }

            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                System.out.println("An error occurred: " + status);
            }
        });
    }*/
}