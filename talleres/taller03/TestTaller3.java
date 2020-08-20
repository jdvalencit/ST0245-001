package me.JuanDavidVT;

import java.util.Scanner;

public class TestTaller3 {

    public static void ejercicio1(){

        System.out.println("Desarrollo para n = 2 :");
        Taller3.torresDeHannoi(2);
        System.out.println("Desarrollo para n = 3 :");
        Taller3.torresDeHannoi(3);
        System.out.println("Desarrollo para n = 4 :");
        Taller3.torresDeHannoi(4);
    }

    public static void ejercicio2(){

        System.out.println("Para la cadena 'abc' las combinaciones deben ser similar a:");
        System.out.println("a, ab, abc, ac, b, bc, c");
        Taller3.getPermutations("abc");

        System.out.println("Para la cadena 'Eafit' las combinaciones deben ser similar a:");
        System.out.println("E, Ea, Eaf, Eafi, Eafit, Eaft, Eai, Eait, Eat, Ef, Efi, Efit, Eft, Ei, Eit, Et, a, af, afi, afit, aft, ai, ait, at, f, fi, fit, ft, i, it, t");
        Taller3.getPermutations("Eafit");

        System.out.println("Para la cadena 'Hola' las combinaciones deben ser similar a:");
        System.out.println("H, Ho, Hol, Hola, Hoa, Hl, Hla, Ha, o, ol, ola, oa, l, la, a");
        Taller3.getPermutations("Hola");

        System.out.println("Para la cadena 'Hi' las combinaciones deben ser similar a:");
        System.out.println("a, ab, abc, ac, b, bc, c");
        Taller3.getPermutations("H, Hi, i");
    }

    public static void ejercicio3(){

        System.out.println("Las permutaciones de la cadena 'abc' son:");
        System.out.println("abc, acb, bac, bca, cab, cba");
        System.out.println("");
        Taller3.getPermutations("abc");

        System.out.println("Las permutaciones de la cadena 'Hola' son:");
        System.out.println("Hola, Hoal, Hloa, Hlao, Haol, Halo, oHla, oHal, olHa, olaH, oaHl, oalH, lHoa, lHao, loHa, loaH, laHo, laoH, aHol, aHlo, aoHl, aolH, alHo, aloH");
        System.out.println("");
        Taller3.getPermutations("Hola");

        System.out.println("Las permutaciones de la cadena 'Dato' son:");
        System.out.println("Dato, Daot, Dtao, Dtoa, Doat, Dota, aDto, aDot, atDo, atoD, aoDt, aotD, tDao, tDoa, taDo, taoD, toDa, toaD, oDat, oDta, oaDt, oatD, otDa, otaD");
        System.out.println("");
        Taller3.getPermutations("Dato");
    }

    public static void main(String[] args){

        Scanner S = new Scanner(System.in);
        System.out.print("Ingresa cantidad de discos para ejercicio 1: ");
        Taller3.torresDeHannoi(S.nextInt());
        System.out.println();

        Taller3.getPermutations("abcd");
        Taller3.permutationExtra();
    }
}