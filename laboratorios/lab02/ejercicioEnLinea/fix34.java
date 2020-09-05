public class fix34 {
    public static int[] fix34(int[] nums) {

        for(int i = 0; i < nums.length; i++){

            for(int a = 0; a < nums.length; a++){

                if(nums[i] == 3 && nums[a] == 4){

                    if(nums[a-1] != 3){

                        int temp = nums[i+1];
                        nums[i+1] = nums[a];
                        nums[a] = temp;
                    }
                }
            }
        }

        return nums;
    }
}
