package org.example;

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



}
