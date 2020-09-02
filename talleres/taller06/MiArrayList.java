package me.JuanDavidVT;

import java.util.Arrays;

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elements;

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {

        this.size = 0;
        this.elements = new int[DEFAULT_CAPACITY];
    }


    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {

        return size;
    }

    /**
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {

        elements = Arrays.copyOf(elements, elements.length + 1);
        elements[elements.length - 1] = e;
        size++;
    }


    /**
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i){

        if(elements.length == 0 | i >= elements.length | i < 0) {

            throw new IndexOutOfBoundsException(){};
        }

        return elements[i];
    }


    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {

        if(index < 0 | index > size) {

            throw new IndexOutOfBoundsException(){};
        }

        int[] tempArray = new int[elements.length + 1];

        for(int i = 0, a = 0; i < elements.length + 1; i++){

            if(i == index){

                tempArray[i] = e;
            }

            tempArray[a++] = elements[i];
        }

        elements = tempArray;
        size++;
    }

    /**
     * @param index es la posicion en la cual se va eliminar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){

        if(elements.length == 0 | index >= elements.length | index < 0) {

            throw new IndexOutOfBoundsException(){};
        }

        int[] tempArray = new int[elements.length - 1];

        for(int i = 0, a = 0; i < elements.length; i++){

            if(i == index){

                continue;
            }

            tempArray[a++] = tempArray[i];
        }

        elements = tempArray;
        size--;
    }
}