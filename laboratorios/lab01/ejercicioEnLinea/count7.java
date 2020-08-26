package me.JuanDavidVT;

public class count7 {
    public int count7(int n) {

        if(n == 0){

            return 0;
        }

        if((n % 10) == 7){

            return count7(n / 10) + 1;
        }

        return count7(n / 10);
    }
}
