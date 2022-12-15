package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class MachineAllocation_1013 {

    static final int N = 11, M = 16;
    static int n, m;
    static int[] p;
    static int[][] f, w;
    static{
        f = new int[N][M];
        w = new int[N][M];
        p = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++){
                w[i][j] = sin.nextInt();
            }
        }

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                for(int k = 0; k <= j; k ++){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k] + w[i][k]);
                }
            }
        }
        System.out.println(f[n][m]);

        int j = m;
        for(int i = n; i > 0; i --){
            for(int k = 0; k <= j; k ++){
                if(f[i][j] == f[i - 1][j - k] + w[i][k]){
                    p[i] = k;
                    j -= k;
                    break;
                }
            }
        }
        for(int i = 1; i <= n; i ++){
            System.out.println(i + " " + p[i]);
        }

        sin.close();
    }
}
