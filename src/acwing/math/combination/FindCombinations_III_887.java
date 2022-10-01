package acwing.math.combination;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class FindCombinations_III_887 {

    static long a, b;
    static int p;

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        while(n -- > 0){
            a = sin.nextLong();
            b = sin.nextLong();
            p = sin.nextInt();
            System.out.println(lucas(a, b));
        }
        sin.close();
    }

    static int lucas(long a, long b){
        if(a < p && b < p) return nCr((int) a, (int) b);
        // 注意，不要写成 (int) a % p的形式，因为这样会先将a从long转换为int再对p取模
        return (int) (nCr((int) (a % p), (int) (b % p)) * (long) lucas(a / p, b / p) % p);
    }

    static int nCr(int a, int b){
        long res = 1;
        for(int i = 1, j = a; i <= b; i ++, j --){
            res = res * j % p;
            res = res * qmi(i, p - 2) % p;
        }

        return (int) res;
    }

    static long qmi(long a, long k){
        long res = 1;
        while(k > 0){
            if((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }
}
