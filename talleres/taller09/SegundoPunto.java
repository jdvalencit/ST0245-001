package me.DavidLake.Taller9ED1;

import java.util.HashMap;

public class SegundoPunto {

    public static void main(String[] args) {

        //Punto 2:

        HashMap<String, String> vCRMList = new HashMap<>();
        vCRMList.put("Google", "Estados Unidos");
        vCRMList.put("La locura", "Colombia");
        vCRMList.put("Nokia", "Finlandia");
        vCRMList.put("Sony", "Japon");

        //Punto 3:

        System.out.println(vCRMList.get("Google"));
        System.out.println(vCRMList.get("Motorola"));

        //Punto 4:

        System.out.println(vCRMList.containsValue("India"));
        System.out.println(vCRMList.containsValue("Estados Unidos"));
    }
}
