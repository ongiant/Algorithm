package acwing.middle_level.dp.interval;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class CheckerboardDivision_321 {
    static final int N = 15, M = 9;
    static final double INF = 1e10;
    static int n, m = 8;
    static double X;
    static int[][] s;
    static double f[][][][][];

    static{
        s = new int[M][M];
        f = new double[M][M][M][M][N];

        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < M; k++){
                    for(int t = 0; t < M; t++){
                        Arrays.fill(f[i][j][k][t], -1);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= m; j++){
                s[i][j] = sin.nextInt();
                s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];;
            }
        }

        X = s[m][m] / (double) n;

        System.out.printf("%.3f\n", Math.sqrt(dfs(1, 1, 8, 8, n)));

        sin.close();
    }

    static double dfs(int x1, int y1, int x2, int y2, int k){
        if(k == 1) {
            return f[x1][y1][x2][y2][k] = get(x1, y1, x2, y2);
        }
        if(f[x1][y1][x2][y2][k] >= 0) return f[x1][y1][x2][y2][k];

        f[x1][y1][x2][y2][k] = INF;
        for(int i = x1; i < x2; i++){
            f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], dfs(x1, y1, i, y2, k - 1) + get(i + 1, y1, x2, y2));
            f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], dfs(i + 1, y1, x2, y2, k - 1) + get(x1, y1, i, y2));
        }
        for(int j = y1; j < y2; j++){
            f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], dfs(x1, y1, x2, j, k - 1) + get(x1, j + 1, x2, y2));
            f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], dfs(x1, j + 1, x2, y2, k - 1) + get(x1, y1, x2, j));
        }
        return f[x1][y1][x2][y2][k];
    }

    static double get(int x1, int y1, int x2, int y2){
        int total = s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
        return (total - X) * (total - X) / n;
    }
}
