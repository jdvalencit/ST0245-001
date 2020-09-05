public class sum13 {
    public int sum13(int[] nums) {

        int suma = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 13){

                continue;
            }

            if(i > 0 && nums[i-1] == 13) {

                continue;
            }

            suma += nums[i];
        }

        return suma;
    }

}
