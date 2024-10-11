package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CosasStrings {

    public void caracteres(){

        String frase = "No me porto mal en clase y no lo reconozco.";

        int tamanyo = frase.length();
        System.out.println("El tamaño de la frase es " + tamanyo);

        char letra = frase.charAt(33);
        System.out.println("La letra en la posición 33 es " + letra);

        String palabra = frase.substring(9,12);
        System.out.println("La palabra con substring es " + palabra);

        String palabra2 = " Parte.";
        String concatenacion = frase.concat(palabra2);
        System.out.println("La concatenación de la frase con la palabra " + palabra2 + " es " + concatenacion);

        int posicion = concatenacion.indexOf(palabra2);
        System.out.println("La palabra " + palabra2 + " está en la posición " + posicion);

        int posicion2 = concatenacion.indexOf("no",8);
        System.out.println("La posición de la palabra 'no' si no tenemos en cuenta las 8 primeras posiciones es " + posicion2);

        int posicion3 = concatenacion.lastIndexOf(" no ");
        System.out.println("La posición de la última aparición de la palabra 'no' es " + posicion3);

        String mayusculas = frase.toUpperCase();
        String minusculas = frase.toLowerCase();
        System.out.println("La frase en mayúsculas es " + mayusculas +  " y la frase en minúsculas es " + minusculas);

        String nombre = "Patricia                      ";
        nombre = nombre.trim();
        System.out.println("Tu nombre sin espacios es " + nombre + ".");

        String reemplazar = frase.replace("mal", "bien");
        System.out.println("La frase con la palabra 'mal' reemplazada por 'bien' que así: " + reemplazar);

        String reemplazar_espacios = reemplazar.replace(" ", "");
        System.out.println("La frase sin espacios queda " +  reemplazar_espacios);

        String palabra3 = "hola";
        String palabra4 = "Hola";

        if (palabra3.equals(palabra4)==true){
            System.out.println("Las palabras " + palabra3 + " y " + palabra4 + " son iguales.");
        }else{
            System.out.println("Las palabras " + palabra3 + " y " + palabra4 + " son distintas.");
        }

        if (palabra3.equalsIgnoreCase(palabra4)==true){
            System.out.println("Las palabras " + palabra3 + " y " + palabra4 + " son iguales.");
        }else{
            System.out.println("Las palabras " + palabra3 + " y " + palabra4 + " son distintas.");
        }

        

    }


    public void ejercicio3(){

        Scanner teclado = new Scanner(System.in);
        boolean err = true;
        int n = 0;
        int m = 0;

        while (err){
            try{
                System.out.println("Introduce un número...");
                n = teclado.nextInt();
                System.out.println("Introduce otro número para quitar las cifras al anterior...");
                m = teclado.nextInt();
                if (n>m){
                    err=false;
                }else{
                    System.out.println("No se pueden quitar más cifras de las que hay.");
                }

            }catch (InputMismatchException e){
                System.out.println("El formato no es correcto (numérico)");
                teclado.nextLine();
            }
        }

        String n_string = Integer.toString(n);
        int tamanyo = n_string.length();

        n_string = n_string.substring(0, tamanyo-m);

        System.out.println("El número sin las " + m + " cifras es " + n_string);



    }

    public void ejercicio4(){

        Scanner teclado = new Scanner (System.in);

        System.out.println("Introduce una frase: ");
        String frase = teclado.nextLine();
        frase = " " + frase + " ";
       // frase = frase.replace(".", " ");
        frase=frase.replaceAll("[^\\p{Alpha}]+"," "); //eliminamos caracteres especiales
        frase = frase.toLowerCase();

        System.out.println("Introduce una subcadena: ");
        String subcadena = teclado.nextLine();
        subcadena = " " + subcadena + " ";

        int fraselength = frase.length();
        int frasesinsubcadena = frase.replace(subcadena, "").length();

        int division = (fraselength - frasesinsubcadena) / subcadena.length();
        System.out.println(division);


    }



}
