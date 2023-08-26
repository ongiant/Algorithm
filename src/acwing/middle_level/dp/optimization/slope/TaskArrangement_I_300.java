package acwing.middle_level.dp.optimization.slope;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class TaskArrangement_I_300 {
    static final int N = 5010;
    static final long INF = Long.MAX_VALUE;
    static int n, s;
    static int[] t, c;
    static long[] f;
    static {
        t = new int[N];
        c = new int[N];
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
        f[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= i; j++){
                f[i] = Math.min(f[i], f[j] + (long) s * (c[n] - c[j]) + t[i] * (long) (c[i] - c[j]));
            }
        }

        System.out.println(f[n]);

        sin.close();
    }
}
