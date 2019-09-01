package levae.client.core.util;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

import levae.client.R;

/**
 * Created by txring on 13/08/2019.
 */
public class PlacesAutoComplete {

    public PlacesAutoComplete(Fragment fragment, int code) {

        if (!Places.isInitialized()) {
            Places.initialize(fragment.getContext(), "AIzaSyCNTbwqIBGNvqpLTzmhgsVu7pgZssX4BjQ");
        }

        // Create a new Places client instance.
        PlacesClient placesClient = Places.createClient(fragment.getContext());

        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(
                AutocompleteActivityMode.FULLSCREEN, fields).setCountry("BR")
                .build(fragment.getContext());
        fragment.startActivityForResult(intent, code);
    }


    /**new PlaceSelectionListener() {
    @Override public void onPlaceSelected(@NonNull Place place) {
    // TODO: Get info about the selected place.
    System.out.println("Place: " + place.getName() + ", " + place.getId());

    System.out.println("TRARRARARAR" +place.getLatLng().toString());
    }

    @Override public void onError(@NonNull Status status) {
    System.out.println("An error occurred: " + status);
    }
    }**/
}
