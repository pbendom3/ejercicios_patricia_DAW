package org.example;

public class Triangulo {

    public static void main (String[] args){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

        String var = "";
        for (int i = 0; i < 3; i++) {
            var += "* ";
            System.out.println(var);
        }

    }


}
