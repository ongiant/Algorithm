package acwing.math.PrimeNumbers;

import java.util.*;

public class DecomposePrimeFactors_867 {

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        int n = sin.nextInt();

        while(n -- > 0){
            int a = sin.nextInt();
            divide(a);
            System.out.println();
        }
        sin.close();
    }

    static void divide(int x){
        for(int i = 2; i <= x / i; i++){
            if(x % i == 0){
                int s = 0;
                while(x % i == 0){
                    x /= i;
                    s++;
                }
                System.out.println(i + " " + s);
            }
        }

        if(x > 1) System.out.println(x + " " + 1);
    }
}
