package acwing.middle_level.dp.state_compression;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class AngryBirds_524 {

    static final int N = 18, M = 1 << N, INF = 0x3f3f3f3f;
    static final double eps = 1e-6;
    static int T, n;
    static int[] f, path[];
    static Point[] p;

    static{
        f = new int[M];
        path = new int[N][N];
        p = new Point[N];
    }
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        T = sin.nextInt();
        while(T-- > 0){
            n = sin.nextInt();
            int useless = sin.nextInt();
            for(int i = 0; i < n; i++) {
                p[i] = new Point(sin.nextDouble(), sin.nextDouble());
                Arrays.fill(path[i], 0);
            }

            for(int i = 0; i < n; i++){
                path[i][i] = 1 << i;

                for(int j = 0; j < n; j++){
                    double x1 = p[i].x, y1 = p[i].y;
                    double x2 = p[j].x, y2 = p[j].y;

                    if(0 == cmp(x1, x2)) continue;

                    double a = (y1 / x1 - y2 / x2) / (x1 - x2);
                    if(a >= 0) continue;

                    double b = y1 / x1 - a * x1;
                    int state = 1 << i | 1 << j;
                    for(int k = 0; k < n; k++){
                        double x = p[k].x, y = p[k].y;
                        if(0 == cmp(a * x * x + b * x, y)) state |= 1 << k;
                    }
                    path[i][j] = state;
                }
            }

            Arrays.fill(f, INF);
            f[0] = 0;
            for(int i = 0; i + 1 < 1 << n; i++){
                int x = 0, j = i;
                while((j & 1) == 1){
                    j >>= 1;
                    x++;
                }
                for(int k = 0; k < n; k++){
                    f[i | path[x][k]] = Math.min(f[i | path[x][k]], f[i] + 1);
                }
            }
            System.out.println(f[(1 << n) - 1]);
        }

        sin.close();
    }

    static int cmp(double a, double b){
        if(Math.abs(a - b) < eps) return 0;
        if(a < b) return -1;
        return 1;
    }

    static class Point{
        double x;
        double y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
}
