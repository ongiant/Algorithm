package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class TwoDimensionalFeesKnapsackProblem_8 {
    static final int Z = 110;
    static int N, V, M;
    static int[][] f;

    static{
        f = new int[Z][Z];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        N = sin.nextInt();
        V = sin.nextInt();
        M = sin.nextInt();

        for(int i = 1; i <= N; i ++){
            int v = sin.nextInt(), m = sin.nextInt(), w = sin.nextInt();
            for(int j = V; j >= v; j --){
                for(int k = M; k >= m; k --){
                    f[j][k] = Math.max(f[j][k], f[j - v][k - m] + w);
                }
            }
        }
        System.out.println(f[V][M]);

        sin.close();
    }
}
