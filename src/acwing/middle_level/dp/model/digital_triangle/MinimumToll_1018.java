package acwing.middle_level.dp.model.digital_triangle;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class MinimumToll_1018 {

    static final int N = 110, INF = 0x3f3f3f3f;
    static int[][] w, f;
    static{
        w = new int[N][N];
        f = new int[N][N];
    }
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= n; j ++){
                w[i][j] = sin.nextInt();
            }
        }

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= n; j ++){
                if(i == 1 && j == 1) f[i][j] = w[i][j];
                else{
                    f[i][j] = INF;
                    if(i > 1) f[i][j] = Math.min(f[i][j], f[i - 1][j] + w[i][j]);
                    if(j > 1) f[i][j] = Math.min(f[i][j], f[i][j - 1] + w[i][j]);
                }
            }
        }
        System.out.println(f[n][n]);
        sin.close();
    }
}
