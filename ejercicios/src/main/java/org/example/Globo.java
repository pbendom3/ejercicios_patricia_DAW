package org.example;

import java.util.Scanner;

public class Globo {

    public static void glovo(){

        imprimirMenu();
        int opcion = opcionUsuario();
        comprobarOpcion(opcion);

    }

    public static void imprimirMenu(){

        System.out.println("BIENVENIDO A GLOVOAPP");
        System.out.println("¿Qué quieres comprar?");
        System.out.println("     1. Comida");
        System.out.println("     2. Bebida");
        System.out.println("     0. Salir");

    }

    public static int opcionUsuario(){
        Scanner teclado = new Scanner(System.in);
        int opcion = teclado.nextInt();
        return opcion;
    }

    public static void comprobarOpcion(int opcion){

        String pedido = "";

        if(opcion==1){
            pedido = comida();
        } else if (opcion==2) {
            pedido = bebida();
        } else if (opcion==0) {
            System.exit(0);
        }else{
            System.out.println("La opción no es válida.");
            System.exit(0);
        }

        System.out.println("Has pedido: " + pedido);

    }

    public static String comida(){

        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Qué te apetece?");
        String eleccion = teclado.next();
        return eleccion;
    }

    public static String bebida(){

        System.out.println("Introduce tu edad: ");
        int edad = opcionUsuario();

        String eleccion = "";

        if(edad>=18){
            eleccion = comida();
        }else{
            System.out.println("No puedes comprar bebida.");
            System.exit(0);
        }

        return eleccion;

    }



}
