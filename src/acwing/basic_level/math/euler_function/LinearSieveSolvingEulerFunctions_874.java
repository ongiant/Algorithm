package acwing.basic_level.math.euler_function;

import java.util.*;

public class LinearSieveSolvingEulerFunctions_874 {

    static final int N = 1000010;

    static int cnt;
    static int[] primes;
    static long[] phi;
    static boolean[] st;

    static{
        primes = new int[N];
        phi = new long[N];
        st = new boolean[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        int n = sin.nextInt();
        computeAllEulerFunction(n);

        long result = 0;
        phi[1] = 1;
        for(int i = 1; i <= n; i++){
            result += phi[i];
        }

        System.out.println(result);
        sin.close();
    }

    static void computeAllEulerFunction(int x){
        for(int i = 2; i <= x; i++){
            if(!st[i]){
                primes[cnt ++] = i;
                phi[i] = i - 1;
            }
            for(int j = 0; primes[j] <= x / i; j++){
                st[primes[j] * i] = true;
                if(i % primes[j] == 0) {
                    phi[primes[j] * i] = primes[j] * phi[i];
                    break;
                }
                phi[primes[j] * i] = (primes[j] - 1) * phi[i];
            }
        }
    }
}
