package acwing.basic_level.math.combination;

import java.util.Scanner;

public class SequenceOfZeroOne_889 {

    static final int mod = 1000000000 + 7;

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        int n = sin.nextInt();
        long res = 1;
        for(int i = n << 1; i > n; i --) res = res * i % mod;
        for(int i = 1; i <= n; i ++) res = res * qmi(i, mod - 2) % mod;

        res = res * qmi(n + 1, mod - 2) % mod;
        System.out.println(res);

        sin.close();
    }

    static int qmi(int a, int k){
        int res = 1;
        while(k > 0){
            if((k & 1) == 1) res = (int) (res * (long) a % mod);
            k >>= 1;
            a = (int) (a * (long) a % mod);
        }
        return res;
    }
}
