package acwing.middle_level.dp.optimization.monotonic_queue;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class IdealSquare_1091 {
    static final int N = 1010, INF = 0x3f3f3f3f;
    static int n, m, k;
    static int[] q, aux, vin, vax;
    static int[][] g, row_max, row_min;
    static{
        q = new int[N];
        g = new int[N][N];
        aux = new int[N];
        vin = new int[N];
        vax = new int[N];
        row_max = new int[N][N];
        row_min = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        k = sin.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                g[i][j] = sin.nextInt();
            }
        }

        for(int i = 1; i <= n; i++){
            computeMin(g[i], row_min[i], m);
            computeMax(g[i], row_max[i], m);
        }

        int ans = INF;
        for(int j = k; j <= m; j++){
            for(int i = 1; i <= n; i++) aux[i] = row_min[i][j];
            computeMin(aux, vin, n);

            for(int i = 1; i <= n; i++) aux[i] = row_max[i][j];
            computeMax(aux, vax, n);

            for(int i = k; i <= n; i++) ans = Math.min(ans, vax[i] - vin[i]);
        }

        System.out.println(ans);

        sin.close();
    }

    static void computeMin(int[] a, int[] b, int len){
        int hh = 0, tt = -1;
        for(int i = 1; i <= len; i++){
            if(hh <= tt && q[hh] <= i - k) hh++;
            while(hh <= tt && a[q[tt]] >= a[i]) tt--;
            q[++tt] = i;
            b[i] = a[q[hh]];
        }
    }

    static void computeMax(int[] a, int[] b, int len){
        int hh = 0, tt = -1;
        for(int i = 1; i <= len; i++){
            if(hh <= tt && q[hh] <= i - k) hh++;
            while(hh <= tt && a[q[tt]] <= a[i]) tt--;
            q[++tt] = i;
            b[i] = a[q[hh]];
        }
    }
}
