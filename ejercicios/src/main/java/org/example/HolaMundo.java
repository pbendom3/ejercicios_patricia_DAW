package org.example;

public class HolaMundo { //Definición de clase HolaMundo: esta línea usa la palabra clave class para declarar que se está definiendo una nueva clase. "HolaMundo" en este caso es un identificador que es el nombre de la clase. La definición de clase completa, incluidos todos sus miembros, estará entre la llave de apertura “{” y la llave de cierre “}”.
                         //El nombre de la clase definida por el programa HolaMundo debe ser igual que el nombre del archivo

    /* Este es un programa simple en Java...
   NombreArchivo: "HolaMundo.java". */

        // Tu programa comienza con una llamada a main().
        // Imprime "Hola Mundo" en la ventana de la terminal.

        public static void main(String[] args)
        //public: Para que la JVM (Máquina Virtual Java) pueda ejecutar el metodo desde cualquier lugar.
        //static: El metodo principal puede ser llamado sin crear el objeto
        //void: El metodo main no devuelve nada, por lo tanto, no hay que definirlo con un tipo de datos concreto.
        //main(): Nombre configurado como programa principal en la JVM.
        //String[]: El metodo principal acepta un único argumento: una matriz de elementos de tipo String (texto).
        //El metodo main es el punto de entrada para la aplicación, y posteriormente invocará todos los otros métodos requeridos por el programa.
        {
            System.out.println("Hola Mundo"); //La clase System pertenece al paquete java.lang (una biblioteca de funciones de Java), y sirve para manejar las entradas, salidas y manejo de errores.
        }
    }

