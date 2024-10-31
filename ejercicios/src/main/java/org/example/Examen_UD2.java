package org.example;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen_UD2 {

    public void ejercicio1(){

        Random aleatorio = new Random();
        Scanner teclado = new Scanner(System.in);

        int numero_pc = aleatorio.nextInt(101);
        int numero_usuario = 0;

        System.out.println("Acabo de pensar un número [0-100]… ¿puedes adivinarlo? ¡Tienes 10 intentos");

        for (int i=1; i<=10; i++){

            System.out.println("Intento " + i +" . Introduce un número:");

            try{
                numero_usuario = teclado.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Introduce un número!!!");
                teclado.nextLine();
                i--;
                continue;
            }

            if (numero_usuario<numero_pc){
                System.out.println("Tu número es menor al que he pensado...");
            } else if (numero_usuario>numero_pc) {
                System.out.println("Tu número es mayor al que he pensado...");
            }else{
                System.out.println("¡HAS ACERTADO! El número era " + numero_usuario);
                break;
            }

            if (i==10){
                System.out.println("GAME OVER. El número era " + numero_pc);
            }

        }

    }

    public void ejercicio2(){

        Scanner teclado = new Scanner(System.in);
        LocalDateTime hoy = LocalDateTime.now();

        int anyo_actual = hoy.getYear();
        int anyo = 1900;
        int bisiestos = 0;


        do{
            System.out.println("Elige un año: ");

            if (teclado.hasNextInt()){
                anyo = teclado.nextInt();
            }else{
                System.out.println("Introduce un valor válido!!!");
                teclado.nextLine();
            }
        }while(anyo<1900 || anyo>anyo_actual);

        for (int i=anyo; i<=anyo_actual;i++){

            if(i%4==0 && i%100 !=0){
                bisiestos++;
            } else if (i%400==0) {
                bisiestos++;
            }

        }

        System.out.println("Ha habido " + bisiestos + " años bisiestos.");

    }

}
