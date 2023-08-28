package acwing.middle_level.dp.optimization.slope;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class TransportingKittens_303 {
    static final int N = 100010, M = 100010, P = 110;
    static final long INF = Long.MAX_VALUE;
    static int n, m, p, hh, tt;
    static int[] d, t, a, q;
    static long[] s;
    static long[][] f;
    static{
        d = new int[N];
        t = new int[M];
        a = new int[M];
        q = new int[M];
        s = new long[M];
        f = new long[P][M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        p = sin.nextInt();

        for(int i = 2; i <= n; i++) {
            d[i] = sin.nextInt();
            d[i] += d[i - 1];
        }

        for(int i = 1; i <= m; i++){
            int h = sin.nextInt();
            t[i] = sin.nextInt();
            a[i] = t[i] - d[h];
        }

        Arrays.sort(a, 1, m + 1);

        for(int i = 1; i <= m; i++){
            s[i] = a[i] + s[i - 1];
        }

        for(int i = 0; i <= p; i++){
            Arrays.fill(f[i], INF);
        }
        for(int i = 0; i <= p; i++) f[i][0] = 0;

        for(int j = 1; j <= p; j++){
            hh = tt = 0;
            q[0] = 0;
            for(int i = 1; i <= m; i++){
                while(hh < tt && (getY(j - 1, q[hh + 1]) - getY(j - 1, q[hh])) <= a[i] * (long) (q[hh + 1] - q[hh])) hh ++;
                int k = q[hh];
                f[j][i] = f[j - 1][k] + a[i] * (long) (i - k) - (s[i] - s[k]);
                while(hh < tt && (getY(j - 1, q[tt]) - getY(j - 1, q[tt - 1])) * (i - q[tt]) >= (getY(j - 1, i) - getY(j - 1, q[tt])) * (q[tt] - q[tt - 1])) tt --;
                q[++tt] = i;
            }
        }

        System.out.println(f[p][m]);
        sin.close();
    }

    static long getY(int j, int k){
        return f[j][k] + s[k];
    }
}
