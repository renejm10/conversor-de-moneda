package com.renejm.conversormoneda.main;

import com.renejm.conversormoneda.procesos.Consulta;
import com.renejm.conversormoneda.procesos.Conversor;
import com.renejm.conversormoneda.procesos.Currencies;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Consulta consulta = new Consulta();
        Conversor conversor = new Conversor();
        int op=0;
        String cur1="", cur2="";
        float respuesta=0;
        float money;
        while(op!=7){
            System.out.println("*******************\n");
            System.out.println("BIENVENIDO AL CONVERSOR DE MONEDA\n");
            System.out.println("1) Dolar a Euro");
            System.out.println("2) Euro a Dolar");
            System.out.println("3) Lempira a Dolar");
            System.out.println("4) Dolar a Lempira");
            System.out.println("5) Lempira a Euro");
            System.out.println("6) Euro a Lempira");
            System.out.println("7) Salir");
            System.out.println("********************\n");
            System.out.print("Ingrese su opcion: ");
            op = sc.nextInt();

            switch(op){
                case 1: cur1 = "USD"; cur2 = "EUR"; break;
                case 2: cur1 = "EUR"; cur2 = "USD"; break;
                case 3: cur1 = "HNL"; cur2 = "USD"; break;
                case 4: cur1 = "USD"; cur2 = "HNL"; break;
                case 5: cur1 = "HNL"; cur2 = "EUR"; break;
                case 6: cur1 = "EUR"; cur2 = "HNL"; break;
            }
            if (op<7){
                Currencies currencies = consulta.consulta(cur1,cur2);
                System.out.println("Ingrese monto a cambiar: ");
                money = sc.nextFloat();
                respuesta=conversor.conversor(currencies.conversion_rate(),money);
                System.out.println(respuesta);
            }else if(op==7){
                System.out.println("Fin del Programa!");
            }else {
                System.out.println("Ingreso una opcion incorrecta!, vuelva a intentar");
            }
        }
    }
}
