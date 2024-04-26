package com.renejm.conversormoneda.procesos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {

    public Currencies consulta(String currency1, String currency2){
        URI direccion=null;



        direccion = URI.create
                    ("https://v6.exchangerate-api.com/v6/5ef4d68f201daa1c6ffaa556/pair/"+currency1+"/"+currency2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currencies.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
