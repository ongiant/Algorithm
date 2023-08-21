package acwing.middle_level.dp.interval;
import java.util.Scanner;
import java.util.Arrays;

public class RingStoneMerge_1068 {
    static final int N = 405, INF = 0x3f3f3f3f;
    static int n;
    static int[] s, w;
    static int[][] f, g;
    static{
        s = new int[N];
        w = new int[N];
        f = new int[N][N];
        g = new int[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(f[i], INF);
            Arrays.fill(g[i], -INF);
        }
    }
    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        for(int i = 1; i <= n; i++){
            w[i] = sin.nextInt();
            w[i + n] = w[i];
        }

        for(int i = 1; i <= 2 * n; i++) s[i] = s[i - 1] + w[i];

        for(int len = 1; len <= n; len++){
            for(int L = 1; L + len - 1 <= 2 * n; L++){
                int R = L + len - 1;
                if(len == 1) {
                    f[L][R] = 0;
                    g[L][R] = 0;
                }
                else{
                    for(int k = L; k < R; k++){
                        f[L][R] = Math.min(f[L][R], f[L][k] + f[k + 1][R] + s[R] - s[L - 1]);
                        g[L][R] = Math.max(g[L][R], g[L][k] + g[k + 1][R] + s[R] - s[L - 1]);
                    }
                }
            }
        }

        int minv = INF, maxv = -INF;
        for(int i = 1; i <= n; i++){
            minv = Math.min(minv, f[i][i + n - 1]);
            maxv = Math.max(maxv, g[i][i + n - 1]);
        }
        System.out.printf("%d\n%d", minv, maxv);

        sin.close();
    }
}
