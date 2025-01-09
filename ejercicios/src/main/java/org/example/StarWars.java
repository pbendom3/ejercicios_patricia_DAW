package org.example;
import java.util.Scanner;


/**
 * Clase para calcular el rumbo de una nave de StarWars. En ella se vera una grafica con subidas y bajadas.
 * @author César Portero Pestaña
 * @version 1.2 (17/12/2024)
 */
public class StarWars {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) { //En el main se llama a la funcion principal.

        entrada = new java.util.Scanner(System.in);
        while (principal()) { //Se hará un blucle del prgrama hasta que se cierre manualmente o haya un error.
        }
    }

    /**
     *En este metodo se llaman a los demas metodos necesarios para llevar a cabo el programa
     * @return - ambos return se usan para controlar los casos de prueba. En caso
     */
    public static boolean principal () { //En este metodo simplemente se llama a los metodos que estan mas adelante explicados.

        if (!entrada.hasNext()) {

            return false;

        } else {

            entrada.nextLine();

            intro();

            String [] direcciones = direcciones(); //Guardamos el vector que devuelve la funcion en la variable direcciones.

            String [][] pantalla = new String[5][direcciones.length + 2]; //Creamos una matriz que tenga el ancho capaz de contener a direcciones y a los bordes.

            rellenarBordes(pantalla);

            rellenarPantalla(pantalla, direcciones);

            imprimirPantalla(pantalla);

            return true;
        }
    }

    /**
     * Este metodo imprime unos caracteres ASCII con forma de nave espacial para imprimir una intro bonita
     */
    public static void intro () {

        System.out.println("⠀   ______________________________________________________________________\n" +
                "  |:..                                                      ``:::%%%%%%HH|\n" +
                "  |%%%:::::..                S T A R    W A R S                `:::::%%%%|\n" +
                "  |HH%%%%%:::::....._______________________________________________::::::|\n" +
                "\n" +
                "   __________________________________\n" +
                "  |:                           ``::%H|\n" +
                "  |%:.       César Portero        `:%|\n" +
                "  |H%::..___________________________:|\n" +
                "\n" +
                "                        .                      .             +        .\n" +
                "     .    __ _o|                        .\n" +
                "         |  /__|===--        .                                       <=>\n" +
                "         [__|______~~--._                      .                .      .\n" +
                "   .    |\\  `---.__:====]-----...,,_____                *      .         ` -\n" +
                "        |[>-----|_______<----------_____;::===--\n" +
                "        |/_____.....-----'''~~~~~~~                        .               .\n" +
                "   +               .                                   1ºDAW. PROGRAMACIÓN\n" +
                "\n" +
                "------------------------------------------------\n");

    }// Este metodo simplemente imprime un mensaje por pantalla.

    /**
     * Con este metodo pasamos a vector la cadena introducida por el usuario una vez ha sido comprobada
     * @return
     */
    public static String [] direcciones () {

        System.out.println(" > I = Igual. S = Subir. B = Bajar.");
        System.out.println(" > Introduce un maximo de 100 direcciones. (ISB): ");

        String cadena = comprobarDirecciones(); //Llamamos al metodo para comprobar que la cadena tiene las condiciones que queremos.

        return cadena.toUpperCase().split(""); //Devolvemos un vector a principal.
    }

    /**
     * Con este metodo comprobamos que las direcciones que introducimos solo contengan las letras ISB y que la cadena sea menor de 100 caracteres
     * @return - Devolvemos la cadena que hemos pedido y comprobado.
     */
    public static String comprobarDirecciones () {

        String cadena = entrada.next(); //Pedimos la cadena

        if (!cadena.toUpperCase().matches("[ISB]+")){ //Controlamos que tenga los caracteres que queremos.

            System.err.println("ERROR. INDICACIONES INCORRECTAS (I-S-B). FALLO CRITICO!");
            System.exit(0);

        }else if (cadena.length() > 100){ //Controlamos que no sea mas lagra de lo permitido

            System.err.println("ERROR. COMANDO FUERA DE LOS LIMITES ESPACIALES! INTRODUCE 100 DIRECCIONES COMO MAXIMO...");
            System.exit(0);

        }

        return cadena; //Devolvemos cadena al metodo direcciones.
    }

    /**
     * En este metodo se rellenan los bordes de la matriz
     * @param pantalla - pantalla hace refenencia a la matiz que se va a rellenar
     * @return - devolvemos una matriz (pantalla) con los bordes llenos de '#'
     */
    public static String [][] rellenarBordes (String [][] pantalla) {

        //Con estos dos buclles recorremos la matriz
        for (int i = 0; i < pantalla.length; i++) {
            for (int j = 0; j < pantalla[i].length; j++) {

                if (i == 0 || i == pantalla.length - 1 || j == 0 || j == pantalla[i].length - 1) { //En caso de estar en un lateral guardamos un '#'

                    pantalla[i][j] = String.valueOf('#');

                } else {

                    pantalla[i][j] = String.valueOf(' ');//En cualquier otra posicion guardamos un espacio.

                }
            }
        }

        return pantalla;
    }

    /**
     * En este metodo se va rellenando la matriz segun las letras que indica en vector direcciones.
     * @param pantalla - Le pasamos la pantalla con '#' en los bordes
     * @param direcciones - Le pasamos el vector con las letras que indican las direccciones
     */
    public static void rellenarPantalla (String [][] pantalla, String [] direcciones) {

        int alturaActual = 3;
        int columnaActual = 1;

        for (int k = 0; k < direcciones.length; k++) {
            String direccion = direcciones[k];

            if (direccion.equals("I")) {

                pantalla[alturaActual][columnaActual] = "_";

            } else if (direccion.equals("S")) {
                if (alturaActual == 0){

                    System.err.println("ERROR. NIVEL DE LA NAVE POR ENCIMA DEL LIMITE. PERDMOS SEÑL...");
                    System.exit(0);

                }

                pantalla[alturaActual][columnaActual] = "/";
                alturaActual--;

            } else if (direccion.equals("B")) {
                alturaActual++;

                if (alturaActual == 4){

                    System.err.println("ERROR. NIVEL DE LA NAVE POR DEBAJO DE 0. ¡¡IMPACTO INMINENTE!!");
                    System.exit(0);

                }

                pantalla[alturaActual][columnaActual] = "\\";

            }

            columnaActual++;

        }
    }

    /**
     * Este metodo imprime por pantalla la matriz
     * @param pantalla - Le pasamos la matriz con los simbolos ya guardados.
     */
    public static void imprimirPantalla (String [][] pantalla) {

        for (int i = 0; i < pantalla.length; i++) {

            for (int j = 0; j < pantalla[i].length; j++) {
                System.out.print(pantalla[i][j]);
            }

            System.out.println();

        }
    }


}







