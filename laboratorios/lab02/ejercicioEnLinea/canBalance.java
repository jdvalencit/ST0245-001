public class canBalance {
    public boolean canBalance(int[] nums) {

        int leftTotal = 0;
        int rightTotal = 0;

        for(int i = 0; i < nums.length; i++){

            leftTotal += nums[i];
            rightTotal = 0;

            for(int a = nums.length - 1; a > i; a--){

                rightTotal += nums[a];
            }

            if(leftTotal == rightTotal){

                return true;
            }
        }
        return false;
    }
}
