public class Punto {

    private double posX, posY;

    public Punto(double posX, double posY){

        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX(){

        return this.posX;    }

    public double getPosY(){

        return this.posY;
    }

    public double getRadioPolar(){

        return Math.hypot(posX, posY);
    }

    public double getAnguloPolar(){

        return Math.atan2(posY, posX);
    }

    public double getDistanciaEuclidiana(Punto puntoComparacion){

        double diferenciaX = posX - puntoComparacion.getPosX();
        double diferenciaY = posY - puntoComparacion.getPosY();

        return Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
    }
}