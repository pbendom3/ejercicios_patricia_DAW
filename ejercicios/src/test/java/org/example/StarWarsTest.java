package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class StarWarsTest {

    @Test
    void direcciones() {

        //Le pasamos como entrada 'ISB'
        System.setIn(new ByteArrayInputStream("ISB".getBytes()));

        //Llamamos a la funcion direcciones para obtener el vector y comprobamos que sea correcto
        String[] result = StarWars.direcciones();

        //Asumimos que la longitud es == 3
        assert result.length == 3;

        //Y que cada posicion contiene la letra que corresponde.
        assert result[0].equals("I");
        assert result[1].equals("S");
        assert result[2].equals("B");

    }

    @Test
    void rellenarBordes() {

        //Rellenamos una hipotetica matriz de 5x5 de # en los bordes.
        String[][] pantalla = new String[5][5];
        StarWars.rellenarBordes(pantalla);

        for (int i = 0; i < pantalla.length; i++) {
            for (int j = 0; j < pantalla[i].length; j++) {
                if (i == 0 || i == pantalla.length - 1 || j == 0 || j == pantalla[i].length - 1) {

                    //Comprobamos que en los bordes hay '#'.
                    assert pantalla[i][j].equals("#");
                } else {

                    //Comprobamos que el resto de posiciones son espacios.
                    assert pantalla[i][j].equals(" ");
                }
            }
        }
    }
}