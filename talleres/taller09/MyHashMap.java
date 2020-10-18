package me.DavidLake.Taller9ED1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MyHashMap {

    private final ArrayList<LinkedList<Pair>> vTabla;

    public MyHashMap(){
        vTabla = new ArrayList<>(11);
        for(int i = 0; i < 10; i++){

            vTabla.add(new LinkedList<>());
        }
    }

    public int funcionHash(String k) {
        return ((int) k.charAt(0)) % 10;
    }

    public long get(String k) {
        return vTabla.get(funcionHash(k)).stream().filter(p -> p.name.equals(k)).collect(Collectors.toList()).get(0).dato;
    }

    public void put(String k, long v){
        Pair vNueva = new Pair(k, v);
        vTabla.get(funcionHash(k)).add(vNueva);
    }

    public boolean search(String k){

        int vTemp = funcionHash(k);
        LinkedList<Pair> vTempLK = vTabla.get(vTemp);

        for (Pair pair : vTempLK) {

            if (pair.name.equals(k)) {

                return true;
            }
        }

        return false;
    }
}