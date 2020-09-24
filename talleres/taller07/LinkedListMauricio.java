package me.JuanDavidVT;

import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {

    private Node first;
    private int size;

    public LinkedListMauricio() {
        size = 0;
        first = null;
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {

        if(index < 0 || index >= size){

            throw new IndexOutOfBoundsException();
        }

        Node vTempNode = first;

        for(int i = 0; i < index; i++){

            vTempNode = vTempNode.next;
        }

        return vTempNode;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {

        Node vTempNode;
        vTempNode = getNode(index);
        return vTempNode.data;
    }

    // Retorna el tamaño actual de la lista
    public int size() {

        return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index) throws IndexOutOfBoundsException{

        try{

            if(index == 0){

                Node vNewNode = new Node(data); //Crea el nodo que va a ser agregado
                vNewNode.next = first; //Cambia de posición los nodos x a x+1
                first = vNewNode; //Asigna el valor de el nodo nuevo a el "primer nodo"
                size++; //Aumenta el tamaño de la  matriz
            } else {

                Node vTemp = getNode(index - 1);
                Node vNewNode = new Node(data);
                vNewNode.next = vTemp.next;
                size++;
            }

        } catch(IndexOutOfBoundsException e){

            System.out.println(e.getMessage());
        }
    }

    // Borra el dato en la posición index
    public void remove(int index) {

        if(index == 0){

            Node vTemp = first;
            first = vTemp.next;
            size--;
            return;
        }

        if(index == size - 1) {

            Node vTemp = getNode(size - 2);
            vTemp.next = vTemp.next.next;
            size--;
            return;
        }

        try{
            Node vTemp = getNode(index - 1);
            vTemp.next = vTemp.next.next;
            size--;
        } catch(IndexOutOfBoundsException e){

            System.out.println(e.getMessage());
        }
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data) {

        boolean vFound = false;

        for(int i = 0; i < size; i++){

            if(get(i) == data){

                vFound = true;
                break;
            }
        }

        return vFound;
    }
}