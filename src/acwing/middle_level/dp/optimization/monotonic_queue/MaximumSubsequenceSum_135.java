package acwing.middle_level.dp.optimization.monotonic_queue;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class MaximumSubsequenceSum_135 {
    static final int N = 300010;
    static final long INF = 0xcfcfcfcfL;
    static int n, m, hh, tt;
    static int[] q;
    static long[] s;
    static {
        s = new long[N];
        q = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        for(int i = 1; i <= n; i++){
            int a = sin.nextInt();
            s[i] = a + s[i - 1];
        }

        hh = 0;
        tt = 0;
        long res = -INF;
        for(int i = 1; i <= n; i++){
            // compute the minimum value s[j], j is in [i-m, i-1]
            if(q[hh] < i - m) hh++;
            res = Math.max(res, s[i] - s[q[hh]]);
            while(hh <= tt && s[q[tt]] >= s[i]) tt--;
            q[++tt] = i;
        }

        System.out.println(res);

        sin.close();
    }
}
