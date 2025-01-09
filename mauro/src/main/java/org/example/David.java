package org.example;

import java.util.Scanner;

/**
 * Proyecto de Olympiadas Navidad 2024. Verificación de Entradas Selección Española Femenina.
 * @author David Andrés Albarracín
 * @version 1.0 (18/12/2024)
 */

public class David {

    static Scanner teclado = new Scanner(System.in);

    /**
     *
     * @param args
     */

    public static void main(String[] args){
        int entradas = numeroEntradas();
        verificacionEntradas(entradas);
    }

    /**
     * @return Cogemos la entrada y lo devolvemos como un íntegro porque es un número
     */

    public static int numeroEntradas(){
        int entradas = 0;

        try{
            entradas = teclado.nextInt();
        }catch (NumberFormatException e1){
            System.out.println("Error" + e1);
            System.exit(1);
        }

        return entradas;
    }

    /**
     * @param entradas
     * Hacemos un bucle que se repita según la cantidad de entradas que el usuario ha dicho que quiere verificar
     * En un vector, metemos la entrada con un metodo que hemos llamado convertirEntrada()
     * Enviamos ese vector a comprobarImpares() y a comprobarPares() que van a hacer cálculos con el vector
     * El resultado de cada cálculo de comprobarImpares() y comprobarPares() lo sumamos y mostramos
     */

    public static void verificacionEntradas(int entradas){
        for (int i = 0; i < entradas; i++) {
            int[] codEntrada = convertirEntrada(teclado.next());
            int sumaImpares = comprobarImpares(codEntrada);
            int sumaPares = comprobarPares(codEntrada);
            System.out.println(sumaImpares + sumaPares);
        }
    }

    /**
     * @param splitEntrada
     * Metemos la entrada en un vector String haciendo un split para separar los números 1 a 1
     * Tenemos que verificar que la longitud del vector sea un número par
     * @return Si lo anterior sale correcto, convertimos el vector String a Íntegro para poder hacer cálculos
     */

    public static int[] convertirEntrada(String splitEntrada){
        String[] numeros = splitEntrada.split("");

        if (numeros.length % 2 != 0){
            System.exit(1);
        }

        int[] codEntrada = new int[numeros.length];

        try{
            for (int i = 0; i < codEntrada.length; i++) {
                codEntrada[i] = Integer.parseInt(numeros[i]);
            }
        }catch (NumberFormatException e1){
            System.out.println("Error" + e1);
            System.exit(1);
        }

        return codEntrada;
    }

    /**
     * @param pares
     * Vamos a comprobar los números en las posiciones pares pero antes hay que mirar cual es el mayor
     * número a la izquierda del que estamos comprobando actualmente
     * Una vez mirado, cogemos el número, lo multiplicamos por 2 y los sumamos al numMayor
     * @return Estas operaciones se guardan en una suma que se hace de los números en las posiciones pares
     */

    public static int comprobarPares(int[] pares){
        int numMayor = 0;
        int sumaPar = 0;

        for (int i = 0; i < pares.length; i++) {
            if (numMayor < pares[i]) {
                numMayor = pares[i];
            }
        }

        for (int j = 0; j < pares.length; j++) {
            if ((j + 1) % 2 == 0) {
                sumaPar = (sumaPar + (pares[j] * 2) + numMayor);
            }
        }

        return sumaPar;
    }

    /**
     * @param  impares
     * Vamos a comprobar los números en las posiciones impares pero antes hay que mirar cual es el menor
     * número a la derecha del que estamos comprobando actualmente
     * Una vez mirado, cogemos el número, lo multiplicamos por 3 y los sumamos al numMenor
     * @return Estas operaciones se guardan en una suma que se hace de los números en las posiciones impares
     */

    public static int comprobarImpares(int[] impares){
        int numMenor = 0;
        int sumaImpar = 0;

        for (int i = 0; i < impares.length; i++) {

            for (int j = i; j < impares.length; j++) {
                numMenor = impares[i];
                if (numMenor > impares[j]){
                    numMenor = impares[j];
                }
            }

            if ((i + 1) % 2 != 0) {
                sumaImpar = (sumaImpar + (impares[i] * 3) + numMenor);
            }
        }
        return sumaImpar;
    }
}
