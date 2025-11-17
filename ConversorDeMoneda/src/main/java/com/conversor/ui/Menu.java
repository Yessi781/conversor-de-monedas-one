package com.conversor.ui;

import com.conversor.domain.Converter;
import com.conversor.model.ExchangeRateResponse;
import com.conversor.service.CurrencyApiService;

import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final CurrencyApiService api = new CurrencyApiService();
    private final Converter converter = new Converter();

    public void mostrar() throws Exception {

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("""
                *****************
                 Sea bienvenido/a al Conversor de Moneda =]

                 1) USD => ARS
                 2) ARS => USD
                 3) USD => BRL
                 4) BRL => USD
                 5) USD => COP
                 6) COP => USD
                 7) Salir

                 Elija una opcion valida:
                *****************
                """);

            opcion = sc.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor!");
                break;
            }

            System.out.print("Ingrese el valor a convertir: ");
            double cantidad = sc.nextDouble();

            String base = "";
            String destino = "";

            switch (opcion) {
                case 1 -> { base = "USD"; destino = "ARS"; }
                case 2 -> { base = "ARS"; destino = "USD"; }
                case 3 -> { base = "USD"; destino = "BRL"; }
                case 4 -> { base = "BRL"; destino = "USD"; }
                case 5 -> { base = "USD"; destino = "COP"; }
                case 6 -> { base = "COP"; destino = "USD"; }
                default -> {
                    System.out.println("Opción inválida.");
                    continue;
                }
            }

            ExchangeRateResponse data = api.obtenerTasas(base);
            double resultado = converter.convertir(base, destino, cantidad, data);

            System.out.println("=========================================");
            System.out.println(cantidad + " " + base + " = " + resultado + " " + destino);
            System.out.println("Tasa aplicada: "
                    + data.getConversion_rates().get(destino).getAsDouble());
            System.out.println("=========================================\n");
        }
    }
}
