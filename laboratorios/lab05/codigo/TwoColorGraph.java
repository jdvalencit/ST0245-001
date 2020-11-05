package me.DavidLake.Laboratorio4ED1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class TwoColorGraph {

    public static void main(String[] args) {

        Scanner S = new Scanner(System.in);
        int[][] vArray = new int[10][10];
        int vTestCases = S.nextByte();
        HashMap<Integer, Integer> vMap = new HashMap<>();

        for(int i = 0; i < vTestCases; i++){

            int vArcos = S.nextByte();

            for(int k = 0; k < vArcos; k++){

                int vSource = S.nextByte();
                int vDestination = S.nextByte();
                workValues(vSource, vDestination, vArray, vMap);
            }

            int vSize = vMap.size();
            System.out.println(isBipartite(vArray, vArray[0][0], vSize));
        }
    }

    private static void workValues(int source, int destination, int[][] vArray, HashMap<Integer, Integer> vMap){

        vArray[source][destination] = 1;
        vArray[destination][source] = 1;

        vMap.put(source, 1);
        vMap.put(destination, 1);
    }

    private static int getSize(int[][] vArray, HashMap<Integer, Integer> vMap){

        int resultado = 0;
        int totalRows = vArray.length;
        int totalColumns = vArray[0].length;

        for (int[] ints : vArray) {

            for (int k = 0; k < totalColumns; k++) {

                if (ints[k] == 1 && vMap.get(ints[k]) == 0) {

                    vMap.put(ints[k], 1);
                    resultado++;
                }
            }
        }

        return resultado;
    }

    private static boolean isBipartite(int[][] vArray, int vSource, int vVertices) {

     //   if(vVertices % 2 == 1) return false;

        int[] vColors = new int[vVertices];

        for (int i = 0; i < vVertices; i++) {

            vColors[i] = -1;
        }

        vColors[vSource] = 1;

        LinkedList<Integer> vQueue = new LinkedList<>();

        vQueue.add(vSource);

        while (vQueue.size() != 0) {

            int vTemp = vQueue.poll();

            if (vArray[vTemp][vTemp] == 1) return false;

            for (int k = 0; k < vVertices; k++) {

                if (vArray[vTemp][k] == 1 && vColors[k] == -1) {

                    vColors[k] = 1 - vColors[vTemp];
                    vQueue.add(k);
                } else if (vArray[vTemp][k] == 1 && vColors[k] == vColors[vTemp]) return false;
            }
        }

        return true;
    }
}
