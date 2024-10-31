package org.example;

import java.util.Scanner;

public class ISBN {

    public void validar(){

        Scanner teclado = new Scanner(System.in);
        System.out.println("Inserta un ISBN: ");
        String isbn = teclado.next();

        int suma = 0;
        int aux = 0;

        if (isbn.length()!=10){
            System.out.println("El formato introducido no es correcto." + isbn.length());
        }else{

            for (int i = 10; i>=1; i--){
//
//                switch ()
//                suma += i * Integer.parseInt(String.valueOf(isbn.charAt(aux)));
//                aux++;

                System.out.println(suma);
            }

            if (suma%11==0){
                System.out.println("El ISBN es válido.");
            }else{
                System.out.println("El ISBN no es válido.");
            }

        }



    }


}
