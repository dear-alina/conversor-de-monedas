package com.alurachallenge.conversor.modelos;

import com.google.gson.annotations.SerializedName;

public record MonedaExchange(
        @SerializedName("base_code") String monedaBase,
        @SerializedName("target_code") String monedaDestino,
        @SerializedName("conversion_rate") double tasaDeConversion,
        @SerializedName("conversion_result") double resultado) {
}
