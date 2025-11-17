package com.conversor.model;

import com.google.gson.JsonObject;

public class ExchangeRateResponse {

    private String base_code;
    private JsonObject conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public JsonObject getConversion_rates() {
        return conversion_rates;
    }
}