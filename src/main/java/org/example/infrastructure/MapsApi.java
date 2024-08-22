package org.example.infrastructure;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

public class MapsApi {
    public static void main(String[] args) {
        String apiKey = "YOUR_API_KEY_HERE";

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, "1600 Amphitheatre Parkway, Mountain View, CA").await();

            for (GeocodingResult result : results) {
                System.out.println(result.formattedAddress);
                System.out.println("Latitude: " + result.geometry.location.lat);
                System.out.println("Longitude: " + result.geometry.location.lng);
            }
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

