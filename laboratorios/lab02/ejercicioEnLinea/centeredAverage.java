public class centeredAverage {
    public int centeredAverage(int[] nums){

        int suma = 0;
        int resultado = 0;
        int min = nums[0];
        int max = nums[0];
        boolean ignoredMin = false;
        boolean ignoredMax = false;

        for (int num : nums) {

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == max && !ignoredMax){

                ignoredMax = true;
                continue;
            }

            if(nums[i] == min && !ignoredMin){

                ignoredMin = true;
                continue;
            }

            suma += nums[i];
        }

        resultado = suma / (nums.length - 2);
        return resultado;
    }
}
