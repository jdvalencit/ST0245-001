package me.DavidLake.Entrega1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    public static ArrayList<String> getValues(String vLabel){

        ArrayList<String> vArrayList = new ArrayList<>();
        int vIndex = Data.vConditions.indexOf(vLabel);

        for(int i = 0; i < Data.getDataList().size(); i++){

            vArrayList.add(Data.getDataList().get(i)[vIndex]);
        }

        sortValues(vArrayList);

        return vArrayList;
    }

    public static ArrayList<String> getUnsortedValues(String vLabel){

        ArrayList<String> vArrayList = new ArrayList<>();
        int vIndex = Data.vConditions.indexOf(vLabel);

        for(int i = 0; i < Data.getDataList().size(); i++){

            vArrayList.add(Data.getDataList().get(i)[vIndex]);
        }

        return vArrayList;
    }

    public static ArrayList<String> getValues(int vIndex){

        ArrayList<String> vArrayList = new ArrayList<>();

        for(int i = 0; i < Data.getDataList().size(); i++){

            vArrayList.add(Data.getDataList().get(i)[vIndex]);
        }

        sortValues(vArrayList);

        return vArrayList;
    }

    public static ArrayList<String> getUnsortedValues(int vIndex){

        ArrayList<String> vArrayList = new ArrayList<>();

        for(int i = 0; i < Data.getDataList().size(); i++){

            vArrayList.add(Data.getDataList().get(i)[vIndex]);
        }

        return vArrayList;
    }

    private static void sortValues(ArrayList<String> vArrayList){

        Collections.sort(vArrayList);
    }

    public static void printAppears(ArrayList<String> vArray){

        String vCurrentString = "";

        for (int i = 0; i < vArray.size(); i++) {

            String vTemp = vArray.get(i);
            if(!vTemp.equals(vCurrentString)){

                System.out.println(vTemp + ": " + Collections.frequency(vArray, vTemp));
                vCurrentString = vTemp;
            }
        }
    }

    public static void printArrayAppears(int[] vArray){

        for (int j : vArray) {

            System.out.println(Statistics.getValues(j));
            Statistics.printAppears(Statistics.getValues(j));
            System.out.println();
        }
    }

    public static int getAverageStratum(){

        int total = 0;
        ArrayList<String> vArrayList = Statistics.getValues("fami_estratovivienda.1");

        for(int i = 0; i < vArrayList.size(); i++){

            String vCurrent = vArrayList.get(i);

            try{

                total += Integer.parseInt(String.valueOf(vCurrent.charAt(vCurrent.length() - 1)));
            } catch (NumberFormatException e){

                System.out.println(e.getMessage());
            }
        }

        return total / vArrayList.size();
    }

    public static double giniImpurity(){

        int vSuccesful = 0;
        int vNonSuccesful = 0;
        int vNonAnswer = 0;

        ArrayList<String> vArrayList = Statistics.getValues(77);

        for(int i = 0; i < vArrayList.size(); i++){

            String vCurrent = vArrayList.get(i);

            switch (vCurrent){

                case "1" -> vSuccesful++;
                case "0" -> vNonSuccesful++;
                case "" -> vNonAnswer++;
            }
        }

        return 0;
    }

    public static double getMediaAritmetica(ArrayList<String> vArray){

        double vTotal = 0;

        for(String s : vArray){

            if(!Data.convertStringToNumberString(s).equals("")){

                vTotal += Double.parseDouble(Data.convertStringToNumberString(s));
            }
        }

        return vTotal / vArray.size();
    }
}
