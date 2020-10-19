package me.JuanDavidVT;
import javafx.util.Pair;

public class Node {
    public Node left,right;
    private Pair<Long,String> data;

    public Node(Pair<Long,String> temp) {
        this.left = null;
        this.right = null;
        this.data = temp;
    }

    public Pair<Long,String> getData(){
        return this.data;
    }

    public void changeData(Pair<Long,String> temp){
        this.data = temp;
    }
}