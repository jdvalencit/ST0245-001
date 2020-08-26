package me.JuanDavidVT;

public class splitOdd10 {
    public boolean splitOdd10(int[] n) {

        int index = 0;
        int sum1 = 0;
        int sum2 = 0;

        return Array(n, index, sum1, sum2);

    }

    private boolean Array ( int[] n, int index, int sum1, int sum2 ) {

        if ( index >= n.length ) {

            return (sum1%10 == 0 && sum2%2 !=0) || (sum2%10 == 0 && sum1%2 !=0);

        }

        int value = n[index];

        return (Array(n, index + 1, sum1 + value, sum2) ||
                Array(n, index + 1, sum1, sum2 + value));

    }
}
