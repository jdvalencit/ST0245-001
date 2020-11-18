package me.DavidLake.Entrega1;

import java.util.ArrayList;
import java.util.HashSet;

public class Tree {

    Node root;

    public Tree(){

        this.root = null;
    }

    public static void treeAux(ArrayList<String[]> vDatalist, HashSet<String> vProcessed, Node vNode, Condicion[] vCondiciones){

        ArrayList<String[]> SI = new ArrayList<>();
        ArrayList<String[]> NO = new ArrayList<>();
        final int CANTIDAD_VALORES = 198;

        for(String [] filas: vDatalist){
            if(filas[vNode.vContenido.getIndex()].equals(vNode.vContenido.getlabelContenido())) SI.add(filas);
            else NO.add(filas);
        }

        if(SI.size()<10){

            int n = DataAux.comprobarDatoMayor(SI);
            if(n == 1) vNode.vRight = new Node(new ContenidoNodo("1", "Terminal", -1));
            else vNode.vRight = new Node(new ContenidoNodo("0", "Terminal", -1));
        }

        if(NO.size()<10){

            int n = DataAux.comprobarDatoMayor(NO);
            if(n == 1) vNode.vLeft = new Node(new ContenidoNodo("1", "Terminal", -1));
            else vNode.vLeft = new Node(new ContenidoNodo("0", "Terminal", -1));
        }

        HashSet<String> vProcessedY = new HashSet<>();
        HashSet<String> vProcessedN = new HashSet<>();
        Condicion[] vAmountY = new Condicion[30];
        Condicion[] vAmountN = new Condicion[30];

        for(int i = 0;i<vCondiciones.length;i++){

            vAmountY [i] = new Condicion(vCondiciones[i].getNombreVariable(), i);
            vAmountN [i] = new Condicion(vCondiciones[i].getNombreVariable(), i);
        }
        for(String vCurrent : vProcessed){

            vProcessedY.add(vCurrent);
            vProcessedN.add(vCurrent);
        }

        if(vNode.vLeft == null || !vNode.vLeft.vContenido.getpreContenido().equals("Terminal")){

            if(!DataAux.pasarValores(NO, vProcessedN, vAmountN)){

                int n = DataAux.comprobarDatoMayor(NO);
                if(n == 1) vNode.vLeft = new Node(new ContenidoNodo("1", "Terminal", -1));
                else vNode.vLeft = new Node(new ContenidoNodo("0", "Terminal", -1));
            } else{

                DataAux.vTempsCount(NO, vProcessedN, vAmountN);
                Gini.calcularGini(vAmountN);
                ContenidoNodo vGini =  Gini.giniMenor(vAmountN);
                vProcessedN.add(vGini.getpreContenido() + vGini.getlabelContenido());

                if(vProcessedN.size() == CANTIDAD_VALORES){

                    int vTemp = DataAux.comprobarDatoMayor(NO);

                    if(vTemp == 1) vNode.vLeft = new Node(new ContenidoNodo("1", "Terminal", -1));
                    else vNode.vLeft = new Node(new ContenidoNodo("0", "Terminal", -1));
                } else if(Statistics.isEquals(NO)){

                    if(NO.get(0)[30].equals("1")) vNode.vLeft = new Node(new ContenidoNodo("1", "Terminal", -1));
                    else vNode.vLeft = new Node(new ContenidoNodo("0", "Terminal", -1));

                } else{
                    vNode.vLeft =  new Node(vGini);
                    treeAux(NO, vProcessedN, vNode.vLeft, vAmountN);
                }
            }
        }

        if(vNode.vRight == null || !vNode.vRight.vContenido.getpreContenido().equals("Terminal")){

            if(!DataAux.pasarValores(SI, vProcessedY, vAmountY)){

                int n = DataAux.comprobarDatoMayor(SI);
                if(n == 1) vNode.vRight = new Node(new ContenidoNodo("1", "Terminal", -1));
                else vNode.vRight = new Node(new ContenidoNodo("0", "Terminal", -1));
            } else{

                DataAux.vTempsCount(SI, vProcessedY, vAmountY);
                Gini.calcularGini(vAmountY);
                ContenidoNodo valor =  Gini.giniMenor(vAmountY);
                vProcessedY.add(valor.getpreContenido()+valor.getlabelContenido());

                if(vProcessedY.size() == CANTIDAD_VALORES){

                    int n = DataAux.comprobarDatoMayor(SI);
                    if(n == 1) vNode.vRight = new Node(new ContenidoNodo("1", "Terminal", -1));
                    else vNode.vRight = new Node(new ContenidoNodo("0", "Terminal", -1));

                }else if(Statistics.isEquals(SI)){

                    if(SI.get(0)[30].equals("1")) vNode.vRight = new Node(new ContenidoNodo("1", "Terminal", -1));
                    else vNode.vRight = new Node(new ContenidoNodo("0", "Terminal", -1));

                }else{
                    vNode.vRight =  new Node(valor);
                    treeAux(SI, vProcessedY, vNode.vRight, vAmountY);
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
    Gini.calcularGini(variables);


    ContenidoNodo valor =  Gini.giniMenor(variables);

    Tree arbol = new Tree();
    arbol.root = new Node(valor);

    valoresEvaluados.add(valor.getpreContenido()+valor.getlabelContenido());

    treeAux(data, valoresEvaluados, arbol.root, variables);

    return arbol;
}
}
