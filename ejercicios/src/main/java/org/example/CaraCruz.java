package org.example;

import java.util.Random;
import java.util.Scanner;

public class CaraCruz {

    public static void principal(){

        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cara o cruz?");
        String opcion1 = teclado.next();

        //metodo para devolver el resultado del sorteo
        String resultado1 = sorteo();
        comprobarOpcion(resultado1,opcion1);

    }

    public static void comprobarOpcion(String resultado, String opcion){

        if(resultado.equals(opcion)){
            System.out.println("Has ganado! Ha salido: " + resultado);
        }else{
            System.out.println("Has perdido! Ha salido: " + resultado);
        }

    }

    public static String sorteo(){
        Random aleatorio = new Random();
        String opciones[] = {"cara","cruz"};

        String resultado = opciones[aleatorio.nextInt(2)];

        return resultado;
    }




}
