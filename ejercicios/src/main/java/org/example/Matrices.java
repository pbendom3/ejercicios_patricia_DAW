package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrices {

    public void matrices(){

        int matriz[][] = new int[3][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + " ");

            }
            System.out.print("\n");
        }

        int matriz2[][] = {{2,3,4,1},{5,10,32,6}};

        for(int[] fila : matriz2){
            System.out.println(Arrays.toString(fila));
        }

        int matriz3[][] = new int[3][3];

        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3[i].length; j++) {
                System.out.println("Introduce la posición (" +i+ "," + j + ")");
                matriz3[i][j] = teclado.nextInt();
            }

        }

        System.out.println("tu matriz queda: ");
        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3[i].length; j++) {

                System.out.print(matriz3[i][j] + " ");

            }
            System.out.print("\n");
        }




    }

    public void matrices2(){

        int m[][] = new int[3][3];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {

                if(i==j){
                    m[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {

                if(m[i][j]==1){
                    System.out.print("X ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        for (int i = 0; i < m.length; i++) {
            for (int j = m[i].length-1; j >=0; j--) {

                if(m[i][j]==1){
                    System.out.print("X ");
                }else{
                    System.out.print("- ");
                }

            }
            System.out.print("\n");

        }

    }

    public void buscar(){

        Random aleatorio = new Random();

        int matriz[][] = new int[2][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = aleatorio.nextInt(10);
            }
        }

        for(int[] filas : matriz){
            for(int columnas : filas){
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }

        final int numero = 8;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if(matriz[i][j]==numero){
                    System.out.println("Existe.");
                    return;
                }
            }
        }

        System.out.println("No existe");


    }

    public void ejercicio2(){

        Random aleatorio = new Random();

        int filas = aleatorio.nextInt(5)+1;
        int columnas = aleatorio.nextInt(5)+1;

        int matriz[][] = new int[filas][columnas];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = aleatorio.nextInt(50)+1;
            }
        }

        for(int[] fila : matriz){
            for(int columna : fila){
                System.out.print(columna + " ");
            }
            System.out.print("\n");
        }

        int suma = 0;
        System.out.println("suma de filas: ");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma+=matriz[i][j];
            }
            System.out.println("Fila " + (i+1) + ": " + suma);
            suma=0;
        }

        System.out.println("suma de columnas: ");
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                suma+=matriz[j][i];
            }
            System.out.println("Columna " + (i+1) + ": " + suma);
            suma=0;
        }




    }

    public void mayor(){

        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        System.out.println("Introduce el tamaño de la matriz A:");
        int filas_a = teclado.nextInt();
        int columnas_a = teclado.nextInt();
        System.out.println("Introduce el tamaño de la matriz B:");
        int filas_b  = teclado.nextInt();
        int columnas_b = teclado.nextInt();

        int a[][] = new int[filas_a][columnas_a];
        int b[][] =  new int[filas_b][columnas_b];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = aleatorio.nextInt(20)+1;
            }
        }

        System.out.println("Matriz A:");
        for(int[] filas : a){
            for(int columnas : filas){
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = aleatorio.nextInt(20)+1;
            }
        }

        System.out.println("Matriz B:");
        for(int[] filas : b){
            for(int columnas : filas){
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }

        if(filas_a!=filas_b || columnas_a!=columnas_b){
            System.out.println("ERROR, las matrices no son iguales");
            return;
        }

        int m[][] = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                if(a[i][j]>b[i][j]){
                    m[i][j]=a[i][j];
                } else if (a[i][j]<b[i][j]) {
                    m[i][j]=b[i][j];
                }else{
                    m[i][j]=0;
                }

            }


        }

        System.out.println("Matriz M:");
        for(int[] filas : m){
            for(int columnas : filas){
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }




    }

    public void ejercicio3(){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Cuántos estudiantes tienes?");
        int estudiantes = teclado.nextInt();
        System.out.println("Cuántas asignaturas hay?");
        int asignaturas = teclado.nextInt();

        String tabla[][] = new String[estudiantes+1][asignaturas+1];

        tabla[0][0] = "Estudiantes";

        for (int i = 1; i < tabla.length; i++) {
            System.out.println("Inserta el nombre del alumno " + i);
            tabla[i][0]=teclado.next();
        }

        for (int i = 1; i < tabla[0].length; i++) {
            System.out.println("Inserta el nombre de la asignatura "+ i);
            tabla[0][i]=teclado.next();

        }

        for (int i = 1; i < tabla.length; i++) {
            for (int j = 1; j < tabla[i].length; j++) {

                System.out.println("Introduce la nota de " + tabla[i][0] + " para la asignatura de " + tabla[0][j]);
                tabla[i][j]=Integer.toString(teclado.nextInt());
            }
        }

        for (String[] filas : tabla){
            for(String columnas : filas){
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }

        float media_alumno = 0;
        for (int i = 1; i < tabla.length; i++) {
            for (int j = 1; j < tabla[i].length; j++) {
                media_alumno+=Integer.parseInt(tabla[i][j]);
            }
            System.out.println("La media del alumno " + tabla[i][0] + ":" + (media_alumno/asignaturas));
            media_alumno=0;
        }

        float media_asignatura = 0;
        for (int i = 1; i < tabla[0].length; i++) {
            for (int j = 1; j < tabla.length; j++) {
                media_asignatura+=Integer.parseInt(tabla[j][i]);
            }
            System.out.println("La nota media de la asignatura " + tabla[0][i] + ":" + (media_asignatura/estudiantes));
            media_asignatura=0;
        }

    }

    public void vectores(){

        int vector[] = {3,4,5,3,1};

        System.out.println(Arrays.toString(vector));

        int matriz[][] = new int[3][vector.length];

        for (int i = 0; i < vector.length; i++) {

            matriz[2][i]= vector[i];

        }

        for (int[] filas : matriz){
            for(int columnas:filas){
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }




    }

    public void vectores_2(){

        Scanner teclado = new Scanner(System.in);

        String matriz[][] = new String[10][10];

        for (int i = 0; i < matriz.length; i++) {

            System.out.println("Introduce primera fila: ");
            String valor_fila[] = teclado.next().split("");

            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=valor_fila[j];
            }

        }

        for(String[] filas : matriz){
            for (String columnas : filas){
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }




    }




}
