package me.JuanDavidVT;

public class Main {

    public static void main(String[] args) {

        Data.readData();
        System.out.println("Líneas leídas: "+Data.getDataList().size());
    }
}