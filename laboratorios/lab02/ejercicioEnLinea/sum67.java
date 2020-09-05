public class sum67 {
    public int sum67(int[] nums) {

        int suma = 0;
        boolean ignoreValue = false;

        for(int num : nums){

            if(num == 6){

                ignoreValue = true;
                continue;
            }

            if(num == 7 && ignoreValue){

                ignoreValue = false;
                continue;
            }

            if(ignoreValue){

                continue;
            }

            suma += num;
        }

        return suma;
    }
}
