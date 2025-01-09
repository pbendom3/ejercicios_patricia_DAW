package org.example;
import java.util.Scanner;

/**
 * Juego del Ahorcado/Verdugo
 * El jugador 1 introduce una palabra, y el jugador 2 intenta adivinarla letra por letra
 * El programa termina cuando el jugador 2 adivina la palabra o se introduce un "."
 * @author Ismael
 * @version 1.1 (17/12/2024)
 */
public class Verdugo {

    /**
     * Este es el metodo principal del juego
     * - Se lee la palabra del jugador 1
     * - Validamos que no tenga numeros
     * - Pedimos las letras del jugador 2
     * - Llama al metodo comprobacion para vercomo hemos quedado en el juego
     */
    public static void principal() {
        Scanner teclado = new Scanner(System.in);
        String resultado;

        while (true) {
            String respuesta = teclado.nextLine().trim(); //Leemos la palabra del jugador 1
            if (respuesta.equals(".")) { //Finalizamos si ponemos "."
                break;
            }

            //Validamos que la palabra solo tenga letras
            if (!respuesta.matches("[a-zA-Z]+")) {
                break;//Sale del bucle si no se pone lo que queremos
            }

            //Cogemos las letras de la palabra del jugador 1 y las del jugador 2
            String[] letrasUsuario1 = usuario1(respuesta);
            String[] letrasUsuario2 = usuario2Adivinador();

            //Compruebamos como hemos quedado en el juego y lo imprimimos
            resultado = comprobacion(letrasUsuario1, letrasUsuario2);
            System.out.println(resultado);
        }
    }

    /**
     * Convierte la palabra del jugador 1 en un vector
     * @param respuesta Palabra introducida por el jugador 1
     * @return Vector con las letras de la palabra del jugador 1
     */
    public static String[] usuario1(String respuesta) {
        String palabra = respuesta.toLowerCase(); //Convertimos a minusculas
        String[] letrasUsuario1 = palabra.split(""); //Dividimos la palabra en letras
        return letrasUsuario1;
    }

    /**
     * Lee las letras del jugador 2
     * @return Vector con las letras introducidas por el jugador 1
     */
    public static String[] usuario2Adivinador() {
        Scanner teclado = new Scanner(System.in);
        String letras;

        while (true) {
            letras = teclado.nextLine().toLowerCase(); //Leemos las letras introducidas por el jugador 2

            //Validamos que la palabra solo tenga letras
            if (!letras.matches("[a-zA-Z]+")) {
                //Si no es valido, sigue solicitando
            } else {
                break; //Sale del bucle si es valido ya que tenemos la palabra con la que vamos a trabajar
            }
        }

        String[] letrasUsuario2 = letras.split(""); //Divide las letras en un vector
        return letrasUsuario2;
    }

    /**
     * Compara las letras del jugador 2 con la palabra del jugador 1
     * @param letrasUsuario1 Vector con las letras de la palabra del jugador 1
     * @param letrasUsuario2 Vector con las letras introducidas por el jugador 2
     * @return Resultado del juego (AHORCADO,COLGANDO o SALVADO)
     */
    public static String comprobacion(String[] letrasUsuario1, String[] letrasUsuario2) {
        int falladas = 0;
        String letrasAcertadas = "";
        String letrasFalladas = "";
        int letrasEncontradas = 0;

        //Hacemos el bucle por cada letra introducida por el jugador 2(adivinador)
        for (int i = 0; i < letrasUsuario2.length; i++) {
            String letra = letrasUsuario2[i];

            //Ignoramos letras ya revisdas
            if (letrasAcertadas.contains(letra) || letrasFalladas.contains(letra)) {
                continue;
            }

            boolean encontrada = false; //Indicamos si la letra esta en la palabra
            for (int j = 0; j < letrasUsuario1.length; j++) {
                if (letra.equals(letrasUsuario1[j])) { //Comparamos letra por letra todas las letras
                    encontrada = true;
                    break;
                }
            }

            if (encontrada) {
                letrasAcertadas += letra; //Si se acierta una letra se suma a la variable
                letrasEncontradas++; //Si se encuentra una letra se suma a la variable
            } else {
                letrasFalladas += letra;
                falladas++;
            }

            //Si hay 7 fallos, el jugador 2 (Adivinador) pierde
            if (falladas >= 7) {
                return "AHORCADO";
            }

            //Si todas las letras han sido adivinadas, el jugador 2 gana
            if (letrasEncontradas == letrasUsuario1.length) {
                return "SALVADO";
            }
        }

        //Si no se cumple todo lo anterior el juego sigue
        return "COLGANDO";
    }
}
