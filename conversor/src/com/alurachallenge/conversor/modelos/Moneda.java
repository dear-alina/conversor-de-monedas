package com.alurachallenge.conversor.modelos;

public class Moneda {
    private String codigo;
    private double valorConvertido;

    //Constructor
    public Moneda(MonedaExchange monedaExchange) {
        this.codigo = monedaExchange.monedaDestino();
        this.valorConvertido = monedaExchange.resultado();
    }

    //Getters
    public String getCodigo() {
        return codigo;
    }
    public double getValorConvertido() {
        return valorConvertido;
    }

    @Override
    public String toString() {
        return "Moneda destino: " + codigo + '\'' +
                ", Valor final: " + valorConvertido;
    }
}
