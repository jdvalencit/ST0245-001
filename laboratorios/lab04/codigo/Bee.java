package me.DavidLake.Laboratorio4ED1Exp;

public class Bee {

    private final double latitud, longitud, altura;
    private final double distanciaX, distanciaZ;

    public Bee(double x, double y, double z){

        this.latitud = x;
        this.longitud = z;
        this.altura = y;

        this.distanciaX = this.latitud * 111320;
        this.distanciaZ = this.longitud * 111320;
    }

    public double getLatitud(){

        return this.latitud;
    }

    public double getLongitud(){

        return this.longitud;
    }

    public double getAltura(){

        return this.altura;
    }

    public double getDistanciaX(){

        return this.distanciaX;
    }

    public double getDistanciaZ(){

        return this.distanciaZ;
    }

    public double distanceTo(Bee vDestination) {
        return Math.sqrt(Math.pow(distanciaX - vDestination.getLatitud(), 2) + Math.pow(distanciaZ - vDestination.getLongitud(), 2) + Math.pow(altura - vDestination.getAltura(), 2));
    }

    public String getPosition(){
        return "(" + this.getLatitud() + "," + this.getAltura() + "," + this.getLongitud() + ")";
    }
}
