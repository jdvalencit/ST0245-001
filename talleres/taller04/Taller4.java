package me.JuanDavidVT;
public class Taller4 {

    protected static int getArrayMax(int[] array, int n) {

        int max, temp;
        max = array[n];
        if(n > 0){
            temp = getArrayMax(array, n-1 );
            if(temp > max)
                max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Taller4.getArrayMax(new int[] {12,324,43,2,3,43,2,3,43},8));
        System.out.println(Taller4.getArrayMax(new int[] {3,2,343,2,43,55,67,68,86,3,4},10));
        System.out.println(Taller4.getArrayMax(new int[] {56,7,6,45,8,4,34,8,7,5,34,7,78,9},13));
        System.out.println(Taller4.getArrayMax(new int[] {1,2,3,4,5,5},5));
    }

    public static boolean groupSum(int start, int[] nums, int target) {

        if(target == 0){

            return true;
        }

        if(start == nums.length){

            return false;
        }

        return groupSum(start+1, nums, target-nums[start]) || groupSum(start+1, nums, target);
    }

    public static long fibonacci(int n) {

        if (n <= 2) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}