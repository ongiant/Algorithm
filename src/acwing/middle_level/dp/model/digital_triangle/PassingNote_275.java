package acwing.middle_level.dp.model.digital_triangle;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class PassingNote_275 {

    static final int N = 55;
    static int n, m;
    static int[][] w, f[];
    static{
        w = new int[N][N];
        f = new int[N << 1][N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                w[i][j] = sin.nextInt();
            }
        }

        for(int k = 2; k <= n + m; k ++){
            int st = Math.max(1, k - m), ed = Math.min(n, k - 1);
            for(int i = st; i <= ed; i ++){
                for(int j = st; j <= ed; j ++){
                    int t = w[i][k - i] + w[j][k - j];
                    for(int a = 0; a <= 1; a ++){
                        for(int b = 0; b <= 1; b ++){
                            if(i != j || k == 2 || k == n + m){
                                f[k][i][j] = Math.max(f[k][i][j], f[k - 1][i - a][j - b] + t);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(f[n + m][n][n]);

        sin.close();
    }
}
