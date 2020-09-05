public class maxSpan {
    public static int maxSpan(int[] nums) {

        int span = 0; //Dos variables inicializan en cero
        int temp = 0;

        for (int i = 0; i < nums.length; i++) { //Ciclo primario

            for (int a = 0; a < nums.length; a++) { //Ciclo secundario

                if (nums[i] == nums[a]) {
                    //En cada ciclo revisa si el valor de el arreglo en el índice A es igual a el de el Índice B

                    temp = a - i + 1;
                    span = Math.max(temp,span);
                }
            }
        }
        return span;
    }
}
