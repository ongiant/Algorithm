package acwing.middle_level.dp.interval;
import java.util.Arrays;
import java.util.Scanner;

public class ConvexPolygonPartition_1069 {

    static final int N = 55, M = 33;
    static int n;
    static int[] w;
    static long[] aux;
    static long[][][] f;

    static{
        w = new int[N];
        aux = new long[M];
        f = new long[N][N][M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        for(int i = 1; i <= n; i++) w[i] = sin.nextInt();

        for(int len = 3; len <= n; len++){
            for(int L = 1; L + len - 1 <= n; L++){
                int R = L + len - 1;
                Arrays.fill(f[L][R], 9);
                for(int k = L + 1; k < R; k++){
                    Arrays.fill(aux, 0);
                    aux[0] = w[L];
                    multiply(aux, w[k]);
                    multiply(aux, w[R]);
                    add(aux, f[L][k]);
                    add(aux, f[k][R]);
                    if(cmp(aux, f[L][R]) < 0){
                        System.arraycopy(aux, 0, f[L][R], 0, aux.length);
                    }
                }
            }
        }

        int x = M - 1;
        while(x >= 0 && f[1][n][x] == 0) x--;
        while(x >= 0)  System.out.print(f[1][n][x--]);

        sin.close();
    }

    static void add(long[] a, long[] b){
        long t = 0;
        for(int i = 0; i < M; i++){
            t += a[i] + b[i];
            a[i] = t % 10;
            t /= 10;
        }
    }

    static void multiply(long[] a, int b){
        long t = 0;
        for(int i = 0; i < M; i++){
            t += a[i] * b;
            a[i] = t % 10;
            t /= 10;
        }
    }

    static int cmp(long[] a, long[] b){
        for(int i = M - 1; i >= 0; i--){
            if(a[i] > b[i]) return 1;
            if(a[i] < b[i]) return -1;
        }
        return 0;
    }
}
