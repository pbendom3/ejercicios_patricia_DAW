package ParrillaDeSalidaProyecto;

import java.util.Scanner;

public class ParrillaDeSalida {
    public static void parrilaDeSalida(){
        final int MAXIMO_PILOTOS = 26; // Numero maximo de pilotos que participaran en una carrera
        final int NUM_DATOS_PILOTOS = 2; // El numero de campos que tiene la matriz para guardar los datos introducidos por el usuario

        int numeroPilotos;

        textoParrilla();
        System.out.println("Escriba el numero de pilotos que han terminado la carrera: ");
        numeroPilotos = pedirNumeroPilotos(MAXIMO_PILOTOS);
        System.out.println("Vamos a ingresar los resultados de la carrera con el nombre del piloto en orden de llegada y el numero de posiciones que a subido respecto a la parrilla de salida.");
        String[][] pilotos = pedirPilotos(numeroPilotos,MAXIMO_PILOTOS);
        textoParrilla();
        reconstruirParrila(pilotos,numeroPilotos,MAXIMO_PILOTOS);
    }
    public static void textoParrilla(){
        System.out.println("PARRILLA DE SALIDA");
        System.out.println("---------------------------------------");
    }

    public static int pedirNumeroPilotos(int maximoPilotos) {
        Scanner sc = new Scanner(System.in);
        int numero = -1;
        boolean valorCorrecto;

        do {
            String numeroStr = sc.nextLine();

            // Validar si la entrada es un número entero
            if (numeroStr.matches("\\d+")) { // \d+ asegura que sea un número positivo
                numero = Integer.parseInt(numeroStr); // Convertir a int
                valorCorrecto = true; // Número válido
                if (!verificarRango(numero,0,maximoPilotos)) // Verificar si el numero esta en el rango adecuado
                {
                    System.out.println("Debe ingresar una cantidad de pilotos de entre 0 a 26.");
                    valorCorrecto = false;
                }
            } else {
                System.out.println("Error. Debe ingresar un número entero válido.");
                valorCorrecto = false;
            }
        } while (!valorCorrecto);

        return numero;
    }

    public static boolean verificarRango(int numero, int minimo, int maximo) {
        return numero >= minimo && numero <= maximo;
    }

    public static String[][] pedirPilotos(int numeroPilotos,int maximoPilotos) {
        Scanner sc = new Scanner(System.in);
        String[][] pilotos = new String[2][numeroPilotos]; // Matriz 2xN: [0] para nombres, [1] para posiciones

        for (int i = 0; i < numeroPilotos; i++) {
            System.out.print("Ingrese el nombre del " + (i + 1) + "º piloto: ");
            pilotos[0][i] = sc.nextLine(); // Guardar nombre del piloto

            int posicionesMaxAdelantar = maximoPilotos - (i + 1); // Máximo que puede adelantar
            int posicionesMaxPerder = i; // Máximo que puede perder

            System.out.print("Ingrese cuántas posiciones ha adelantado o perdido " + pilotos[0][i] + ": ");
            while (true) {
                String posiciones = sc.nextLine();
                if (posiciones.matches("-?\\d+")) { // Validar que sea un número entero
                    int posicionesInt = Integer.parseInt(posiciones);
                    // Verificar que las posiciones no salgan del rango permitido
                    if (posicionesInt >= -posicionesMaxPerder && posicionesInt <= posicionesMaxAdelantar) {
                        pilotos[1][i] = posiciones; // Guardar posiciones válidas
                        break;
                    } else {
                        System.out.print("Error. El número de posiciones debe estar entre " + (-posicionesMaxPerder) + " y " + posicionesMaxAdelantar + ": ");
                    }
                } else {
                    System.out.print("Error. Ingrese un número válido para las posiciones: ");
                }
            }
        }
        return pilotos;
    }

    public static void reconstruirParrila(String[][] pilotos,int numero_pilotos,int numero_participantes){
        String[][] parrillaSalida = new String[2][numero_pilotos];
        String[][] parrillaSalidaOrdenada = new String [2][numero_pilotos];
        int posicion = 0;
        int posAdelantadas = 0;

        for(int pos_piloto = 0; pos_piloto < numero_pilotos; pos_piloto++){
            posAdelantadas = Integer.parseInt(pilotos[1][pos_piloto]);
            posicion = (pos_piloto+1)+posAdelantadas;

            parrillaSalida[0][pos_piloto] = pilotos[0][pos_piloto];
            parrillaSalida[1][pos_piloto] = Integer.toString(posicion);
        }
        parrillaSalidaOrdenada = ordenarParrilla(parrillaSalida,numero_pilotos);

        mostrarParrilla(parrillaSalidaOrdenada,parrillaSalida,numero_participantes,numero_pilotos);
    }

    public static void mostrarParrilla(String[][] parrillaOrdenada,String[][] parrillaSinOrdenar,int participantes,int numero_pilotos){
        int contador = 0;
        int posicion = 0;

        for (int i = 1; i <= participantes; i++){
            if (numero_pilotos > contador){
                posicion = Integer.parseInt(parrillaOrdenada[1][contador]);
                if (i == posicion)
                {
                    System.out.println(parrillaOrdenada[1][contador]+"º "+parrillaOrdenada[0][contador]);
                    contador++;
                } else{
                    System.out.println(i+"º --");
                }
            } else{
                System.out.println(i+"º --");
            }

        }

    }

    public static String[][] ordenarParrilla(String[][] parrillaSinOrdenar, int num_pilotos) {
        // Ordenar las posiciones (segunda fila) junto con los nombres (primera fila)
        // Usamos un comparador simple para ordenar en base a las posiciones (parrillaSinOrdenar[1])

        String[][] parrillaOrdenada = new String[2][num_pilotos];

        // Ordenar las filas basándonos en las posiciones (parrillaSinOrdenar[1])
        for (int i = 0; i < num_pilotos; i++) {
            for (int j = i + 1; j < num_pilotos; j++) {
                // Si la posición del piloto i es mayor que la del piloto j, los intercambiamos
                if (Integer.parseInt(parrillaSinOrdenar[1][i]) > Integer.parseInt(parrillaSinOrdenar[1][j])) {
                    // Intercambiar posiciones
                    String tempNombre = parrillaSinOrdenar[0][i];
                    String tempPosicion = parrillaSinOrdenar[1][i];
                    parrillaSinOrdenar[0][i] = parrillaSinOrdenar[0][j];
                    parrillaSinOrdenar[1][i] = parrillaSinOrdenar[1][j];
                    parrillaSinOrdenar[0][j] = tempNombre;
                    parrillaSinOrdenar[1][j] = tempPosicion;
                }
            }
        }

        // Ahora que está ordenada la parrilla por posiciones, devolvemos el resultado
        for (int i = 0; i < num_pilotos; i++) {
            parrillaOrdenada[0][i] = parrillaSinOrdenar[0][i]; // Nombres de los pilotos
            parrillaOrdenada[1][i] = parrillaSinOrdenar[1][i]; // Posiciones ordenadas
        }

        return parrillaOrdenada;
    }
}
