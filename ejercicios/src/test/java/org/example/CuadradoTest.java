package org.example;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CuadradoTest {

    @BeforeEach
    void pedirNumero() {

        //simulamos que el usuario ingresa caracteres
        String entradaSimulada = "aaa"; // 'a' es un carácter no válido
        System.setIn(new ByteArrayInputStream(entradaSimulada.getBytes()));

        //creamos un ByteArrayOutputStream para guardar la salida por consola
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        Cuadrado cuadrado = new Cuadrado();

        //llamamos al metodo que procesa la entrada
        int resultado = cuadrado.pedirNumero();

        //verificamos que el valor que devuelve es el esperado (-1)
        assertEquals(-1, resultado);

        //verificamos que se haya impreso el mensaje de error esperado
        String salidaEsperada = "ERROR de formato.";
         //assertEquals(salidaEsperada, salida.toString().trim());
        assertTrue(salida.toString().trim().contains(salidaEsperada));

    }

    @Test
    void validarNumero() {

        assertAll(
                () -> assertTrue(Cuadrado.validarNumero(2)),
                () -> assertTrue(Cuadrado.validarNumero(20)),
                () -> assertFalse(Cuadrado.validarNumero(1000000000)),
                () -> assertTrue(Cuadrado.validarNumero(10000000)),
                () -> assertTrue(Cuadrado.validarNumero(-3))
        );

    }

    @Test
    void calcularCuadrado() {

        assertAll(

                () -> assertEquals(64,Cuadrado.calcularCuadrado(8)),
                () -> assertEquals(100,Cuadrado.calcularCuadrado(-10)),
                () -> assertEquals(0,Cuadrado.calcularCuadrado(0))

        );

    }
}