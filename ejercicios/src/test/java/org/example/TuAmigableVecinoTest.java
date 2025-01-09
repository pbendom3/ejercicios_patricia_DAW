package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuAmigableVecinoTest {

    @Test
    void casoPrueba() {
        // No es necesario hacer test ya que desde este méthodo se llama a los demás méthodos. Hay que evaluarlos
        // individualmente
    }

    @Test
    void mensajeBienvenida() {
        // No es necesario comprobar errores ya que simplemente muestra los mensajes de bienvenida que se espera
    }

    @Test
    void bucleCasos() {
        // Desde este méthodo de igual manera que en casoPrueba() se llama a más méthodos, con lo cual analizamos
        // cada uno de ellos por separado e individualmente
    }

    @Test
    void introducirCadaCaso() {

        String entradaVálida = "100,200,400";
        String [] vectorEsperado = {"100","200","400"};

       assertArrayEquals(vectorEsperado,entradaVálida.split(" "));
       // Se comprueba que el méthodo introducirCadaCaso() separa correctamente cada valor de la cadena de texto separada
        // por ',' y lo guarda en un vector de longitud variable
    }

    @Test
    void comprobacionRango() {

        // En caso de que todas las posiciones esten dentro del rango
        String[] posicionesVálidas = {"500", "2000", "8000"};
        assertFalse(TuAmigableVecino.comprobacionRango(posicionesVálidas));
        // Devuelve False para posiciones que esten dentro del rango

        // En caso de que una posición o más esten fuera del rango
        String[] posicionesInvalidas = {"500", "20000", "8000"};
        assertTrue(TuAmigableVecino.comprobacionRango(posicionesInvalidas));
        // Devuelve True para posiciones que esten fuera del rango
    }

    @Test
    void comprobarFormatoNumerico() {

        // En caso de que todas las posiciones sean números
        String[] posicionesValidas = {"200", "300", "400"};
        assertFalse(TuAmigableVecino.comprobarFormatoNumerico(posicionesValidas));
        // Devuelve False si el formato es válido

        // En caso de que una o varias posiciones contengan caracteres no numéricos
        String[] posicionesInvalidas = {"123", "hola", "456"};
        assertTrue(TuAmigableVecino.comprobarFormatoNumerico(posicionesInvalidas));
        // Devuelve True si el formato  no es válido
    }

    @Test
    void resolucion() {

        // Supusto1: Spiderman entre las dos bombas
        String[] posiciones1 = {"100", "0", "200"};
        assertEquals(300,TuAmigableVecino.resolucion(posiciones1));
        // True si la distancia mínima esperada es 300

        // Supuesto2: Spiderman antes que las bombas
        String[] posiciones2 = {"100", "200", "300"};
        assertTrue(TuAmigableVecino.resolucion(posiciones2) == 200);
        // True si la distancia mínima esperada es 200

        // Supuesto3: Spiderman después de las bombas
        String[] posiciones3 = {"1000", "2000", "500"};
        assertTrue(TuAmigableVecino.resolucion(posiciones3) == 2000);
        // True si la distancia mínima esperada es 2000

        //Supuesto4: Todos en la misma posición
        String[] posiciones4 = {"2000", "2000", "2000"};
        assertTrue(TuAmigableVecino.resolucion(posiciones4) == 0);
        // True si la distancia mínima esperada es 0

        //Supuesto5: Las bombas en la misma posición
        String[] posiciones5 = {"1000", "2000", "2000"};
        assertTrue(TuAmigableVecino.resolucion(posiciones5) == 1000);
        // True si la distancia mínima esperada es 1000
    }
}