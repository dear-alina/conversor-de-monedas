package com.alurachallenge.conversor.calculos;

import com.alurachallenge.conversor.modelos.MonedaExchange;
import com.alurachallenge.conversor.servicios.ConsultaMoneda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversorDeMoneda {
    public String ejecutarConversion(String base,
                                   String destino,
                                   double monto,
                                   ConsultaMoneda consulta){
        try {
            MonedaExchange datos = consulta.buscarMoneda(base, destino, monto);
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            String mensaje = "[" + fecha + "] El valor " + monto + " [" + base + "] corresponde al valor final de =>>> "
                    + datos.resultado() + " [" + destino + "]";

            System.out.println("***************************************************");
            System.out.println(mensaje);
            System.out.println("***************************************************\n");

            return mensaje;

        } catch (Exception e) {
            String errorMsg = "[ERROR] No se pudo realizar la conversión de " + base + " a " + destino;
            System.out.println(errorMsg);
            return errorMsg;
        }
    }
}
