package org.example;

import java.util.Arrays;
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

}
