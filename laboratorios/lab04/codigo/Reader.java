package me.DavidLake.Laboratorio4ED1Exp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {

    LinkedList<Double> vLatitudes = new LinkedList<>();
    LinkedList<Double> vLongitudes = new LinkedList<>();
    LinkedList<Double> vAlturas = new LinkedList<>();
    LinkedList<Bee> vAbejas = new LinkedList<>();

    private static final String vPath = "archivo.txt";

    public void readFile(String vPath) throws Exception {

        try (BufferedReader vBufferedReader = new BufferedReader(new FileReader(vPath))){

            vBufferedReader.readLine();
            String vLine;
            while ((vLine = vBufferedReader.readLine()) != null){

                workLine(vLine);
            }
        } catch (IOException e){

            e.printStackTrace();
        }

        getMaxMin();
    }

    private void workLine(String vLine){

        String[] vArray = vLine.split(",");
        double vLatitud = Double.parseDouble(vArray[0]);
        double vLongitud = Double.parseDouble(vArray[1]);
        double vAltura = Double.parseDouble(vArray[2]);

        vLatitudes.addFirst(vLatitud);
        vLongitudes.addFirst(vLongitud);
        vAlturas.addFirst(vAltura);

        Bee vBee = new Bee(vLatitud, vLongitud, vAltura);
        vAbejas.addFirst(vBee);
    }

    public HashMap<String, Double> getLimitValues(){

        HashMap<String, Double> vResult = new HashMap<>();
        double minlat = (double) Collections.min(vLatitudes);
        vResult.put("minlat", minlat);
        double maxlat = (double)Collections.max(vLatitudes);
        vResult.put("maxlat", maxlat);
        double minlon = (double)Collections.min(vLongitudes);
        vResult.put("minlon", minlon);
        double maxlon = (double)Collections.max(vLongitudes);
        vResult.put("maxlon", maxlon);
        double minalt = (double)Collections.min(vAlturas);
        vResult.put("minalt", minalt);
        double maxalt = (double)Collections.max(vAlturas);
        vResult.put("maxalt", maxalt);

        double midD = (minlat-maxlat)/2;
        double midW = (maxlon-minlon)/2;
        double midH = (maxalt-minalt)/2;

        vResult.put("midD", midD);
        vResult.put("midW", midW);
        vResult.put("midH" ,midH);

        return vResult;
    }

    public void getMaxMin() throws Exception{

        double minlat=(double)Collections.min(vLatitudes);
        double maxlat=(double)Collections.max(vLatitudes);

        double minlon=(double)Collections.min(vLongitudes);
        double maxlon=(double)Collections.max(vLongitudes);

        double minalt=(double)Collections.min(vAlturas);
        double maxalt=(double)Collections.max(vAlturas);

        double [] mins = new double[3];
        double [] maxs = new double[3];

        mins[0] = minlat;
        mins[1] = minlon;
        mins[2] = minalt;
        maxs[0] = maxlat;
        maxs[1] = maxlon;
        maxs[2] = maxalt;

        double midlat=maxlat-minlat;
        double midlon=maxlon-minlon;
        double midalt=maxalt-minalt;
        double [] mids = new double[3];

        mids[0] = midlat;
        mids[1] = midlon;
        mids[2] = midalt;

        double diagonal = Math.sqrt(Math.pow(mids[0]*111320,2)+Math.pow(mids[1]*111320,2)+Math.pow(mids[2],2));

        if (diagonal > 100) {
            Octree vOctree = new Octree();
            vOctree.octree(vAbejas,mins,mids,maxs);
        } else {
            choque();
        }
    }

    public void choque() {

        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse: ");

        for (Bee vBee : vAbejas) {
            System.out.println(vBee.getPosition());
        }
    }

    public ArrayList<Double> getMinsValues(){

        ArrayList<Double> vResult = new ArrayList<>();
        double minlat = (double) Collections.min(vLatitudes);
        double minlon = (double)Collections.min(vLongitudes);
        double maxalt = (double)Collections.max(vAlturas);

        vResult.add(minlat);
        vResult.add(minlon);
        vResult.add(maxalt);

        return vResult;
    }
}
