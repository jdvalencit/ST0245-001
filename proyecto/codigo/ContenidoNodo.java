package me.DavidLake.Entrega1;

public class ContenidoNodo{

    private final String preContenido;
    private final String labelContenido;
    private final int index;
    private int vY1amount;
    private int vY0amount;
    private int vN1amount;
    private int vN0amount;
    private float indiceGini;

    public ContenidoNodo(String labelContenido, String preContenido,int index){

        this.labelContenido = labelContenido;
        this.preContenido = preContenido;
        this.index = index;
        this.indiceGini = Float.MAX_VALUE;
        this.vY1amount = 0;
        this.vY0amount = 0;
        this.vN1amount = 0;
        this.vN0amount = 0;
    }

    public String getlabelContenido(){
        return this.labelContenido;
    }

    public String getpreContenido() {
        return preContenido;
    }

    public int getIndex(){
        return this.index;
    }

    public float getIndiceGini(){
        return this.indiceGini;
    }

    public void calcularIndiceGini(){

        float totalSi = vY0amount + vY1amount;
        float totalNo = vN0amount + vN1amount;

        if(totalSi==0 || totalNo==0){
            this.indiceGini=0;
            return;
        }

        float vFloatY0, vFloatY1, vFloatN0, vFloatN1, vGiniVarY, vGiniVarN, vGiniPonderado;

        vFloatY0 = vY0amount / totalSi;
        vFloatN0 = vN0amount / totalNo;
        vFloatY1 = vY1amount / totalSi;
        vFloatN1 = vN1amount / totalNo;

        vGiniVarY = 1 - ((vFloatY0 * vFloatY0)+(vFloatY1*vFloatY1));
        vGiniVarN = 1 - ((vFloatN0*vFloatN0)+(vFloatN1*vFloatN1));
        vGiniPonderado = ((totalNo*vGiniVarN) + (totalSi*vGiniVarY)) / (totalNo+totalSi) ;
        this.indiceGini = vGiniPonderado;
    }

    public void amountY1(){
        vY1amount++;
    }
    public void masNodoSi_cant0(){
        vY0amount++;
    }
    public void amountN1(){
        vN1amount++;
    }
    public void amountN0(){
        vN0amount++;
    }
}