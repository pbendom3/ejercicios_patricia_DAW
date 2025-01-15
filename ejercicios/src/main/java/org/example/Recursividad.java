package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Recursividad {

    static int n;
    static char palabra_vector[]=null;

    public static void main (String[] args) throws IOException, InterruptedException {

      long num = 1000101001;

      //System.out.println(aBinario2(num));

      if(esBinario(num)){
          System.out.println("es binario");
      }else{
          System.out.println("no es");
      }

    }

    public static void borrar() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int digitos(int numero){

        if(numero<10){
            return 1;
        }

        return 1 + digitos(numero/10);
    }

    public static int potencia(int base, int exponente){

        if(exponente==0){
            return 1;
        }

        return base*potencia(base,--exponente);
    }

    public static void del_reves(int numero){

        if(numero>= 0 && numero<10){
            System.out.print(numero);
        }else{
            System.out.print(numero%10);
            del_reves(numero/10);
        }

    }

    public static void del_reves_texto(int posicion){

        if (posicion==0){
            System.out.print(palabra_vector[posicion]);
        }else{
            System.out.print(palabra_vector[posicion]);
            del_reves_texto(posicion-1);
        }

    }

    public static boolean ordenada(int posicion){

        if (posicion<palabra_vector.length-1){
            if(palabra_vector[posicion]<=palabra_vector[posicion+1]){
                return ordenada(posicion+1);
            }else{
                return false;
            }
        }

        return true;

    }

    public static boolean esBinario(long numero){

        if(numero > 9){
            if(numero%10==0 || numero%10==1){
                return esBinario(numero/10);
            }else{
                return false;
            }
        }

        if(numero==0 || numero==1){
            return true;
        }else{
            return false;
        }

    }

    public static String aBinario(int numero){

        if(numero==0 || numero==1){
            return Integer.toString(numero);
        }else{
            return aBinario(numero/2)+numero%2;
        }

    }

    public static int aBinario2(int numero){

        if(numero==0 || numero==1){
            return numero;
        }else{
            return numero%2+10*aBinario2(numero/2);
        }

    }





}
