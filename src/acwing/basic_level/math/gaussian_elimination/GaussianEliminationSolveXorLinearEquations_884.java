package acwing.basic_level.math.gaussian_elimination;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class GaussianEliminationSolveXorLinearEquations_884 {

    static final int N = 110;
    static int n;
    static int[][] a;

    static {
        a = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        for(int i = 0; i < n; i ++){
            for(int j = 0; j <= n; j ++){
                a[i][j] = sin.nextInt();
            }
        }
        int ans = gauss();
        if(ans == 0){
            for(int i = 0; i < n; i ++) System.out.println(a[i][n]);
        }
        else if(ans == 1){
            System.out.println("Multiple sets of solutions");
        }
        else System.out.println("No solution");

        sin.close();
    }

    static int gauss(){
        int r, c;
        for(r = c = 0; c < n; c ++){
            int t = r;
            for(int i = r; i < n; i ++){
                if(a[i][c] == 1){
                    t = i;
                    break;
                }
            }
            if(a[t][c] == 0) continue;

            for(int i = c; i <= n; i ++){
                exch(a, r, i, t, i);
            }
            for(int i = r + 1; i < n; i ++){
                if(a[i][c] == 1){
                    for(int j = c; j <= n; j ++){
                        a[i][j] ^= a[r][j];
                    }
                }
            }
            r ++;
        }
        if(r < n){
            for(int i = r; i < n; i ++){
                if(a[i][n] != 0){
                    return -1;
                }
            }
            return 1;
        }

        for(int i = n - 1; i >= 0; i --){
            for(int j = i + 1; j < n; j ++){
                a[i][n] ^= a[i][j] & a[j][n];
            }
        }
        return 0;
    }

    static void exch(int[][] a, int i, int j, int x, int y){
        int t = a[i][j];
        a[i][j] = a[x][y];
        a[x][y] = t;
    }
}
