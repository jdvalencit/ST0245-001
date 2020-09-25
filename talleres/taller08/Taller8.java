package me.JuanDavidVT;

import java.util.*;

public class Taller8 {

    public static int polaca(String string) {

        Stack<String> vStack = new Stack<String>();

        for (String vString : string.split(" ")) {

            try {

                int vNum = Integer.parseInt(vString);
                vStack.push(String.valueOf(vNum));
            } catch (NumberFormatException e) {

                switch (vString) {
                    case "+" -> {
                        int valueSumA = Integer.parseInt(vStack.pop());
                        int valueSumB = Integer.parseInt(vStack.pop());
                        vStack.push(String.valueOf(valueSumA + valueSumB));
                    }
                    case "-" -> {
                        int valueResA = Integer.parseInt(vStack.pop());
                        int valueResB = Integer.parseInt(vStack.pop());
                        vStack.push(String.valueOf(valueResB - valueResA));
                    }
                    case "*" -> {
                        int valueMultiA = Integer.parseInt( vStack.pop());
                        int valueMultiB = Integer.parseInt(vStack.pop());
                        vStack.push(String.valueOf(valueMultiA * valueMultiB));
                    }
                }
            }
        }

        return Integer.parseInt(vStack.peek());
    }

    public static void main(String[] args) {

        Stack<Integer> a;
        int[] a1, temp1;
        a = toStack(new int[] {1,2,3,4,5,5});
        a1 = new int[] {5,5,4,3,2,1};
        a = Taller8.inversa(a);
        temp1 = a.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(temp1));
    }

    public static Stack<Integer> toStack(int[]array){
        Stack<Integer> a=new Stack<Integer>();
        for(int i=0;i<array.length;i++){
            a.push(array[i]);
        }
        return a;
    }

    public static void asignarSolicitudes  (Stack<Integer> neveras, Stack<Integer> solicitudes) {

        for (int i = 0; i < solicitudes.size(); i++) {

            for (int k = 0; i < solicitudes.peek(); i++) {

                System.out.println("Nevera " + neveras.pop() + " entregada a " + solicitudes.peek());
            }

            solicitudes.pop();
        }

        solicitudes.pop();
    }

    public static Stack<Integer> inversa (Stack<Integer> stack){

        Stack<Integer> vTemp = new Stack<Integer>();
        int size = stack.size();

        for(int i = 0; i < size; i++){

            vTemp.push(stack.pop());
        }

        return vTemp;
    }

    public static void cola (Queue<String> queue){

        while(!queue.isEmpty()){

            System.out.println("Atendiendo a: " + queue.poll());
        }
    }
}