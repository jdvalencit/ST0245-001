public class countEvens {
    public int countEvens(int[] nums) {

        int total = 0;

        for(int num : nums){

            if(num % 2 == 0){

                total++;
            }
        }

        return total;
    }
}
