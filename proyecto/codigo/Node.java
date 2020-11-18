package me.DavidLake.Entrega1;

public class Node {

    ContenidoNodo vContenido;
    Node vLeft;
    Node vRight;

    Node(ContenidoNodo vContent){
        this.vContenido = vContent;
        this.vLeft = null;
        this.vRight = null;
    }
}
