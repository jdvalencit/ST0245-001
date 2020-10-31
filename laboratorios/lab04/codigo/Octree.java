package me.DavidLake.Laboratorio4ED1Exp;

import java.util.HashMap;
import java.util.LinkedList;

public class Octree {

    private static final byte topLeftFront = 0;
    private static final byte topRightFront = 1;
    private static final byte bottomRightFront = 2;
    private static final byte bottomLeftFront = 3;
    private static final byte topLeftBack = 4;
    private static final byte topRightBack = 5;
    private static final byte bottomRightBack = 6;
    private static final byte bottomLeftBack = 7;

    private double minX, maxX;
    private double minY, maxY;
    private double minZ, maxZ;

    private double midX, midY, midZ;

    public void octree(LinkedList<Bee> vBees, double[] vMinimos, double[] vMaximos, double[] vPromedios) throws Exception{

        LinkedList<Bee>[] vOctree = new LinkedList[8];

        for(int i = 0; i < vOctree.length; i++){

            LinkedList<Bee> vTempBees = new LinkedList<>();
            vOctree[i] = vTempBees;
        }

        for(Bee vBee : vBees){

            LinkedList<Bee> vTempBees = vOctree[funcionHashTest(vBee, vMinimos, vPromedios)];
            vTempBees.addFirst(vBee);
        }

        double vDiagonal = Math.sqrt(Math.pow(vPromedios[0] * 111320 ,2) + Math.pow(vPromedios[1] * 111320, 2) + Math.pow(vPromedios[2],2));

        if(vDiagonal > 100){

            for(LinkedList<Bee> vList : vOctree){

                if(vList.size() >= 2){

                    nuevoOctree(vList,vMinimos,vMaximos,vPromedios);
                }
            }
        } else{

            for (LinkedList<Bee> vTempBees : vOctree) {

                if (vTempBees.size() > 1) {

                    mostrarColisiones(vTempBees);
                }
            }
        }
    }

    public void nuevoOctree(LinkedList<Bee> vBees, double[] vMinimos, double[] vMaximos, double[] vPromedios) throws Exception{

        double min0 = vBees.get(0).getLatitud();
        double min1 = vBees.get(0).getAltura();
        double min2 = vBees.get(0).getLongitud();
        double max0 = vBees.get(0).getLatitud();
        double max1 = vBees.get(0).getAltura();
        double max2 = vBees.get(0).getLongitud();

        for(Bee vBee : vBees){

            min0 = Math.min(min0, vBee.getLatitud());
            min1 = Math.min(min1, vBee.getAltura());
            min2 = Math.min(min2, vBee.getLongitud());
            max0 = Math.max(max0, vBee.getLatitud());
            max1 = Math.max(max1, vBee.getAltura());
            max2 = Math.max(max2, vBee.getLongitud());
        }

        double mid0 = max0-min0;
        double mid1 = max1-min1;
        double mid2 = max2-min2;

        vMinimos[0] = min0;
        vMinimos[1] = min1;
        vMinimos[2] = min2;
        vMaximos[0] = max0;
        vMaximos[1] = max1;
        vMaximos[2] = max2;
        vPromedios[0] = mid0/2;
        vPromedios[1] = mid1/2;
        vPromedios[2] = mid2/2;
        octree(vBees, vMinimos, vMaximos, vPromedios);
    }

    private int funcionHash(Bee vBee, double[] vMinimos){

        // X es 0
        // Y es 1
        // Z es 2

        double valorX = vBee.getDistanciaX();
        double valorY = vBee.getAltura();
        double valorZ = vBee.getDistanciaZ();

        if(valorZ < vMinimos[2] + midZ){

            return checkHashing(vMinimos, valorX, valorY, bottomLeftFront, bottomRightFront, topLeftFront, topRightFront);
        }

        return checkHashing(vMinimos, valorX, valorY, bottomLeftBack, bottomRightBack, topLeftBack, topRightBack);
    }

    private int funcionHashTest(Bee vBee, double[] vMinimos, double[] vPromedios){

        int vResult = 0;

        if(vBee.getLatitud()<=(vMinimos[0] + vPromedios[0]/2) && vBee.getAltura()<=(vMinimos[1] + vPromedios[1]/2) && vBee.getLongitud()<=(vMinimos[2]+vPromedios[2]/2)){
            vResult = 0;
        }
        if(vBee.getLatitud() <= (vMinimos[0] + vPromedios[0]/2) && vBee.getAltura()<=(vMinimos[1] + vPromedios[1]/2) && vBee.getLongitud()>(vMinimos[2]+vPromedios[2]/2)){
            vResult = 1;
        }
        if(vBee.getLatitud() <= (vMinimos[0] + vPromedios[0]/2) && vBee.getAltura()>(vMinimos[1] + vPromedios[1]/2) && vBee.getLongitud()<=(vMinimos[2]+vPromedios[2]/2)){
            vResult = 2;
        }
        if(vBee.getLatitud() <= (vMinimos[0] + vPromedios[0]/2) && vBee.getAltura()>(vMinimos[1] + vPromedios[1]/2) && vBee.getLongitud()>(vMinimos[2]+vPromedios[2]/2)){
            vResult = 3;
        }
        if(vBee.getLatitud() > (vMinimos[0] + vPromedios[0]/2) && vBee.getAltura()<=(vMinimos[1] + vPromedios[1]/2) && vBee.getLongitud()<=(vMinimos[2]+vPromedios[2]/2)){
            vResult = 4;
        }
        if(vBee.getLatitud() > (vMinimos[0] + vPromedios[0]/2) && vBee.getAltura()<=(vMinimos[1] + vPromedios[1]/2) && vBee.getLongitud()>(vMinimos[2]+vPromedios[2]/2)){
            vResult = 5;
        }
        if(vBee.getLatitud() > (vMinimos[0] + vPromedios[0]/2) && vBee.getAltura()>(vMinimos[1] + vPromedios[1]/2) && vBee.getLongitud()<=(vMinimos[2]+vPromedios[2]/2)){
            vResult = 6;
        }
        if(vBee.getLatitud() > (vMinimos[0] + vPromedios[0]/2) && vBee.getAltura()>(vMinimos[1] + vPromedios[1]/2) && vBee.getLongitud()>(vMinimos[2]+vPromedios[2]/2)){
            vResult = 7;
        }
        return vResult;
    }

    private int checkHashing(double[] vMinimos, double valorX, double valorY, byte bottomLeftFront, byte bottomRightFront, byte topLeftFront, byte topRightFront) {

        if(valorY < vMinimos[1] + midY){

            if(valorX < vMinimos[0] + midX){

                return bottomLeftFront;
            }

            return bottomRightFront;
        }

        if(valorX < vMinimos[0] + midX){

            return topLeftFront;
        }

        return topRightFront;
    }

    public void mostrarColisiones(LinkedList<Bee> vBees) {

        System.out.println("Las abejas en las siguientes coordenadas podrían chocar: ");

        for (Bee vBee : vBees) {

            System.out.println(vBee.getPosition());
        }
    }
}
