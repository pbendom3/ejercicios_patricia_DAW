package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase para calcular la distancia mínima a recorrer por Spiderman entre su posición y la de las 2 bombas
 * @author DENYS PETRYCHENKO OLIYNYK
 * @version 1.0 (16/12/2024)
 */
public class TuAmigableVecino {

    //Creación de objeto Scanner dentro de la clase para poder llamarlo desde cualquier méthodo que nos haga falta
    static Scanner entrada = new Scanner(System.in);

    /**
     * Este es el méthodo principal desde el que se llaman todos los demás méthodos
     */
    public static void casoPrueba(){

        mensajeBienvenida(); // El primer méthodo al que llama es a mensajeBienvenida()

        int casos = numeroDeCasos(); // El segundo méthodo llama a numeroDeCasos(), devuelve un número entero que se guarda como variable

        bucleCasos(casos); // El último méthodo es el desarrollo del programa como tal. Dentro de él se llaman a más méthodos.
        // Toma como parámetro el número de casos del méthodo anterior
    }

    /**
     * Este méthodo no devuelve nada como tal, simplemente se encarga de mostrar por pantalla el mensaje de bienvenida
     * así como el resto de mensajes iniciales (Intrucciones y Número de Casos)
     */
    public static void mensajeBienvenida(){
        System.out.println("BIENVENIDO A TU AMIGABLE VECINO");
        System.out.println("Las reglas son simples, introduce primero el número de casos y posteriormente");
        System.out.println("la posición de Spiderman y de la bomba A y B en ese orden separados por ','");
        System.out.println("Ten en cuenta que las posiciones deben de estar entre 0 y 10000");
        System.out.println("\nIntroduce primero el número de casos que quieres evaluar: ");
    }

    /**
     * Este méthodo se encarga de verificar y validar la entrada del número de casos introducidos por el usuario.
     * @return Devolverá un número entero, que se guardará en una variable dentro del méthodo casoPrueba().
     */
    public static int numeroDeCasos(){

        while (true) { // Bucle inicializado siempre en true
            try { // Try-Catch para controlar la entrada válida de números
                int casos = entrada.nextInt(); // Entrada de usuario guardada en una variable de tipo entero
                entrada.nextLine(); // Para limpiar el buffer
                if (casos > 0) { // Controlamos que la entrada sea mayor que 0
                    return casos; //
                } else {
                    System.out.println("El número de casos debe ser mayor que 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debes introducir un número entero..." + e.getMessage());
                entrada.nextLine(); // Necesario para que no entre en bucle
            }
        }
    }

    /**
     * Este méthodo toma el número de casos que ha introducido el usuario, y mediante un bucle que recorre el número
     * de casos valora las posteriores entradas, hace el control de datos de entrada y muestra la solución final
     * @param casos Toma como parámetro el número de casos introducido por el usuario en numeroDeCasos()
     */
    public static void bucleCasos(int casos){

        // Uso de bucle for para recorrer el número de casos introducido por el usuario
        for (int i = 0; i < casos; i++){

            String posiciones[] = introducirCadaCaso(i);  // Para cada iteración se guarda en un vector los valores de cada caso

            // Se comprueba que la longitud del vector sea exactamente de 3 valores. Si no es así decrementamos la iteración en 1
            // mostramos mensaje de Error y volvemos a empezar el bucle, con lo cual se volverá a pedir los datos de entrada de
            // introducirCadaCaso()
            if (posiciones.length != 3){
                System.out.println("Lo siento, debes introducir exactamente 3 POSICIONES SEPARADAS POR ','");
                i--;
                continue;
            }

            // Llamada al méthodo comprobarFormatoNumerico() con el parámetro del vector posiciones para comprobar que el vector
            // cumpla con los requisitos de formato numérico. Si no cumple con los requisitos, mostramos mensaje de Error,
            // decrementamos la iteración en 1 y volvemos a empezar el bucle, con lo cual se volverá a pedir los datos de entrada de
            // introducirCadaCaso()
            if (comprobarFormatoNumerico(posiciones)){
                System.out.println("ERROR. Debes introducir números, NO CARACTERES.");
                i--;
                continue;
            }

            // Llamada al méthodo comprobacionRango() con el parámetro del vector posiciones para comprobar los valores del vector
            // cumplan con los requisitos de rango (entre 0 y 10000). Si no cumple con los requisitos, mostramos mensaje de Error,
            // decrementamos la iteración en 1 y volvemos a empezar el bucle, con lo cual se volverá a pedir los datos de entrada de
            // introducirCadaCaso()
            if (comprobacionRango(posiciones)) {
                System.out.println("ERROR. Las posiciones deben estar ENTRE 0 Y 10000.");
                i--;
                continue;
            }

            // Si se cumplen todas las verificaciones, se muestra el mensaje con la solución para el caso de la presente iteración
            // llamada por el méthodo resolucio() con el parámetro del vector posiciones
            System.out.println("La distancia mínima que recorrerá Spiderman es: " + resolucion(posiciones));
        }
    }

    /**
     * Este méthodo pide al usuario que introduzca los valores de posición para cada caso y los almacena en un vector de tipo String
     * que posteriormente devuelve al méthodo bucleCasos()
     * @param i Es el valor de la iteración que está recorriendo el bucle de bucleCaso()
     * @return Devuelve un vector de tipo String
     */
    public static String[] introducirCadaCaso(int i){

        System.out.println("Introduce las posiciones para el caso " + (i+1) + ": ");

        String posiciones[] = entrada.nextLine().split(" "); //Guarda en el vector posiciones los datos de entrada
        // separados por ','

        return posiciones; // Devuelve el vector arriba definido
    }

    /**
     * Méthodo para validar el rango númerico para los valores del vector posiciones (entre 0 y 10000)
     * @param posiciones es el vector definido por el usuario en introducirCadaCaso()
     * @return devuelve un valor booleano True o False, dependiendo de la comprobación
     */
    public static boolean comprobacionRango(String[] posiciones) {

        int numero = 0; // Definición de variable de tipo entero
        boolean comprobacion = false; //Definición de booleano comprobacion inicializado en False

        for (int i = 0; i < posiciones.length; i++) { // Bucle para recorrer las posiciones del vector

            numero = Integer.parseInt(posiciones[i]); // Cada posición se transforma a número entero y se guarda
                                                    // en la variable numero
            if (numero < 0 || numero > 10000) {// Si el numero está por encima de 10000 o por debajo de 0 devuelve True

                comprobacion = true; // actualización de comprobacion a True
                return comprobacion; // Se devuelve True
            }
            // No se ha incluído un else que devuelva False en ya que podría dar lugar a falsos positivos. Es decir,
            // si por ejemplo, el último valor cumple con los requisitos pero el resto no, nos estaría arrojando
            // una comprobación errónea, a su vez, nos interesa ver que, si únicamente un valor es inválido, nos arroje True
        }
        // Si esta todó correcto devuelve False
        return comprobacion;
    }

    /**
     * Méthodo para validar el formato numérico del vector posiciones
     * @param posiciones es el vector definido por el usuario en introducirCadaCaso()
     * @return devuelve un valor booleano True o False, dependiendo de la comprobación
     */
    public static boolean comprobarFormatoNumerico(String[] posiciones) {

        boolean comprobacion = false; // Definición de variable booleana comprobacion inicializada en False

        for (int i = 0; i < posiciones.length; i++) { // Bucle para recorrer las posiciones del vector

            if (!posiciones[i].matches("\\d{1,5}")) { // Si alguna de las posiciones del vector posiciones
                                                            // no concuerda con un dígito de 1 a 5 números (0-99999)
                                                            // actualiza comprobación a True y lo devuelve
                comprobacion = true;
                return comprobacion;
            }
        }
        // Si todó está correcto, devuelve comprobación como False (tal y como la inicializamos)
        return comprobacion;
    }

    /**
     * Méthodo para la resolución de cada caso a partir de los valores válidos del usuario.
     * Cálculo de la distancia mínima que recorrerá Spiderman para desactivar ambas bombas.
     * @param posiciones es el vector definido por el usuario y ya validado por los anteriores Méthodos
     * @return devuelve un número entero que corresponde a la distancia mínima que se recorre en cada caso
     */
    public static int resolucion(String[] posiciones) {

        // Definición de las variables necesarias a utilizar
        int spiderman = Integer.parseInt(posiciones[0]); // La posición de Spiderman es el primer valor del vector
        int bombaA = Integer.parseInt(posiciones[1]); // La posición de la bomba A es el segundo valor del vector
        int bombaB = Integer.parseInt(posiciones[2]); // La posición de la bomba B es el tercer y último valor del vector

        int distancia1 = 0; // Variable para el cálculo de la distancia S-A-B
        int distancia2 = 0; // Variable para el cálculo de la distancia S-B-A
        int distancia = 0; // Variable para devolver la distancia mínima

        if (bombaA < spiderman && bombaB > spiderman || bombaB < spiderman && bombaA > spiderman){
            // El supuesto de que Spiderman este entre cualquiera de las dos bombas.

            distancia1 = Math.abs(spiderman - bombaA) + Math.abs(bombaA - bombaB); // Se calcula la distancia S-A-B en valor absoluto
            distancia2 = Math.abs(spiderman - bombaB) + Math.abs(bombaB - bombaA); // Se calcula la distancia S-B-A en valor absoluto
            distancia =  Math.min(distancia1, distancia2); // distancia es la distancia mínima entre distancia1 y distancia2

        } else if (bombaA > spiderman && bombaB > spiderman) {
            // El supuesto de que Spiderman se encuentre antes de las bombas A y B.

            distancia = Math.abs(spiderman-Math.max(bombaA,bombaB)); // La distancia mínima que recorrerá es el valor absoluto entre
            // su posición y la bomba que se encuentre más alejada Math.max(bombaA, bombaB). Ya que la otra bomba está entre medias y
            // le cae de camino.

        } else if (bombaA < spiderman && bombaB < spiderman) {
            // El supuesto de que Spiderman se encuentre después de las bombas A y B.

            distancia = Math.abs(spiderman-Math.min(bombaA,bombaB)); // La distancia mínima que recorrerá es el valor absoluto entre
            // su posición y la bomba que se encuentre más alejada Math.min(bombaA, bombaB). En este caso usamos .min ya que Spiderman
            // se encuentra a la derecha del eje de abscisas y las bombas a la izquierda, más cercanas al 0.
        }
        return distancia; // El méthodo devuelve esta distancia como la distancia mínima.
    }
}
