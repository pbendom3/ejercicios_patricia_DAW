package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Vectores {

    public void vectores(){

        int vector[];

        vector = new int[7];

        vector[2] =  7;
        vector[5] = vector[2]+4;

        System.out.println(vector[2] + " " + vector[5]);

        for (int i=0;i<vector.length;i++){
            System.out.print(" " + vector[i] + ", ");
        }

        String palabras[] = new String[3];
        palabras[0] = "Pepe";
        palabras[1] = "Juan";

        for (int i=0; i<palabras.length;i++){
            System.out.print(" " + palabras[i] + " ");
        }

    }

    public void ejercicio1(){

        Random aleatorio = new Random();

        int numeros[] = new int[8];
        int suma = 0;

        for (int i=0;i<numeros.length;i++){

            numeros[i] = aleatorio.nextInt(501);
            suma+=numeros[i];

        }

        System.out.println("La suma de los elementos es: " + suma);

    }

    public void ejercicio2(){

        Scanner teclado = new Scanner(System.in);
        int numeros[] = new int[4];

        int ultima_posicion = numeros[numeros.length-1];

        System.out.println("Introduce los números a invertir...");

        for (int i=0; i<numeros.length;i++){

            numeros[i] = teclado.nextInt();

        }

        int tam_mitad = numeros.length / 2;
        int aux;

        for (int i=0;i<tam_mitad;i++){

            aux = numeros[i];
            numeros[i]=numeros[numeros.length-1-i];
            numeros[numeros.length-1-i] =  aux;

        }

//        for(int i=numeros.length-1;i>=0;i--){
//            System.out.print(" " + numeros[i] + " ");
//        }

        for (int i = 0; i < numeros.length ; i++) {
            System.out.print(" " + numeros[i] + " ");
        }


    }

    public void ejercicio3(){

        Random aleatorio = new Random();
        Scanner teclado = new Scanner(System.in);

        int numeros[] = new int[25];
        int num = 0;
        int contador = 0;

        for (int i=0; i<numeros.length;i++){

            numeros[i] = aleatorio.nextInt(101);

        }

        System.out.println("Introduce un número [0,100]:");
        num = teclado.nextInt();

        for (int i=0; i<numeros.length;i++){

            System.out.print(" " + numeros[i] +  " ");

            if(num==numeros[i]){
                contador++;
            }

        }

        System.out.println("\n El número " + num + " aparece " + contador +" veces en el array.");




    }

    public void ejercicio5(){

        int numeros[] = {3,5,2,1,4};

        int ultima_posicion = numeros[numeros.length-1];

        for (int i=numeros.length-1;i>=0;i--){

            if(i==0){
                numeros[i] = ultima_posicion;
            }else{
                numeros[i] = numeros[i-1];
            }

        }

        for (int i =0;i<numeros.length;i++){

            System.out.print(numeros[i]);

        }

    }

    public void vectores2(){

        String palabras[] = {"Paco","Pepe","Juan","Maria"};

        for(String i : palabras){

            System.out.print(i);

        }

        String texto_vector = Arrays.toString(palabras);
        System.out.println("\n " + texto_vector);

        String palabras2[] = palabras;

        palabras2[0]="Francisco";

        System.out.println(palabras);
        System.out.println(palabras2);
        System.out.print(Arrays.toString(palabras));
        System.out.print(Arrays.toString(palabras2));

        String palabras3[] =  palabras.clone();

        palabras3[1] = "Lourdes";
        System.out.println(palabras3);
        System.out.print(Arrays.toString(palabras));
        System.out.print(Arrays.toString(palabras3));

        String nombres_chachis[] = new String[2];

        System.arraycopy(palabras,0,nombres_chachis,0,2);


        System.out.print(Arrays.toString(nombres_chachis));

        hasta10:
        for (int i=0;i<10;i++){
            hasta5:
            for (int j=0; j<5;j++){
                System.out.println(j);
                break hasta10;
            }
        }






    }

    public void ejercicio4(){

        Scanner teclado = new Scanner(System.in);

        int enteros[] = {4,3,5,19,34,75,4};

        int enteros2[] = new int[enteros.length-1];

        System.out.println("Introduce una posición a eliminar...");
        int eliminar = teclado.nextInt();

        System.out.println(Arrays.toString(enteros));

        for (int i = 0; i < enteros.length-1; i++) {

            if (i < eliminar){
                enteros2[i] = enteros[i];
            }else{
                enteros2[i] = enteros[i+1];
            }

        }

        System.out.println(Arrays.toString(enteros2));


    }

    public void samurais(){

        Scanner teclado = new Scanner(System.in);
        int intro_equipo = 1;

        do {

            System.out.println("Equipo " + intro_equipo);

            System.out.println("Introduce potencia de los samurais: ");
            String entrada_equipo = teclado.nextLine();
            String equipo[] = entrada_equipo.split(" ");
            int equipo1[];
            int equipo2[];
            int potencia = 0;

            if (equipo.length == 7){

                int equipo_int[] = new int[equipo.length];

                for (int i = 0; i < equipo.length; i++) {

                    equipo_int[i] = Integer.parseInt(equipo[i]);
                    potencia += equipo_int[i];

                }

                if (potencia != 30){
                    System.out.println("ERROR. La potencia total no suma 30.");
                    continue;
                }else{
                    if (intro_equipo==1){
                        intro_equipo=2;
                        equipo1 = equipo_int.clone();
                    }else{
                        equipo2 = equipo_int.clone();
                        intro_equipo = 3;
                    }

                }

            }else{
                 System.out.println("ERROR. No hay 7 samuráis.");
                 System.out.println(Arrays.toString(equipo));
            }

        }while(intro_equipo<=2);

        System.out.println("Hola");


    }

    public void navidad(){

        Scanner teclado = new Scanner(System.in);

        final String palabra = "NAVIDAD";

        System.out.println("Introduce la cantidad de letras a mostrar...");
        String cantidad = teclado.nextLine();

        String cantidades[] = cantidad.split(" ");
        String letras[] = palabra.split("");

        System.out.println(Arrays.toString(cantidades));
        System.out.println(Arrays.toString(letras));

        String resultado = "";

        for (int i=0;i<letras.length;i++){
            for(int j=0;j<Integer.parseInt(cantidades[i]);j++){
                resultado = resultado + letras[i];
            }

        }

        System.out.println(resultado);

    }

    public void prueba_buscar(){

        String colores[] = {"amarillo","azul","rojo","naranja"};
        String color = "negro";

        boolean existe = Arrays.asList(colores).contains(color);

        if (existe){
            System.out.println("El color " +  color + " existe en el vector.");
        }else{
            System.out.println("El color " + color + " no existe en el vector");
        }


    }


    public void ruleta(){

        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        String colores[]  = {"rojo","negro"};
        Integer numeros[] =  new Integer[37];

        for (int i=0;i<numeros.length;i++){
            numeros[i] = i;
        }

        String pares[] = {"par","impar"};

        System.out.println("Número (0-36): ");
        int numero = teclado.nextInt();

        boolean numero_existe = Arrays.asList(numeros).contains(numero);
        String color = "";
        String par = "";

        if (!numero_existe){
            System.out.println("ERROR. El número no es válido.");
            return;
        }else{
            if (numero!=0){
                System.out.println("Color (rojo-negro): ");
                color = teclado.next();

                boolean color_existe = Arrays.asList(colores).contains(color);

                if (!color_existe){
                    System.out.println("ERROR. El color no es válido.");
                    return;
                }else{
                    System.out.println("Introduce la opción par o impar: ");
                    par = teclado.next();
                    boolean par_existe = Arrays.asList(pares).contains(par);

                    if (!par_existe){
                        System.out.println("ERROR. La opción par/impar no es válida.");
                        return;
                    }

                }

            }

        }

        int numero_sorteo = numeros[aleatorio.nextInt(37)];
        String color_sorteo = colores[aleatorio.nextInt(2)];
        String pares_sorteo = "";

        if (numero_sorteo%2==0){
            pares_sorteo = "par";
        }else{
            pares_sorteo = "impar";
        }

        System.out.println("Ha tocado " + numero_sorteo +  " " +  color_sorteo + " " + pares_sorteo);

        //// falta dar premios
        if(numero!=0 && numero_sorteo==numero && color_sorteo.equals(color) && pares_sorteo.equals(par)){
            System.out.println("HAS GANADO!!");
        } else if (numero!=0 && color_sorteo.equals(color)) {
            System.out.println("Has acertado el color.");
        } else if (numero!=0 && pares_sorteo.equals(par)) {
            System.out.println("Has acertado la opción par/impar");
        } else if (numero==numero_sorteo && numero != 0) {
            System.out.println("Has acertado el número");
        } else if (numero==0 && numero_sorteo==0) {
            System.out.println("HAS GANADO y los demás usuarios pierden.");
        }else{
            System.out.println("Has perdido.");
        }


    }

    public void ordenar(){

        int numeros[] = {4,3,10,34,21};
        System.out.println(Arrays.toString(numeros));

        Arrays.sort(numeros);
        System.out.println(Arrays.toString(numeros));

        int num = -34;

        int posicion = Arrays.binarySearch(numeros,num);

        System.out.println(posicion);


    }

    public void duplicados1(){

        int original[] = {3,3,5,10,16,25,25};

        System.out.println(Arrays.toString(original));

        int auxiliar[] =  new int[original.length];

        int limpio[];

        for (int i = 0; i < original.length; i++) {
            //original[i] vs original [i+1]
            if (i!=original.length-1 && original[i]==original[i+1]){
                System.out.println("Duplicado: " + original[i]);
            }else{
                auxiliar[i] = original[i];
            }

        }

        System.out.println(Arrays.toString(auxiliar));


        //FALTA VECTOR LIMPIO

    }

}
