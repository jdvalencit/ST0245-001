package me.DavidLake.Entrega1;

import java.util.ArrayList;

public class Gini {

    public static double getGiniImpurity(int vData, double vCondition){

        int countLeft = 0;
        int countRight = 0;
        int countPositiveLeft = 0;
        int countPositiveRight = 0;
        int countNegativeLeft = 0;
        int countNegativeRight = 0;

        ArrayList<String> vArrayList = Statistics.getUnsortedValues(vData);

        for(int i = 0; i < Data.getDataList().size(); i++){

            String vTemp = Data.convertStringToNumberString(vArrayList.get(i));

            if(vTemp.equals("")){

                continue;
            }

            if(Double.parseDouble(vTemp) <= vCondition){

                countLeft++;

                if(Statistics.getUnsortedValues(77).get(i).equals("1")) countPositiveLeft++;
                else countNegativeLeft++;
            } else{

                countRight++;

                if(Statistics.getUnsortedValues(77).get(i).equals("1")) countPositiveRight++;
                else countNegativeRight++;
            }
        }

        //double p0 = (double)countLeft/Data.getDataList().size();
        //double p1 = (double)countRight/Data.getDataList().size();

        double valorLeft = 1 - (Math.pow((double)countPositiveLeft/countLeft,2) + Math.pow((double)countNegativeLeft/countLeft,2));
        double valorRight = 1 - (Math.pow((double)countPositiveRight/countRight,2) + Math.pow((double)countNegativeRight/countRight,2));

        //return 1 - (Math.pow(p0, 2) + Math.pow(p1, 2));
        return balancedGini(countLeft, countRight, valorLeft, valorRight);
    }

    public static double balancedGini(int leftTotal, int rightTotal, double valorLeft, double valorRight){
        return ((leftTotal*valorLeft) + (rightTotal*valorRight)) / (leftTotal + rightTotal );
    }

    public static double getCondition(int vEstadistica){

        ArrayList<Double> vPosiblesCondiciones = new ArrayList<>();
        ArrayList<String> vEstadisticas = Statistics.getUnsortedValues(vEstadistica);
        int vSize = vEstadisticas.size();

        for (String vValor : vEstadisticas) {

            if (!vPosiblesCondiciones.contains(Double.parseDouble(Data.convertStringToNumberString(vValor)))) {

                vPosiblesCondiciones.add(Double.parseDouble(Data.convertStringToNumberString(vValor)));
            }
        }

        double vLowerGini = 1;
        double vCondicionFinal = -1;
        int vSize2 = vPosiblesCondiciones.size();

        for (double vCondicion : vPosiblesCondiciones) {

            double vGini = Gini.getGiniImpurity(vEstadistica, vCondicion);
        //  System.out.println(vCondicion + ": " + vGini);

            if (vGini < vLowerGini) {

                vLowerGini = vGini;
                vCondicionFinal = vCondicion;
            }
        }

        return vCondicionFinal;
    }

    public static void printGini(){

        int[] vArray = new int[]{13,45,65,66,67,68,69,70,71,72,73};

        for (int j : vArray) {

            try {
                System.out.println(Data.vConditions.get(j) + ": " + Gini.getGiniImpurity(j, Gini.getCondition(j)));
            } catch (NumberFormatException e) {

                System.out.println(Data.vConditions.get(j) + " dio error.");
            }
        }
    }

    static ContenidoNodo giniMenor(Condicion[] variables){
        ContenidoNodo valorRetorno =  new ContenidoNodo(" ","",-1);
        for(Condicion var:variables){
            for(ContenidoNodo val: var.getValores()){
                if(valorRetorno.getIndiceGini()>val.getIndiceGini()){
                    valorRetorno = val;
                }
            }
        }

        return valorRetorno;
    }

    static void calcularGini(Condicion[] variables){

        for(Condicion var: variables){

            for(ContenidoNodo val : var.getValores()){

                val.calcularIndiceGini();
        }
    }
}
}
