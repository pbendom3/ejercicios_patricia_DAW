package org.example;

public class Sobrecarga {

    static void saludar()
    {
        System.out.println("Hola, cómo estás??");
    }
    static String saludar(String nombre)
    {
        return "Hola " + nombre + ", cómo estás??";
    }
    static String saludar(String nombre, String ciudad)
    {
        return "Hola" + nombre + ", qué tal por "+ciudad+"??";
    }
}
