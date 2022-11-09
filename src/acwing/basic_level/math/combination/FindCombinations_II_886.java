package acwing.basic_level.math.combination;

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.io.IOException;

public class FindCombinations_II_886 {

    static final int N = 100010, mod = 1000000000 + 7;

    static long[] fact, infact;

    static{
        fact = new long[N];
        infact = new long[N]; // n的阶乘的逆元（%mod）
    }

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();

        int n = sin.nextInt();
        while(n -- > 0){
            int a = sin.nextInt(), b = sin.nextInt();
            bw.write(fact[a] * infact[b] % mod * infact[a - b] % mod + "\n");
        }

        sin.close();
        bw.close();
    }

    static void init(){
        fact[0] = infact[0] = 1;
        for(int i = 1; i < N; i ++){
            fact[i] = fact[i - 1] * i % mod;
            infact[i] = qmi(fact[i], mod - 2, mod);
        }
    }

    static long qmi(long a, long k, long p){
        long t = 1;
        while(k > 0){
            if((k & 1) == 1) t = t * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return t;
    }
}
