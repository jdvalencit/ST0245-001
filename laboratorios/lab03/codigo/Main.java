package me.JuanDavidVT;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{

    public static void main(String[] args){

        LectorDatos d = new LectorDatos();
        HashMap<Long, Node> nodes = d.readNodes();
        System.out.println(nodes.size());
        ArrayList<Triplet<Long, Long, Double>> edges = d.readEdges();
        System.out.println(edges.size());
        EstructuraDatos e = new EstructuraDatos(nodes, edges);
        System.out.println(e.adjGraph.size());
        System.out.println(nodes.get(287291920L).id);

        Long l = 287291920L;
        Long l2 = 1397149003L;

        ArrayList<Long> test1 = e.getSuccessors(l);
        System.out.println(test1.size());

        for(Long i : test1) {

            System.out.println(i);
        }

        System.out.println("Distance: " + e.getWeight(l, l2));
    }
}