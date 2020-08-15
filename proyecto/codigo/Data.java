package me.JuanDavidVT;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private static final List<String[]> vDataList = new ArrayList<>();
    private static final String vPathName = "lite.csv";

    public static void readData(){

        File vDataFile = new File(vPathName);

        try {

            FileReader vFileReader = new FileReader(vDataFile);
            BufferedReader vBufferedReader = new BufferedReader(vFileReader); //Puede causar excepciones al leer ciertos archivos sin UNICODE-8
            String vLine;

            while ((vLine = vBufferedReader.readLine())!=null) {

                Data.addToList(Data.vDataList, vLine.split(";"));
            }

        } catch (IOException vException) {

            System.out.println(vException.getMessage());
        }
    }

    public static void addToList(List<String[]> vFinalList, String[] vData){

        vFinalList.add(vData);
    }

    public static List<String[]> getDataList(){

        return Data.vDataList;
    }
}