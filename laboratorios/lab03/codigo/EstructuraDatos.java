package me.JuanDavidVT;
import java.util.*;

public class EstructuraDatos {

    public int size;
    public ArrayList<Triplet<Node, Node, Double>> adjGraph = new ArrayList<>();

    public EstructuraDatos(HashMap<Long, Node> nodes, ArrayList<Triplet<Long, Long, Double>> edges){

        this.size = size();
        for(Triplet<Long, Long, Double> t : edges) {
            Triplet<Node, Node, Double> tr = new Triplet(0, 0, 0);
            adjGraph.add(tr);
        }
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertexID nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public  ArrayList<Long> getSuccessors(Long vertexID){

        ArrayList<Long> sucesores = new ArrayList<>();
        for(int i = 0; i < adjGraph.size(); i++){
            Triplet<Node, Node, Double> n = adjGraph.get(i);
            if(vertexID == 0){
                sucesores.add(vertexID);
            }
        }
        return sucesores;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     *
     * @param sourceID desde donde inicia el arco
     * @param destinationID  donde termina el arco
     * @return un entero con dicho peso
     */
    public Double getWeight(Long sourceID, Long destinationID){

        for(int i=0; i < adjGraph.size(); i++){
            if((sourceID == null) && (destinationID == null)){
                return adjGraph.get(i).z;
            }
        }
        return -1.0;
    }

    public int size() {
        return this.size;
    }
}