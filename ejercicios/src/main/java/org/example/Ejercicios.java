package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicios {

    public void actividad_inicial(){

        System.out.println("¿Cómo te llamas?");

        Scanner entrada = new Scanner(System.in);
        //System.in

        String nombre = entrada.next();

        System.out.println("¿A qué curso vas?");
        String curso = entrada.next();

        System.out.println("Hola " +  nombre + ",bienvenido a " + curso);

        int num1 = 0;
        int num2 = 0;

        while (num1==num2){

            try {
                System.out.println("Introduce un número...");
                num1 = entrada.nextInt();

                System.out.println("Introduce otro número...");
                num2 = entrada.nextInt();

                if (num1 == num2) {
                    System.out.println("ERROR. Los números son iguales.");
                }

            }catch (InputMismatchException er){
                System.out.println("ERROR. Introduce un valor válido...");
                entrada.nextLine();
            }
        }

        int resultado = num1 + num2;
        System.out.println("El resultado de la suma es " + resultado);


    }

    public void ejercicio3(){

        Scanner entrada = new Scanner(System.in);

        float num1 = 0;
        float num2 = 0;
        float resultado = 0;
        int aux = 0;

        while (aux==0) {
            try {
                System.out.println("Introduce el dividendo...");
                num1 = entrada.nextInt();
                System.out.println("Introduce el divisor...");
                num2 = entrada.nextInt();
                aux = 1;
            } catch (InputMismatchException er) {
                System.out.println("ERROR. Introduce un valor válido...");
                entrada.nextLine();
            }
        }

        if (num2==0){
            System.out.println("El divisor no puede ser 0.");
        }else{
            resultado = (num1/num2);
            System.out.println("El resultado es " + resultado);
        }

    }

}
