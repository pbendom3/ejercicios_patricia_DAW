package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase para ayudar a un señor con su bar.
 * @author Patricia
 * @version 1.0 (11/12/2024)
 */
public class Ventas {

    static Scanner teclado;

    public static boolean casoDePrueba() {
        //leer caso de prueba
        float dato = teclado.nextFloat();

        if (dato==-1)//es el caso que marca el final
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ

            float datos[] = introducirDatos(dato);

            System.out.println(Arrays.toString(datos));

            return true;
        }
    } // casoDePrueba

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

    /**
     * Se termina de introducir datos para que el programa funcione
     * @param dato - (vector números decimales) este parámetro es el primer número que introduce el usuario cuando se lanza el programa
     * @return - devolvemos un vector de 6 posiciones con los importes de la semana de martes a domingo
     */
    public static float[] introducirDatos(float dato){

        float datos[] = new float[6];
        datos[0] = dato;
        for (int i = 1; i < datos.length; i++) {
            datos[i]=teclado.nextFloat();
        }

        return datos;

    }

}
