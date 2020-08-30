package me.JuanDavidVT;

public class Taller5 {

    /**
     * @param array es una arreglo de numeros enteros.
     * El método suma tiene la intención de hacer el proceso de suma
     * mediante una funcion cíclica (while/for/...)
     * @return
     */
    public static int suma (int[]array){

        int resultado = 0;

        for(int i = 0; i < array.length; i++){

            resultado += array[i];
        }

        return resultado;
    }


    /**
     * @param num es el numero el cual se utiliza para ser multiplicado.
     * El método mul tiene la intención de hacer la multiplicación
     * de 1 a n por el numero mul
     * mediante una funcion cíclica (while/for/...)
     *
     */
    public static void mul (int num){

        String base = "Tablas de multiplicar de el número ";

        for(int i = 1; i <= num; i++){

            System.out.println(base + i);

            for(int a = 1; a <= 9; a++){

                System.out.println((String.valueOf(i) + " * " + String.valueOf(a) + ": " + i * a));
            }
        }
    }


    /**
     * @param array es un arreglo de números desordenados
     * El método insertionSort tiene la intención ordenar los números
     * del arreglo array por el método insertion:
     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
     * mediante la anidación de funciones cíclicas (while/for/...)
     *
     */
    public static int[] insertionSort (int[] array) {

        int length = array.length;

        for(int i = 1; i < length; ++i){

            int tempB = array[i];
            int temp = i - 1;

            while(temp >= 0 && array[temp] > tempB){

                array[temp + 1] = array[temp];
                temp -= 1;
            }

            array[temp + 1] = tempB;
        }

        return array;
    }
}