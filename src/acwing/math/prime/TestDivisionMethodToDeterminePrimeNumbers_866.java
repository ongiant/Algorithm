package acwing.math.prime;

import java.util.*;

public class TestDivisionMethodToDeterminePrimeNumbers_866 {

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();

        while(n -- > 0){
            int a = sin.nextInt();
            if(isPrime(a)) System.out.println("Yes");
            else System.out.println("No");
        }

        sin.close();
    }

    static boolean isPrime(int x){
        if(x < 2) return false;

        for(int i = 2; i <= x / i; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}
