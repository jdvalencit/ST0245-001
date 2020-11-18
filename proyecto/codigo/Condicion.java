package me.DavidLake.Entrega1;

import java.util.TreeSet;

public class Condicion{

    int vIndex;
    private final String vCondicion;
    private final TreeSet<String> vCondiciones = new TreeSet<>();
    private ContenidoNodo[] vChildren;

    public Condicion(String argCondicion, int argIndex){

        this.vCondicion = argCondicion;
        this.vIndex =  argIndex;
    }

    public void agregarValor(String nombreValor){
        vCondiciones.add(nombreValor);
    }

    public ContenidoNodo[] getValores(){
        return vChildren;
    }
    public String getNombreVariable(){
        return vCondicion;
    }

    public void fill(){

        vChildren = new ContenidoNodo[this.vCondiciones.size()];
        int i = 0;

        for(String vTemp : vCondiciones){
            vChildren[i] = new ContenidoNodo(vTemp, vCondicion,vIndex);
            i++;
        }
    }

    public void eliminarValores(){
        vCondiciones.clear();
    }

}