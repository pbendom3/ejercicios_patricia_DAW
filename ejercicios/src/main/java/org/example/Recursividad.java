package org.example;

import java.util.Scanner;

public class Recursividad {

    static int n;

    public static void main (String[] args){

        int numero = 10;
        System.out.println(sumar(numero));

    }

    public static void a(int c){

        System.out.print(c+" ");
        c--;

        if (c<1){
            return;
        }

        a(c);
    }

    public static void imprimirNumeros(int inicio){

        if (inicio <= n){

            System.out.print(inicio + " ");
            imprimirNumeros(inicio + 1);

        }

    }

    public static int sumar(int numero){
        if(numero==0) {
            return 0;
        }else{
            return numero+ sumar(numero-1);
        }
    }

}
