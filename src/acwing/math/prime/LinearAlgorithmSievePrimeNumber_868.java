package acwing.math.prime;

import java.util.Scanner;

public class LinearAlgorithmSievePrimeNumber_868 {

    static final int N = 1000010;
    static int cnt;
    static int[] primes;
    static boolean[] st;

    static {
        primes = new int[N];
        st = new boolean[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        int n = sin.nextInt();
        plainSieve(n);
        System.out.println(cnt);
        sin.close();
    }

    static void plainSieve(int n){
        for(int i = 2; i <= n; i ++){
            if(!st[i]) primes[cnt ++] = i;
            for(int j = 0; primes[j] <= n / i; j ++){
                st[primes[j] * i] = true;
                if(i % primes[j] == 0) break;
            }
        }
    }
}
