package acwing.middle_level.dp.optimization.monotonic_queue;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class LawnMowing_1087 {
    static final int N = 100010;
    static int n, m, hh, tt;
    static int[] q;
    static long[] s, f;
    static{
        q = new int[N];
        s = new long[N];
        f = new long[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        for(int i = 1; i <= n; i++) {
            s[i] = sin.nextInt();
            s[i] += s[i - 1];
        }

        hh = tt = 0;
        for(int i = 1; i <= n; i++){
            if(q[hh] < i - m) hh++;
            f[i] = Math.max(f[i - 1], g(q[hh]) + s[i]);
            while (hh <= tt && g(q[tt]) <= g(i)) tt--;
            q[++tt] = i;
        }

        System.out.println(f[n]);

        sin.close();
    }

    static long g(int j){
        if(j == 0) return 0;
        return f[j - 1] - s[j];
    }
}
