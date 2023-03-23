package acwing.middle_level.dp.model.backpack_model;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class FindSpecificSolutionForKnapsackProblem_12 {

    static final int N = 1010;
    static int[][] f;
    static int[] v, w;

    static{
        f = new int[N][N];
        v = new int[N];
        w = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt(), m = sin.nextInt();

        for(int i = 1; i <= n; i ++){
            v[i] = sin.nextInt();
            w[i] = sin.nextInt();
        }

        for(int i = n; i > 0; i --){
            for(int j = 0; j <= m; j ++){
                f[i][j] = f[i + 1][j];
                if(j >= v[i]) f[i][j] = Math.max(f[i][j], f[i + 1][j - v[i]] + w[i]);
            }
        }

        for(int i = 1; i <= n; i ++){
            if(m >= v[i] && f[i][m] == f[i + 1][m - v[i]] + w[i]){
                System.out.print(i + " ");
                m -= v[i];
            }
        }

        sin.close();
    }
}
