package com.alurachallenge.conversor.calculos;

import com.alurachallenge.conversor.modelos.MonedaExchange;
import com.alurachallenge.conversor.servicios.ConsultaMoneda;

public class ConversorDeMoneda {
    public void ejecutarConversion(String base,
                                   String destino,
                                   double monto,
                                   ConsultaMoneda consulta){
        try {
            MonedaExchange datos = consulta.buscarMoneda(base, destino, monto);
            System.out.println("***************************************************");
            System.out.println("El valor " + monto + " [" + base + "] corresponde al valor final de =>>> "
                    + datos.resultado() + " [" + destino + "]");
            System.out.println("***************************************************\n");
        } catch (RuntimeException e){
            System.out.println("Ovurrió un error" + e.getMessage());
        }
    }
}
