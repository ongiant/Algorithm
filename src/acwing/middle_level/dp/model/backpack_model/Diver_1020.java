package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class Diver_1020 {

    static final int N = 22, M = 80, INF = 0x3f3f3f3f;
    static int v1, v2, n;
    static int[][] f;
    static {
        f = new int[N][M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        v1 = sin.nextInt();
        v2 = sin.nextInt();
        n = sin.nextInt();

        for(int i = 0; i <= v1; i ++){
            Arrays.fill(f[i], INF);
        }
        f[0][0] = 0;

        for(int i = 1; i <= n; i ++){
            int a = sin.nextInt(), b = sin.nextInt(), c = sin.nextInt();
            for(int j = v1; j >= 0; j --){
                for(int k = v2; k >= 0; k --){
                    f[j][k] = Math.min(f[j][k], f[Math.max(j - a, 0)][Math.max(k - b, 0)] + c);
                }
            }
        }
        System.out.println(f[v1][v2]);

        sin.close();
    }
}
