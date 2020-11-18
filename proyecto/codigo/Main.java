package me.DavidLake.Entrega1;

public class Main {

    public static void main(String[] args) {

        Data.readData();
        Test.makeTest("Test.csv", "Train.csv");

        /*
        System.out.println(Entropia.getEntropias(3)); //0.86
        System.out.println(Entropia.getEntropias(13)); //0.85
        System.out.println(Entropia.getEntropias(27)); //0.75
        System.out.println(Entropia.getEntropias(34)); //0.82
        System.out.println(Entropia.getEntropias(35)); //0.93
        System.out.println(Entropia.getEntropias(36)); //0.90
        System.out.println(Entropia.getEntropias(44)); //0.55
        System.out.println(Entropia.getEntropias(53)); //0.82
        System.out.println(Entropia.getEntropias(54)); //0.64
         */
    }
}