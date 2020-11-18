package me.DavidLake.Entrega1;

import java.util.ArrayList;
import java.util.HashSet;

public class Tree {

    Node root;

    public Tree(){

        this.root = null;
    }

    public static void treeAux(ArrayList<String[]> vDatalist, HashSet<String> vProcessed, Node vNode, Condicion[] vCondiciones){

        ArrayList<String[]> vPositive = new ArrayList<>();
        ArrayList<String[]> vNegative = new ArrayList<>();
        final int vValues = 198;

        for(String[] vTemp : vDatalist){

            if(vTemp[vNode.vContenido.getIndex()].equals(vNode.vContenido.getlabelContenido())) vPositive.add(vTemp);
            else vNegative.add(vTemp);
        }

        if(vPositive.size() < 10){

            int vTemp = DataAux.comprobarDatoMayor(vPositive);
            if(vTemp == 1) vNode.vRight = new Node(new ContenidoNodo("1", Statistics.vENDOFTREE, -1));
            else vNode.vRight = new Node(new ContenidoNodo("0", Statistics.vENDOFTREE, -1));
        }

        if(vNegative.size() < 10){

            int vTemp = DataAux.comprobarDatoMayor(vNegative);
            if(vTemp == 1) vNode.vLeft = new Node(new ContenidoNodo("1", Statistics.vENDOFTREE, -1));
            else vNode.vLeft = new Node(new ContenidoNodo("0", Statistics.vENDOFTREE, -1));
        }

        HashSet<String> vProcessedY = new HashSet<>();
        HashSet<String> vProcessedN = new HashSet<>();
        Condicion[] vAmountY = new Condicion[30];
        Condicion[] vAmountN = new Condicion[30];
        int vSize = vCondiciones.length;

        for(int i = 0;i < vSize;i++){

            vAmountY [i] = new Condicion(vCondiciones[i].getNombreVariable(), i);
            vAmountN [i] = new Condicion(vCondiciones[i].getNombreVariable(), i);
        }

        for(String vCurrent : vProcessed){

            vProcessedY.add(vCurrent);
            vProcessedN.add(vCurrent);
        }

        if(vNode.vLeft == null || !vNode.vLeft.vContenido.getpreContenido().equals(Statistics.vENDOFTREE)){

            if(!DataAux.pasarValores(vNegative, vProcessedN, vAmountN)){

                int vTemp = DataAux.comprobarDatoMayor(vNegative);
                if(vTemp == 1) vNode.vLeft = new Node(new ContenidoNodo("1", Statistics.vENDOFTREE, -1));
                else vNode.vLeft = new Node(new ContenidoNodo("0", Statistics.vENDOFTREE, -1));
            } else{

                DataAux.vTempsCount(vNegative, vProcessedN, vAmountN);
                Gini.workGini(vAmountN);
                ContenidoNodo vGini =  Gini.giniMenor(vAmountN);
                vProcessedN.add(vGini.getpreContenido() + vGini.getlabelContenido());

                if(vProcessedN.size() == vValues){

                    int vTemp = DataAux.comprobarDatoMayor(vNegative);

                    if(vTemp == 1) vNode.vLeft = new Node(new ContenidoNodo("1", Statistics.vENDOFTREE, -1));
                    else vNode.vLeft = new Node(new ContenidoNodo("0", Statistics.vENDOFTREE, -1));
                } else if(Statistics.isEquals(vNegative)){

                    if(vNegative.get(0)[30].equals("1")) vNode.vLeft = new Node(new ContenidoNodo("1", Statistics.vENDOFTREE, -1));
                    else vNode.vLeft = new Node(new ContenidoNodo("0", Statistics.vENDOFTREE, -1));
                } else{

                    vNode.vLeft =  new Node(vGini);
                    treeAux(vNegative, vProcessedN, vNode.vLeft, vAmountN);
                }
            }
        }

        if(vNode.vRight == null || !vNode.vRight.vContenido.getpreContenido().equals(Statistics.vENDOFTREE)){

            if(!DataAux.pasarValores(vPositive, vProcessedY, vAmountY)){

                int n = DataAux.comprobarDatoMayor(vPositive);
                if(n == 1) vNode.vRight = new Node(new ContenidoNodo("1", Statistics.vENDOFTREE, -1));
                else vNode.vRight = new Node(new ContenidoNodo("0", Statistics.vENDOFTREE, -1));
            } else{

                DataAux.vTempsCount(vPositive, vProcessedY, vAmountY);
                Gini.workGini(vAmountY);
                ContenidoNodo valor =  Gini.giniMenor(vAmountY);
                vProcessedY.add(valor.getpreContenido()+valor.getlabelContenido());

                if(vProcessedY.size() == vValues){

                    int n = DataAux.comprobarDatoMayor(vPositive);
                    if(n == 1) vNode.vRight = new Node(new ContenidoNodo("1", Statistics.vENDOFTREE, -1));
                    else vNode.vRight = new Node(new ContenidoNodo("0", Statistics.vENDOFTREE, -1));

                }else if(Statistics.isEquals(vPositive)){

                    if(vPositive.get(0)[30].equals("1")) vNode.vRight = new Node(new ContenidoNodo("1", Statistics.vENDOFTREE, -1));
                    else vNode.vRight = new Node(new ContenidoNodo("0", Statistics.vENDOFTREE, -1));

                }else{
                    vNode.vRight =  new Node(valor);
                    treeAux(vPositive, vProcessedY, vNode.vRight, vAmountY);
                }
            }
        }

    }

    public static Tree getRoot(String direccion){
    ArrayList<String[]> data = DataAux.cargar(direccion);

    Condicion[] variables = DataAux.asignarVariables(data);

    HashSet<String> valoresEvaluados = new HashSet<>();
    DataAux.pasarValores(data, valoresEvaluados, variables);
    DataAux.vTempsCount(data,valoresEvaluados , variables);
    Gini.workGini(variables);


    ContenidoNodo valor =  Gini.giniMenor(variables);

    Tree arbol = new Tree();
    arbol.root = new Node(valor);

    valoresEvaluados.add(valor.getpreContenido()+valor.getlabelContenido());

    treeAux(data, valoresEvaluados, arbol.root, variables);

    return arbol;
}
}
