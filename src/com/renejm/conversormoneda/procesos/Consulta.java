package com.renejm.conversormoneda.procesos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {

    public Currencies consulta(int op){
        URI direccion=null;
        String currency1="", currency2="";
        switch(op){
            case 1: currency1 = "USD"; currency2 = "EUR"; break;
            case 2: currency1 = "EUR"; currency2 = "USD"; break;
            case 3: currency1 = "HNL"; currency2 = "USD"; break;
            case 4: currency1 = "USD"; currency2 = "HNL"; break;
            case 5: currency1 = "HNL"; currency2 = "EUR"; break;
            case 6: currency1 = "EUR"; currency2 = "HNL"; break;
        }

        direccion = URI.create
                    ("https://v6.exchangerate-api.com/v6/5ef4d68f201daa1c6ffaa556/enriched/"+currency1+"/"+currency2);

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
