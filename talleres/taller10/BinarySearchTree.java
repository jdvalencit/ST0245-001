package me.JuanDavidVT;
import javafx.util.Pair;
public class BinarySearchTree {

    private Node root;
    private String codigo = "";
    private int count = 0;

    // Constructor sin parametros iniciar sin nodo
    public BinarySearchTree() {
        this.root = null;
    }
    //Contructor iniciando con nodo
    public BinarySearchTree(Pair<Long,String> temp) {
        this.root = new Node(temp);
    }

    //Llama al metodo auxiliar insertar
    public void insertar(Pair<Long,String> temp) {
        insertarAux(root,temp);
    }

    // Agrega un nodo al arbol
    //Complejidad = O(Log n) sindo n el número de nodos en el arbol
    private void insertarAux(Node node,Pair<Long,String> temp) {
        if(node == null){
            this.root = new Node(temp);
            return;
        }
        if (node.getData().getKey().equals(temp.getKey())){
            return;
        }else if (temp.getKey() > node.getData().getKey()) {
            if (node.right == null) {
                node.right = new Node(temp);
            }else {
                insertarAux(node.right, temp);
            }
        }else {
            if (node.left == null) {
                node.left = new Node(temp);
            }else {
                insertarAux(node.left, temp);
            }
        }
    }

    // Llama al metodo auxiliar buscar
    public boolean buscar(Pair<Long,String> temp) {
        return buscarAux(root, temp);
    }

    //Busca en el arbol si existe un valor, devuelve true o false, dependiendo de si este o no
    //Complejidad = O(Log n) sindo n el número de nodos en el arbol
    private boolean buscarAux(Node node, Pair<Long,String> temp) {
        if (node.getData().getKey() == temp.getKey()) {
            return true;
        } else if (node.left == null && node.right == null) {
            return false;
        }
        if (temp.getKey() > node.getData().getKey()) {
            return buscarAux(node.right, temp);
        }
        return buscarAux(node.left, temp);
    }

    public String graficar(){
        return graficarAux(this.root);
    }

    private String graficarAux(Node node) {
        if (node.left != null && node.right != null) {
            codigo += node.getData().getValue() + " -> " + node.left.getData().getValue()+ " ";
            graficarAux(node.left);
            codigo += node.getData().getValue() + " -> " + node.right.getData().getValue() + " ";
            graficarAux(node.right);

        } else if (node.left == null && node.right != null) {
            codigo += node.getData().getValue() + " -> " + node.right.getData().getValue() + " " ;
            graficarAux(node.right);

        } else if (node.left != null) {
            codigo += node.getData().getValue() + " -> " + node.left.getData().getValue() + " ";
            graficarAux(node.left);

        }
        return codigo;
    }

    public void inOrden(){
        this.count = 1;
        inOrderAux(this.root);
    }

    public void inOrderAux(Node node){
        if(node.left != null){
            inOrderAux(node.left);
        }

        System.out.println(this.count+". "+node.getData().getValue()+"  ");
        this.count++;
        if(node.right != null){
            inOrderAux(node.right);
        }
    }

    public void preOrden(){
        this.count = 1;
        preOrdenAux(this.root);

    }

    public void preOrdenAux(Node node){
        System.out.println(this.count+". "+node.getData().getValue()+"  ");
        this.count++;
        if(node.left != null){
            preOrdenAux(node.left);
        }

        if(node.right != null){
            preOrdenAux(node.right);
        }
    }

    public void posOrden(){
        this.count = 1;
        posOrdenAux(this.root);
    }

    public void posOrdenAux(Node node){

        if(node.left != null){
            posOrdenAux(node.left);
        }

        if(node.right != null){
            posOrdenAux(node.right);
        }

        System.out.println(this.count+". "+node.getData().getValue()+"  ");
        this.count++;
    }

}