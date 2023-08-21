package acwing.middle_level.dp.interval;
import java.util.Scanner;

public class PowerNecklace_320 {
    static final int N = 210;
    static int n;
    static int[] w;
    static int[][] f;
    static{
        w = new int[N];
        f = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        for(int i = 1; i <= n; i++){
            w[i] = sin.nextInt();
            w[i + n] = w[i];
        }

        for(int len = 3; len <= n + 1; len++){
            for(int L = 1; L + len - 1 <= 2 * n; L++){
                int R = L + len - 1;
                for(int k = L + 1; k < R; k++){
                    f[L][R] = Math.max(f[L][R], f[L][k] + f[k][R] + w[L] * w[k] * w[R]);
                }
            }
        }

        int res = 0;
        for(int i = 1; i <= n; i++) res = Math.max(res, f[i][i + n]);
        System.out.println(res);

        sin.close();
    }
}
