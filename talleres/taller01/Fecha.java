public class Fecha {

    private final byte dia;
    private final byte mes;
    private final short anyo;

    public Fecha(short anyo, byte mes, byte dia){

        this.anyo = anyo;
        this.mes = mes;
        this.dia = dia;
    }

    public int getDia(){

        return this.dia;
    }

    public int getMes(){

        return this.mes;
    }

    public int getAnyo(){

        return this.anyo;
    }

    public String toString(){

        return Integer.toString(this.getAnyo()) + String.format("%02d", this.getMes()) + String.format("%02d", this.getDia());
    }

    public int comparar(Fecha otraFecha){
            Long fecha1 = Long.parseLong(this.toString());
            long fecha2 = Long.parseLong(otraFecha.toString());

            if(fecha1 > fecha2){

                return 1;

            }else if(fecha1 < fecha2){

                return -1;

            }else {

                return 0;

            }

    }
}