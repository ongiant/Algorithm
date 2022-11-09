package acwing.middle_level.dp;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class PickingPeanuts_1015 {

    static final int N = 110;
    static int[][] w, f;

    static{
        w = new int[N][N];
        f = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int T = sin.nextInt();
        while(T -- > 0){
            int n = sin.nextInt(), m = sin.nextInt();
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= m; j ++){
                    w[i][j] = sin.nextInt();
                }
            }

            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= m; j ++){
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + w[i][j];
                }
            }
            System.out.println(f[n][m]);
        }
        sin.close();
    }
}
