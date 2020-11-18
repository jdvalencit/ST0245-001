package me.DavidLake.Entrega1;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void makeTest(String vTestPath, String vTrainPath){

        long vTrainTime = System.currentTimeMillis();
        Tree vTree = Tree.getRoot(vTrainPath);
        long vFinalTrainTime = System.currentTimeMillis() - vTrainTime;
        long vTestTime = System.currentTimeMillis();
        float[] vAciertos = TestData(vTestPath, vTree);
        long vFinalTestTime = System.currentTimeMillis() - vTestTime;

        System.out.println("Total memory usage: ");
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        System.out.println("MB: " + (double) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024)/1024);
        System.out.println("Training Time: " + vFinalTrainTime);
        System.out.println("Testing Time: " + vFinalTestTime);
        System.out.println(Arrays.toString(TestData(vTestPath, vTree)));
        System.out.println("Proceso finalizado sin errores.");
    }

    private static float[] TestData(String direccion, Tree arbol){

        ArrayList<String[]> vDataLista = DataAux.cargar(direccion);
        float[] vPrecisiones =  new float[2];
        int vTrue = 0;
        int vFalse = 0;

        for(String [] vTemp : vDataLista){
            String vRecorrido = DataAux.dfsTree(vTemp, arbol.root);
            if(vRecorrido.equals(vTemp[30])) vTrue++;
            else vFalse++;
        }

        vPrecisiones[0] = (vTrue * 100) / (float)vDataLista.size();
        vPrecisiones[1] = (vFalse * 100) / (float)vDataLista.size();
        return vPrecisiones;
    }
}