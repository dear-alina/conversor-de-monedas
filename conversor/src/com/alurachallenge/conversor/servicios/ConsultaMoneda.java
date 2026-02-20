package com.alurachallenge.conversor.servicios;

import com.alurachallenge.conversor.modelos.MonedaExchange;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public MonedaExchange buscarMoneda(String monedaBase,
                                       String monedaDestino,
                                       double monto){
        //1. URL + clave API
        String clave = "301fb4e91e65e716a3e28352";
        //clave = System.getenv("API_KEY");
        String urlFinal = "https://v6.exchangerate-api.com/v6/" + clave + "/pair/" +
                monedaBase + "/" + monedaDestino + "/" + monto;
        try {
            // a. cliente (client)
            HttpClient client = HttpClient.newHttpClient();

            // b. solicitud (request)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlFinal))
                    .build();

            // c. respuesta (response)
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), MonedaExchange.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con la API: " + e.getMessage());
        }
    }
}
