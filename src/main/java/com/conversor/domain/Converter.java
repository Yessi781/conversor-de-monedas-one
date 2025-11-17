package com.conversor.domain;

import com.conversor.model.ExchangeRateResponse;

public class Converter {

    public double convertir(String base, String destino, double valor, ExchangeRateResponse data) {

        double tasa = data.getConversion_rates()
                .get(destino)
                .getAsDouble();

        return valor * tasa;
    }
}