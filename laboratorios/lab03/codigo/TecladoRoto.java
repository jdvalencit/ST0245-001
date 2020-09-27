package me.JuanDavidVT;
import java.util.LinkedList;

public class TecladoRoto {

    private static String arreglarString(String vString){

        String vFinal = "";
        LinkedList<String> vLista = new LinkedList<>();
        boolean end = true;
        StringBuilder cur = new StringBuilder("");

        for(int i = 0; i < vString.length(); i++){

            char vChar = vString.charAt(i);

            if(vChar == '[' || vChar == ']'){

                if(end){

                    vLista.addLast(cur.toString());
                } else{

                    vLista.addFirst(cur.toString());
                }

                end = vChar != '[';

                cur = new StringBuilder("");
            } else{

                cur.append(vChar);
            }
        }

        if(end) vLista.addLast(cur.toString());
        else vLista.addFirst(cur.toString());

        while(vLista.size() > 0){

            vFinal = vFinal.concat(vLista.pollFirst());
        }

        return vFinal;
    }
}