public class TiemposEjecucion {

    public static void main(String[] args) {

        int[] testArray = TiemposEjecucion.crearArreglo(500000);

        long startTime, finishTime, finalTime;

        startTime = System.currentTimeMillis();

        //mergeSort(testArray, 0, testArray.length - 1);
        //insertionSort(testArray);

        finishTime = System.currentTimeMillis();
        finalTime = finishTime - startTime;
        System.out.println(finalTime);
    }

    public static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void merge(int arr[], int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static int[] crearArreglo(int tamano){

        int[] temp = new int[tamano];
        int num = tamano;

        for(int i = 0; i < tamano; i++){

            temp[i] = num;
            num--;
        }

        return temp;
    }
}