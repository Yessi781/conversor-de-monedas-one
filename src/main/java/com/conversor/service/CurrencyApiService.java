package com.conversor.service;

import com.conversor.model.ExchangeRateResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyApiService {

    private static final String API_KEY = "3d148bda683654fda0d65a68";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient client;
    private final Gson gson;

    public CurrencyApiService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public ExchangeRateResponse obtenerTasas(String baseCurrency) throws Exception {

        String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), ExchangeRateResponse.class);

        } catch (Exception e) {
            return null;
        }
    }
}