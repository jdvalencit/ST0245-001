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

        ArrayList<String> vArrayList = Statistics.getUnsortedValues((int) vData);

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

                if(Statistics.getUnsortedValues(77).get(i).equals("0")) countPositiveRight++;
                else countNegativeRight++;
            }
        }

        //double p0 = (double)countLeft/Data.getDataList().size();
        //double p1 = (double)countRight/Data.getDataList().size();

        double valorLeft = 1 - (Math.pow((double)countPositiveLeft/countLeft,2) + Math.pow((double)countNegativeLeft/countLeft,2));
        double valorRight = 1 - (Math.pow((double)countPositiveRight/countRight,2) + Math.pow((double)countNegativeRight/countRight,2));

        //(return 1 - (Math.pow(p0, 2) + Math.pow(p1, 2));
        return balancedGini(countLeft, countRight, valorLeft, valorRight);
    }

    private static double balancedGini(int leftTotal, int rightTotal, double valorLeft, double valorRight){
        return ((leftTotal*valorLeft) + (rightTotal*valorRight)) / (leftTotal + rightTotal );
    }
}
