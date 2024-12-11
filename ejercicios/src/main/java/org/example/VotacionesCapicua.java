package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class VotacionesCapicua {

    static Scanner teclado;

    public static boolean casoDePrueba() {
        //leer caso de prueba
        String datos = teclado.nextLine();
        String datos_entrada[] = datos.split(" ");

        if (Integer.parseInt(datos_entrada[0])==0 && Integer.parseInt(datos_entrada[1])==0)//es el caso que marca el final
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            System.out.println(Arrays.toString(datos_entrada));
            return true;
        }
    } // casoDePrueba

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main


}
