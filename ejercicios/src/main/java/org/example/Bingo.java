package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {

    public void bingo(){

        Random aleatorio = new Random();
        Scanner teclado = new Scanner(System.in);

        int bolas = aleatorio.nextInt(31)+10;

        Integer sorteo[] = new Integer[bolas];
        int aux = 0;

        for (int i = 0; i < sorteo.length; i++) {
            do{
                aux=aleatorio.nextInt(90)+1;
            }while(Arrays.asList(sorteo).contains(aux));
            sorteo[i]=aux;
        }

        System.out.println(bolas + " extraídas hasta ahora " + Arrays.toString(sorteo));

        int carton[][] = new int[3][3];

        System.out.println("Introduce los datos de tu cartón: ");
        for (int i = 0; i < carton.length; i++) {
            System.out.println("Fila " + (i+1));
            String fila = teclado.next();

            if(!fila.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")){
                System.out.println("ERROR. Entrada no válida.");
                return;
            }

            String linea[] = fila.split("-");

            for (int j = 0; j < carton[i].length; j++) {
                carton[i][j] = Integer.parseInt(linea[j]);
            }

        }

        System.out.print("\n");

        System.out.println("Datos del cartón introducido: ");
        for(int[] filas : carton){
            for(int columnas : filas){
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }

        boolean bingo = true;

        antonio:
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {

                if(!Arrays.asList(sorteo).contains(carton[i][j])){
                    System.out.println("No hay bingo");
                    bingo=false;
                    break antonio;
                }
            }
        }

        if(bingo){
            System.out.println("BINGO!!");
            return;
        }

        denys:
        for (int i = 0; i < carton.length; i++) {

            for (int j = 0; j < carton[i].length; j++) {
                if(!Arrays.asList(sorteo).contains(carton[i][j])){
                    System.out.println("Línea " + (i+1) + ": no PREMIADA");
                    continue denys;
                }
            }
            System.out.println("Línea " + (i+1) + ": PREMIADA");
        }











    }

}
