package me.JuanDavidVT;

import java.util.ArrayList;

public class Taller3 {

    private static int cont = 1;

    public static void torresDeHannoi(int diskAmount){

        torresDeHannoi(diskAmount,"T1", "T2", "T3");
    }

    public static void torresDeHannoi(int diskNumber, String t1, String t2, String t3){

        if (diskNumber == 1){

            System.out.println("Paso "+cont+++": Disco "+diskNumber+" de "+t1+" -> "+t3);
        } else{

            torresDeHannoi(diskNumber-1, t1, t3, t2);
            System.out.println("Paso "+cont+++": Disco "+diskNumber+" de "+t1+" -> "+t3);
            torresDeHannoi(diskNumber-1, t2, t1, t3);
        }
    }

    public static void getPermutations(String str){

        getPermutations("", str);
    }

    public static ArrayList<String> permutations = new ArrayList<>();

    public static void getPermutations(String prefix, String s){

        int len = s.length();

        if (len == 0){

            permutations.add(prefix);
        }else {

            for (int i = 0; i < len; i++){

                getPermutations(prefix+s.charAt(i), s.substring(0, i) + s.substring(i+1));
            }
        }
    }

    public static void permutationExtra(){

        for (int i = 0; i < Taller3.permutations.size();i++){

            String temp = AdvancedEncryptionStandard.desencriptarArchivo(Taller3.permutations.get(i));
            if (!temp.equals("")){

                System.out.println(temp);
                break;
            }
        }
    }
}