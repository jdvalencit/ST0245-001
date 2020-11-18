package me.DavidLake.Entrega1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Entropia {

    public static double getEntropia(int vCondition, String vString) {

        ArrayList<String> vValores = Statistics.getUnsortedValues(vCondition);
        ArrayList<String> vResultados = Statistics.getUnsortedValues(77);
        HashMap<String, Integer> vPositiveMap = new HashMap<>();
        HashMap<String, Integer> vNegativeMap = new HashMap<>();
        int vSize = vValores.size();
        double vRealSize = 0;

        for (int i = 0; i < vSize; i++) {

            String vValor = vValores.get(i);
            String vResultado = vResultados.get(i);

            if (vValor.equals("")) continue;

            if(vValor.equals(vString)) vRealSize++;

            if (vResultado.equals("1")) {

                if (vPositiveMap.containsKey(vValor)) vPositiveMap.put(vValor, vPositiveMap.get(vValor) + 1);
                else vPositiveMap.put(vValor, 1);
            } else {

                if (vNegativeMap.containsKey(vValor)) vNegativeMap.put(vValor, vNegativeMap.get(vValor) + 1);
                else vNegativeMap.put(vValor, 1);
            }
        }

        //ArrayList<String> vOpciones = getOpciones(vCondition);

        double vPyvPositivo = vPositiveMap.get(vString) / vRealSize;
        double vLog2PPositivo = Math.abs(log2p(vPyvPositivo));

        double vPyvNegativo = vNegativeMap.get(vString) / vRealSize;
        double vLog2PNegativo = Math.abs(log2p(vPyvNegativo));

        return (vLog2PPositivo * vPyvPositivo) + (vPyvNegativo * vLog2PNegativo);
    }

    public static HashMap<String,Double> getEntropias(int vCondition){

        ArrayList<String> vOpciones = getOpciones(vCondition);
        HashMap<String, Double> vResult = new HashMap<>();

        for (String vOpcione : vOpciones) {

            vResult.put(vOpcione, getEntropia(vCondition, vOpcione));
        }

        return vResult;
    }

    private static ArrayList<String> getOpciones(int vCondition){

        ArrayList<String> vOpciones = new ArrayList<>();
        ArrayList<String> vValores = Statistics.getUnsortedValues(vCondition);
        int vSize = vValores.size();

        for (String vValor : vValores) {

            if (vValor.equals("")) continue;

            if (!vOpciones.contains(vValor)) vOpciones.add(vValor);
        }

        return vOpciones;
    }

    public static double log2p(double vValor){

        return Math.log(vValor) / Math.log(2);
    }
}
