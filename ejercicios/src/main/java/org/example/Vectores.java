package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Vectores {

    public void vectores(){

        int vector[];

        vector = new int[7];

        vector[2] =  7;
        vector[5] = vector[2]+4;

        System.out.println(vector[2] + " " + vector[5]);

        for (int i=0;i<vector.length;i++){
            System.out.print(" " + vector[i] + ", ");
        }

        String palabras[] = new String[3];
        palabras[0] = "Pepe";
        palabras[1] = "Juan";

        for (int i=0; i<palabras.length;i++){
            System.out.print(" " + palabras[i] + " ");
        }

    }

    public void ejercicio1(){

        Random aleatorio = new Random();

        int numeros[] = new int[8];
        int suma = 0;

        for (int i=0;i<numeros.length;i++){

            numeros[i] = aleatorio.nextInt(501);
            suma+=numeros[i];

        }

        System.out.println("La suma de los elementos es: " + suma);

    }

    public void ejercicio2(){

        Scanner teclado = new Scanner(System.in);
        int numeros[] = new int[4];

        int ultima_posicion = numeros[numeros.length-1];

        System.out.println("Introduce los números a invertir...");

        for (int i=0; i<numeros.length;i++){

            numeros[i] = teclado.nextInt();

        }

        int tam_mitad = numeros.length / 2;
        int aux;

        for (int i=0;i<tam_mitad;i++){

            aux = numeros[i];
            numeros[i]=numeros[numeros.length-1-i];
            numeros[numeros.length-1-i] =  aux;

        }

//        for(int i=numeros.length-1;i>=0;i--){
//            System.out.print(" " + numeros[i] + " ");
//        }

        for (int i = 0; i < numeros.length ; i++) {
            System.out.print(" " + numeros[i] + " ");
        }


    }

    public void ejercicio3(){

        Random aleatorio = new Random();
        Scanner teclado = new Scanner(System.in);

        int numeros[] = new int[25];
        int num = 0;
        int contador = 0;

        for (int i=0; i<numeros.length;i++){

            numeros[i] = aleatorio.nextInt(101);

        }

        System.out.println("Introduce un número [0,100]:");
        num = teclado.nextInt();

        for (int i=0; i<numeros.length;i++){

            System.out.print(" " + numeros[i] +  " ");

            if(num==numeros[i]){
                contador++;
            }

        }

        System.out.println("\n El número " + num + " aparece " + contador +" veces en el array.");




    }

    public void ejercicio5(){

        int numeros[] = {3,5,2,1,4};

        int ultima_posicion = numeros[numeros.length-1];

        for (int i=numeros.length-1;i>=0;i--){

            if(i==0){
                numeros[i] = ultima_posicion;
            }else{
                numeros[i] = numeros[i-1];
            }

        }

        for (int i =0;i<numeros.length;i++){

            System.out.print(numeros[i]);

        }

    }

    public void vectores2(){

        String palabras[] = {"Paco","Pepe","Juan","Maria"};

        for(String i : palabras){

            System.out.print(i);

        }

        String texto_vector = Arrays.toString(palabras);
        System.out.println("\n " + texto_vector);

        String palabras2[] = palabras;

        palabras2[0]="Francisco";

        System.out.println(palabras);
        System.out.println(palabras2);
        System.out.print(Arrays.toString(palabras));
        System.out.print(Arrays.toString(palabras2));

        String palabras3[] =  palabras.clone();

        palabras3[1] = "Lourdes";
        System.out.println(palabras3);
        System.out.print(Arrays.toString(palabras));
        System.out.print(Arrays.toString(palabras3));

        String nombres_chachis[] = new String[2];

        System.arraycopy(palabras,0,nombres_chachis,0,2);


        System.out.print(Arrays.toString(nombres_chachis));






    }

}
