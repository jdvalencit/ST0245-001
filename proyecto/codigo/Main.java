package me.DavidLake.Entrega1;

public class Main {

    public static void main(String[] args) {

        Data.readData();

        int[] vArray = new int[]{13,45,65,66,67,68,69,70,71,72,73};

        for(int i = 0; i < vArray.length; i++){

            try{
                System.out.println(Data.vConditions.get(vArray[i]) + ": " + Gini.getGiniImpurity(vArray[i], Statistics.getMediaAritmetica(Statistics.getUnsortedValues(vArray[i]))));
            } catch (NumberFormatException e){

                System.out.println(Data.vConditions.get(i) + " dio error.");
            }
        }
    }
}