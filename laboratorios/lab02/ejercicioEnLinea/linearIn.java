public class linearIn {
    public boolean linearIn(int[] outer, int[] inner) {

        int count = 0;
        int k = 0;

        if(inner.length == 0) return true;

        for(int i = 0; i < outer.length; i++){

            if(outer[i] == inner[k]){

                k++;
                count++;
            } else if(outer[i] > inner[k]) return false;

            if(count == inner.length) return true;
        }

        return false;
    }
}
