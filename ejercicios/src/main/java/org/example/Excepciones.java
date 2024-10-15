package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {

    public void control_excepciones() {

        Scanner entrada = new Scanner(System.in);

        int numero;
        boolean error = true;

        while (error==true) {

            try {
                System.out.println("introduce un número...");
                numero = entrada.nextInt();
                error = false;
            } catch (InputMismatchException er) {
                System.out.println("ERROR. Introduce un valor válido...");
                entrada.nextLine();
            }
    }

    }

    public void excepciones(){

        Scanner teclado = new Scanner(System.in);
        boolean error = false;

        System.out.println("dividendo :");
        int dividendo = 0; //InputMismatchException

        if (teclado.hasNextInt()){
            dividendo = teclado.nextInt();
        }else{
            System.out.println("Has introducido un formato incorrecto. No es un número...");
            error = true;
        }

        int divisor_entero = 0;

        if (error==false){
            System.out.println("Divisor:");
            String divisor = teclado.next();

            try{
                divisor_entero = Integer.parseInt(divisor); //NumberFormatException
            }catch(NumberFormatException e1){
                System.out.println("El divisor introducido no es un número. " + e1.getMessage());
                error = true;
            }
        }

        int resultado = 0; //ArithmeticException

        if (error==false){
            try{
                resultado = dividendo/divisor_entero;

            }catch(ArithmeticException e2){
                System.out.println("No se puede dividir entre 0. " + e2.getMessage());
            }finally{
                System.out.println("Resultado : " + resultado);
            }

        }

    }
}
