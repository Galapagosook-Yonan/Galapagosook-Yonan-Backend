package GalapagosookYonan.GalapagosookYonan.service;
import GalapagosookYonan.GalapagosookYonan.dto.farmAddressDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class farmService {

    @Value("${google.maps.api-key}")
    private String apiKey;
/**
    public String getLatLng(String address) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
            if (results.length > 0) {
                double lat = results[0].geometry.location.lat;
                double lng = results[0].geometry.location.lng;
                return String.format("Latitude: %s, Longitude: %s", lat, lng);
            }
            return "Address not found.";
        } catch (Exception e) {
            return "Error fetching geocode: " + e.getMessage();
        }
    }**/
}
