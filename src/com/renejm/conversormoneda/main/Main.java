package com.renejm.conversormoneda.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do{
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

        }while(op!=7);




    }
}
