package org.example;

import java.util.Random;

public class Aleatorios {

    public void aleatorios(){

        Random aleatorio = new Random();

        int numero = aleatorio.nextInt();
        System.out.println(numero);

        numero = aleatorio.nextInt(899) + 100;
        System.out.println(numero);

        double numero_decimal = aleatorio.nextDouble()*3 + 1;
        System.out.println(numero_decimal);

        double numero_math = Math.random()*3 + 1;
        System.out.println(numero_math);





    }

    public void ejercicio1(){

        Random aleatorio = new Random();

        int dado1 = aleatorio.nextInt(6) + 1;
        System.out.println("Dado 1: " + dado1);
        int dado2 = aleatorio.nextInt(6) + 1;
        System.out.println("Dado 2: " + dado2);

        System.out.println("La suma de ambos dados es: " + (dado1+dado2));


    }

    public void ejercicio2(){

        Random aleatorio = new Random();

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        int longitud = 10;

        String contrasenya = "";

        int posicion;

        for(int i=0;i<longitud;i++){

            posicion = aleatorio.nextInt(caracteres.length());
            contrasenya += caracteres.charAt(posicion);
           
        }

        System.out.println("La contraseña generada es: " + contrasenya);



    }


}
