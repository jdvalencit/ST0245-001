package me.JuanDavidVT;
import javafx.util.Pair;
public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Pair usuario = new Pair(3116161774L,"Juan");
        bst.insertar(usuario);
        bst.insertar(new Pair(3206092870L,"Sara"));
        bst.insertar(new Pair(3045896452L,"Maria"));
        bst.insertar(new Pair(3208869429L,"Carlos"));
        bst.insertar(new Pair(3215258963L,"Miguel"));
        bst.insertar(new Pair(3127895214L,"Mauricio"));


        System.out.println("InOrden: ");
        bst.inOrden();
        System.out.println("\nPosOrden: ");
        bst.posOrden();
        System.out.println("\nPreOrden: ");
        bst.preOrden();

        System.out.println("\n");
        System.out.println(bst.graficar());
        System.out.println(bst.buscar(usuario));
        System.out.println(bst.buscar(new Pair(3215243L,"Mario")));

    }
}
