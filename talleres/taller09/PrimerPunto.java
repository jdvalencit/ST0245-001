package me.DavidLake.Taller9ED1;

public class PrimerPunto {

    MyHashMap vHashMap = new MyHashMap();

    public static void main(String[] args) {

        MyHashMap vHash = new MyHashMap();
        vHash.put("David", 3051111111L);
        System.out.println(vHash.get("David"));
        System.out.println(vHash.search("Batman"));
    }

    private int getElement(String vKey){

        return 0;
    }
}
