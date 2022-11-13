package acwing.middle_level.dp.model.digital_triangle;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class CountingFromSquares_1027 {

    static final int N = 15;
    static int n;
    static int[][] w, f;
    static{
        w = new int[N][N];
        f = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        int a, b, c;
        while((a = sin.nextInt()) != 0 && (b = sin.nextInt()) != 0 && (c = sin.nextInt()) != 0){
            w[a][b] = c;
        }
        System.out.println();

        for(int k = 2; k <= 2 * n; k ++){
            for(int i1 = n; i1 >= 1; i1 --){
                for(int i2 = n; i2 >= 1; i2 --){
                    int j1 = k - i1, j2 = k - i2;
                    if(j1 >= 1 && j1 <= n && j2 >= 1 && j2 <= n){
                        int t = w[i1][j1];
                        if(i1 != i2) t += w[i2][j2];
                        f[i1][i2] = Math.max(f[i1][i2], f[i1][i2] + t); //先利用f[i1][i2]中保存的之前的结果计算，避免被此轮操作覆盖掉先前的计算结果
                        f[i1][i2] = Math.max(f[i1][i2], f[i1 - 1][i2 - 1] + t);
                        f[i1][i2] = Math.max(f[i1][i2], f[i1 - 1][i2] + t);
                        f[i1][i2] = Math.max(f[i1][i2], f[i1][i2 - 1] + t);
                    }
                }
            }
        }
        System.out.println(f[n][n]);

        sin.close();
    }
}
