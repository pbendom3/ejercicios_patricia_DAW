package org.example;

import java.util.Scanner;

public class Ventas {

    static Scanner teclado;

    public static boolean casoDePrueba() {
        //leer caso de prueba
        float datos[] = new float[6];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = teclado.nextFloat();
        }

        if (datos[0]==-1)//es el caso que marca el final
        return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            return true;
        }
    } // casoDePrueba

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

}
