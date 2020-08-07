package me.JuanDavidVT;

public class Taller2 {

    public static int gcd(int p, int q){

        if (q == 0){

            return p;
        }else{

            return gcd(q, p % q);
        }
    }

    public static boolean sumaGrupo(int[] nums, int target){

        return sumaGrupo(0, nums, target);
    }

    private static boolean sumaGrupo(int start, int[] nums, int target) {

        if (target == 0){
            return true;
        }

        else if(start == nums.length){
            return false;
        }

        else {
            return sumaGrupo(start + 1, nums, target - nums[start]) || sumaGrupo(start + 1, nums, target);
        }
    }

    public static void combinations(String s) {
        combinationsAux("", s);
    }

    private static void combinationsAux(String prefix, String string) {

        if(string.length() == 0) {

            System.out.println(prefix);
        }

        else{

            combinationsAux(prefix + string.charAt(0), string.substring(1));
            combinationsAux(prefix, string.substring(1));
        }
    }
}