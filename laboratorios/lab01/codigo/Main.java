package me.JuanDavidVT;
/*
* @author David José Cardona, Juan David Valencia
*/
public class Main{

    /**
     * Método que calcula la longitud de la subcadena común más larga
     * @param string1 Primer cadena
     * @param string2 Segunda cadena
     * @return longitud de la subcadena común más larga
     */

    public static int lcsDNA(String string1, String string2){
        return lcsDNAAux(string1,string2,string1.length(),string2.length(), 0);
    }
    /**
     * Método auxiliar para lcsDNA
     * @param string1 primeros caracteres
     * @param string2 segundos caracteres
     * @param m longitud de la cadena 1
     * @param n longitud de la cadena 2
     * @return longitud de la subcadena común más larga de las 2 cadenas
     */
    private static int lcsDNAAux(String string1, String string2, int m, int n, int count) {

        if(m == 0 || n == 0){
            return count;
        }

        if(string1.charAt(m-1)==string2.charAt(n-1)){
            int temp = lcsDNAAux(string1, string2, m-1, n-1, count+1);
            return temp;
        }

        return Math.max(count, Math.max(lcsDNAAux(string1, string2, m-1, n, 0), lcsDNAAux(string1, string2, m, n-1, 0)));
    }
    /**
     * Método que calcula el número de formas posibles para llenar un rectangulo de 2xn con rectangulos de 1x2
     * @param n, lado del rectangulo a llenar(2xn)
     * @return número de formas en las que se puede llenar el rectangulo de 2xn con rectangulos de 1x2
     */
    public static int ways(int n){

        if(n<=2) return n;
        return ways(n-1) + ways(n-2);
    }
}
