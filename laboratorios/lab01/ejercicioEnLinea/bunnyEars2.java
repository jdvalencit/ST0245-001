package me.JuanDavidVT;

public class bunnyEars2 {
    public int bunnyEars2(int bunnies) {

        if(bunnies == 0){

            return 0;
        }

        if((bunnies % 2) != 0){

            return bunnyEars2(bunnies-1) + 2;
        }

        return bunnyEars2(bunnies-1) + 3;
    }
}
