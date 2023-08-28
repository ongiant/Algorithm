package acwing.middle_level.dp.optimization.slope;
import java.math.BigInteger;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class TaskArrangement_III_302 {
    static final int N = 300010;
    static final long INF = Long.MAX_VALUE;
    static int n, s;
    static int[] t, c;
    static int q[], hh, tt;
    static long[] f;
    static{
        t = new int[N];
        c = new int[N];
        q = new int[N];
        f = new long[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        s = sin.nextInt();
        for(int i = 1; i <= n; i++){
            t[i] = sin.nextInt();
            t[i] += t[i - 1];

            c[i] = sin.nextInt();
            c[i] += c[i - 1];
        }

        Arrays.fill(f, INF);
        f[0] = 0L;
        hh = tt = 0;
        q[0] = 0;
        for(int i = 1; i <= n; i++){
            int L = hh, R = tt;
            while(L < R){
                int mid = L + R >> 1;

                if(f[q[mid + 1]] -  f[q[mid]] >= (s + t[i]) * (long) (c[q[mid + 1]] - c[q[mid]])) R = mid;
                else L = mid + 1;
            }

            int j = q[R];
            f[i] = f[j] + s * (long) (c[n] - c[j]) + t[i] * (long) (c[i] - c[j]);

            while(hh < tt){
                if((double) (f[q[tt]] - f[q[tt - 1]]) * (c[i] - c[q[tt]]) < (double) (f[i] - f[q[tt]]) * (c[q[tt]] - c[q[tt - 1]])) break;
                tt --;
            }
            q[++tt] = i;
        }

        System.out.println(f[n]);

        sin.close();
    }
}
