package com.alurachallenge.conversor.principal;

import com.alurachallenge.conversor.calculos.ConversorDeMoneda;
import com.alurachallenge.conversor.servicios.ConsultaMoneda;
import com.google.gson.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        ConversorDeMoneda conversor = new ConversorDeMoneda();

        List<String> historial = new ArrayList<>();

        int opcion = 0;
        while (opcion != 8) {
            System.out.println("***************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]\n");
            System.out.println("1) Dólar =>> Sol peruano");
            System.out.println("2) Sol peruano =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Ver historial");
            System.out.println("8) Salir");
            System.out.print("Elija una opción válida: ");

            opcion = teclado.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingresa el valor que deseas convertir: ");
                double monto = teclado.nextDouble();

                String base = "";
                String destino = "";

                switch (opcion) {
                    case 1 -> { base = "USD"; destino = "PEN"; }
                    case 2 -> { base = "PEN"; destino = "USD"; }
                    case 3 -> { base = "USD"; destino = "BRL"; }
                    case 4 -> { base = "BRL"; destino = "USD"; }
                    case 5 -> { base = "USD"; destino = "COP"; }
                    case 6 -> { base = "COP"; destino = "USD"; }
                }

                String resultado = conversor.ejecutarConversion(base, destino, monto, consulta);
                historial.add(resultado);

            } else if (opcion == 7) {
                System.out.println("\n--- HISTORIAL DE CONVERSIONES ---");
                if (historial.isEmpty()) {
                    System.out.println("No hay conversiones registradas.");
                } else {
                    historial.forEach(System.out::println);
                }
                System.out.println("---------------------------------\n");
            } else if (opcion > 8) {
                System.out.println("Opción no disponible. Cerrando el programa por seguridad...");
                opcion = 8;
            }
        }
        System.out.println("¡Gracias por usar el conversor! Saliendo...");
    }
}