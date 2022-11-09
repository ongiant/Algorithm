package acwing.basic_level.dp.count;

import java.util.*;

public class IntegerDivision_900 {
    static final int mod = 1000000000 + 7, N = 1010;
    static long[] f;

    static {
        f = new long[N];
        f[0] = 1;
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                f[j] = (f[j] + f[j - i]) % mod;
            }
        }
        System.out.println(f[n]);
        sin.close();
    }
}
