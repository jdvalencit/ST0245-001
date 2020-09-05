public class bigDiff {
    public static int bigDiff(int[] nums){

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return (max - min);
    }
}
