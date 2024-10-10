package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Examen {

    public void ejercicio1(){

        Scanner teclado = new Scanner(System.in);

        boolean err=true;
        float trim1 = 0;
        float trim2 = 0;
        float trim3 = 0;

        while(err==true){

            try{
                System.out.println("Introduce la nota del primer trimestre (0-10): ");
                trim1 = teclado.nextInt();
                System.out.println("Introduce la nota del segundo trimestre (0-10): ");
                trim2 = teclado.nextInt();
                System.out.println("Introduce la nota del tercer trimestre (0-10): ");
                trim3 = teclado.nextInt();

                if (trim1>=0 && trim2>=0 && trim3>=0 && trim1<=10 && trim2 <= 10 && trim3<=10){
                    err=false;
                }else{
                    System.out.println("Valores fuera de rango. Vuelve a introducirlos..");
                }

            }catch (InputMismatchException e){
                System.out.println("Introduce un valor válido... (numérico)");
                teclado.nextLine();
            }

        }

        float media = (trim1+trim2+trim3)/3;
        System.out.println("La nota media es " + media);

        if (media<5){
            System.out.println("SUSPENSO.");
        }else{
            System.out.println("APROBADO.");
        }

    }

    public void ejercicio2(){

        Scanner teclado = new Scanner(System.in);

        boolean err=true;
        int num = 0;

        while(err==true){

            try{
                System.out.println("Introduce un número...");
                num = teclado.nextInt();
                err=false;
            }catch (InputMismatchException e){
                System.out.println("Introduce un valor válido (numérico)...");
                teclado.nextLine();
            }

        }

        if (num<0){
            num = num * -1;
        }

        System.out.println("El valor absoluto es " + num);

    }

}
