package com.alurachallenge.conversor.principal;

import com.alurachallenge.conversor.calculos.ConversorDeMoneda;
import com.alurachallenge.conversor.servicios.ConsultaMoneda;
import com.google.gson.*;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        ConversorDeMoneda conversor = new ConversorDeMoneda();

        int opcion = 0;
        while (opcion != 7) {
            System.out.println("***************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]\n");
            System.out.println("1) Dólar =>> Sol peruano");
            System.out.println("2) Sol peruano =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            opcion = teclado.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingresa el valor que deseas convertir: ");
                double monto = teclado.nextDouble();

                switch (opcion) {
                    case 1 -> conversor.ejecutarConversion("USD", "PEN", monto, consulta);
                    case 2 -> conversor.ejecutarConversion("PEN", "USD", monto, consulta);
                    case 3 -> conversor.ejecutarConversion("USD", "BRL", monto, consulta);
                    case 4 -> conversor.ejecutarConversion("BRL", "USD", monto, consulta);
                    case 5 -> conversor.ejecutarConversion("USD", "COP", monto, consulta);
                    case 6 -> conversor.ejecutarConversion("COP", "USD", monto, consulta);
                }
            }
        }
        System.out.println("¡Gracias por usar el conversor! Saliendo...");
    }
}