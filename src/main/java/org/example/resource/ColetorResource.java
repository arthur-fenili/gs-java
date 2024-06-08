package org.example.resource;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entities.Coletor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Path("/coletores")
public class ColetorResource {

    private static final String API_KEY = "AIzaSyC9l-5BoiebqgQ6-EZAaORR4fDtjN9KoUs";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getColetores() {
        List<Coletor> coletores = new ArrayList<>();
        coletores.add(new Coletor(-23.854373, -46.016817));
        coletores.add(new Coletor(-23.045547, -43.097200));

        // Exemplo de uso da API do Google Maps para buscar endereços
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        try {
            for (Coletor coletor : coletores) {
                GeocodingResult[] results = GeocodingApi.reverseGeocode(context, new com.google.maps.model.LatLng(coletor.getLat(), coletor.getLng())).await();
                if (results.length > 0) {
                    coletor.setAddress(results[0].formattedAddress);
                }
            }
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return Response.ok(coletores).build();
    }
}

