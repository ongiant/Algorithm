package acwing.basic_level.math.divisor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfDivisors_871 {

    static final int mod = 1000000000 + 7;
    static HashMap<Integer, Integer> primes;

    static{
        primes = new HashMap<>();
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        int n = sin.nextInt();

        while(n -- > 0){
            int x = sin.nextInt();
            computeDivisorNumber(x);
        }

        long result = 1;
        for(Map.Entry<Integer, Integer> e : primes.entrySet()){
            int p = e.getKey(), a = e.getValue();
            long t = 1;
            while(a -- > 0) t = (t * p + 1) % mod;
            result = result * t % mod;
        }
        System.out.println(result);
        sin.close();
    }

    static void computeDivisorNumber(int x){
        for(int i = 2; i <= x / i; i ++){
            while(x % i == 0){
                x /= i;
                primes.put(i, primes.getOrDefault(i, 0) + 1);
            }
        }
        if(x > 1) primes.put(x, primes.getOrDefault(x, 0) + 1);
    }
}

