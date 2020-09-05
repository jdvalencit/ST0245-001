public class fix45 {
    public static int[] fix45(int[] nums) {

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 4){

                for(int a = 0; a < nums.length; a++){

                    if(nums[a] == 5){

                        if((a-1) != i){

                            int temp = nums[i+1];
                            nums[i+1] = nums[a];
                            nums[a] = temp;
                        }
                    }
                }
            }
        }

        return nums;
    }
}