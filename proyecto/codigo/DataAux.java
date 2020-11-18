package me.DavidLake.Entrega1;

import java.io.*;
import java.util.*;

public class DataAux {

public static ArrayList<String[]> cargar(String vPath){

    //return Data.getDataList();

    ArrayList<String[]> res = new ArrayList<>();
    try {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(vPath), "utf-8"));
        String linea;
        int indiceFilas = 0;
        while ((linea = in.readLine()) != null) {
            String partesLinea[] = linea.split(";");
            if (indiceFilas != 0) {
                String columnas[] = new String[31];
                int indiceColumnas = 0;
                for (int i = 0; i < partesLinea.length; i++) {
                    if (comprobarVariable(i)) {
                        if ((i > 64 && i < 73))
                            columnas[indiceColumnas] = Data.convertirCadenaANota(partesLinea[i]);
                        else if (partesLinea[i].isEmpty())
                            columnas[indiceColumnas] = "*";
                        else
                            columnas[indiceColumnas] = partesLinea[i];
                        indiceColumnas++;
                    }
                }
                res.add(columnas);
            } else {
                res.add(partesLinea);
            }
            indiceFilas++;
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return res;
}

    public static Condicion[] asignarVariables(ArrayList<String[]> data){
    String [] partesLinea = data.remove(0);
    Condicion[] variables = new Condicion[30];
    int j = 0;
    for(int i = 0;i<partesLinea.length;i++){
        if(i!=partesLinea.length-1 && comprobarVariable(i)){
            variables [j] =  new Condicion(partesLinea[i], j);
            j++;
        }
    }
    return variables;      
}

    public static boolean comprobarVariable(int indice){
        if( (indice>3 && indice<11) ||(indice == 13) || (indice == 22) || (indice ==26) || (indice >27 && indice <33)
                || (indice ==35) || (indice ==36) || (indice ==42) || (indice ==45) || (indice == 52) || (indice ==54) || (indice ==55)
                || (indice>64 && indice<73) || (indice ==77) ){
            return true;
        }
        return false;
    }

public static boolean pasarValores(ArrayList<String[]> data, HashSet<String> valoresEvaluados, Condicion[] variables){
    int p = 0;    
    for(String [] fila: data){
        int i=0;
        String valorFinal = fila[30];
        for(String columna: fila){
            if(i != 30){
                if(!(valoresEvaluados.contains(variables[i].getNombreVariable()+columna))) {
                    variables[i].agregarValor(columna);   
                    p++;          
                }
            }                  
            i++;  
        }   
    }  
    if(p==0) return false;
    for(Condicion variable :variables){
        variable.fill();
    }
    return true;
}

public static void vTempsCount(ArrayList<String[]> data, HashSet<String> valoresEvaluados, Condicion[] variables){

    int vValue = 0;
    for(String[] vCurrentX : data){

        int vValue2 = 0;

        for(String vTemp : vCurrentX){

            if(vValue2 != 30){

                ContenidoNodo[] valores = variables[vValue2].getValores();
                String valorFinal = vCurrentX[30];

                for(ContenidoNodo valore : valores){

                    if(!(valoresEvaluados.contains(variables[vValue2].getNombreVariable() + vTemp))) {

                        if(vTemp.equals(valore.getlabelContenido())) {

                            if(valorFinal.equals("1")) {

                                valore.amountY1();
                            } else{

                                valore.amountY0();
                            }
                        } else{

                            if (valorFinal.equals("1")) {

                                valore.amountN1();
                            } else{

                                valore.amountN0();
                            }
                        }
                    }
                }
            }
            vValue2++;
        }
        vValue++;
    }
    if(vValue == 0) {
        //System.out.println("Hello");
        System.out.println("Llegué");
    }
}

    public static int comprobarDatoMayor(ArrayList<String []> data){

    int cont1 = 0;
    int cont0 = 0;

    for(String [] filas: data){

        if(filas[30].equals("1")) cont1++;
        else cont0++;
    }

    if(cont1>cont0) return 1;
    else return 0;
}

public static String dfsTree(String [] fila, Node nodo){ 
    
    if(nodo.vContenido.getpreContenido().equals(Statistics.vENDOFTREE)) return nodo.vContenido.getlabelContenido();
    if(fila[nodo.vContenido.getIndex()].equals(nodo.vContenido.getlabelContenido())) return dfsTree(fila,nodo.vRight);
    else return dfsTree(fila,nodo.vLeft); //Puede optimizarse pero se obtienen peores resultados
}

}
