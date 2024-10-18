package org.example;

import java.util.Scanner;

public class Bucles {

    public void ejercicio1(){

        Scanner teclado = new Scanner(System.in);

        String psw = "entornos";
        String psw_usuario;

        do {
            System.out.println("Introduce tu contraseña: ");
            psw_usuario = teclado.next();

        }while(!psw_usuario.equals(psw));

        System.out.println("BIENVENIDO.");

    }

    public void ejercicio2(){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número...");
        int numero = teclado.nextInt();

        for (int i=numero;i>=1;i--){

            if(i%2==0){
                System.out.println(i);
            }

        }


    }



}
