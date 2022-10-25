package acwing.math.gaussian_elimination;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class GaussianEliminationSolvingLinearEquations_883 {

    static final double eps = 1e-8;
    static final int N = 110;
    static int n;
    static double[][] a;

    static {
        a = new double[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        n = sin.nextInt();
        for(int i = 0; i < n; i ++){
            for(int j = 0; j <= n; j ++){
                a[i][j] = sin.nextDouble();
            }
        }

        int ans = gauss();
        if(ans == 0){
            for(int i = 0; i < n; i ++){
                if(Math.abs(a[i][n]) < eps) a[i][n] = 0; // 处理浮点数负零的情况
                System.out.printf("%.2f\n", a[i][n]);
            }
        }
        else if(ans == 1){
            System.out.println("Infinite group solutions");
        }
        else System.out.println("No solution");

        sin.close();
    }

    static int gauss(){
        int r, c;
        for(r = 0, c = 0; c < n; c ++){
            int t = r;
            for(int i = r + 1; i < n; i ++){
                if(Math.abs(a[i][c]) > Math.abs(a[t][c])){
                    t = i;
                }
            }
            if(Math.abs(a[t][c]) < eps) continue;

            for(int i = c; i <= n; i ++) exch(a, r, i, t, i);
            for(int i = n; i >= c; i --) a[r][i] /= a[r][c];
            for(int i = r + 1; i < n; i ++) {
                for(int j = n; j >= c; j --){
                    a[i][j] -= a[r][j] * a[i][c];
                }
            }
            r ++;
        }
        if(r < n){
            for(int i = r; i < n; i ++){
                if(Math.abs(a[i][n]) > eps){
                    return -1; // 无解
                }
            }
            return 1; //无穷多解
        }
        for(int i = n - 1; i >= 0; i --){
            for(int j = i + 1; j < n; j ++){
                a[i][n] -= a[i][j] * a[j][n];
            }
        }
        return 0;
    }

    static void exch(double[][] a, int i, int j, int x, int y){
        double t = a[i][j]; a[i][j] = a[x][y]; a[x][y] = t;
    }
}
