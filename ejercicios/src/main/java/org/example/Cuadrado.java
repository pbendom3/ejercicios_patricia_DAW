package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cuadrado {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args){

        int numero = pedirNumero();

        if (numero==-1){
            System.exit(0);
        }else{

            if(validarNumero(numero)){
                int resultado = calcularCuadrado(numero);
                System.out.println("El resultado es " +  resultado);
            }else{
                System.out.println("Formato no válido (1-8 cifras).");
            }

        }


    }

    public static int pedirNumero(){

        System.out.println("Dame un número...");
        int numero ;

        try{
            numero = teclado.nextInt();
        }catch(InputMismatchException e){
            System.out.println("ERROR de formato.");
            numero = -1;
        }

        return numero;

    }

    public static boolean validarNumero(int numero){

        if (Integer.toString(numero).matches("\\d{1,8}") || Integer.toString(numero).matches("-\\d{1,8}")){
            return true;
        }else{
            return false;
        }

    }

    public static int calcularCuadrado(int numero){

        return numero*numero;

    }



}
