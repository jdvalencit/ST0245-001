package me.JuanDavidVT;

import java.util.ArrayList;
import java.util.Scanner;

public class Taller6 {

    /**
     * Se puede leer los elementos por consola con la ayuda de la clase index.
     * luego solo se agregan a un objeto arraylist y se imprime.
     * el arreglo tiene que estar de forma inversa
     * ejemplo, para las entras 1 , 2 , 6, -1
     * el arreglo tendría este orden [ 6, 2, 1].
     * @return un arraylist con todos los elementos ingresados de forma invertida
     */
    public static ArrayList<Integer> opcinal2 () {

        ArrayList<Integer> tempArray = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        while(scanner.hasNextInt()){

            i = scanner.nextInt();

            if(i == -1){

                break;
            }

            tempArray.add(0, i);
        }

        return tempArray;
    }

    /**
     * @param n el numero hasta el cual se llevara acabo el patrón siguiente
     * vamos a implementar un nuevo nuevo a la vez no antes de haber
     * contado desde el inicio ejemplo n=4 entonces el arreglo sería
     * [ 1,1,2,1,2,3,1,2,3,4] de modo que siempre que se ingresa uno nuevo
     * comienza la cuenta desde 1.
     * @return un arraylist con todos los elementos ingresados
     */
    public static ArrayList<Integer> opcinal3 (int n){

        ArrayList<Integer> tempArray = new ArrayList<>();

        for(int i = 1; i <= n; i++){

            for(int a = 1; a <= i; a++){

                tempArray.add(a);
            }
        }

        return tempArray;
    }
}