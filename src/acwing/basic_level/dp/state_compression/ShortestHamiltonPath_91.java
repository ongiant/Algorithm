package acwing.basic_level.dp.state_compression;

import java.util.*;

public class ShortestHamiltonPath_91 {
    static final int N = 21, M = 1 << N;
    static int[][] w, f;

    static {
        w = new int[N][N];
        f = new int[M][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                w[i][j] = sin.nextInt();
            }
        }

        for(int i=0; i< 1<<n; i++){
            Arrays.fill(f[i], 0x3f3f3f3f);
        }
        f[1][0] = 0;

        for(int i=1; i < 1<<n; i++){
            for(int j=0; j<n; j++){
                if((i >> j & 1) == 1){
                    for(int k=0; k<n; k++){
                        if(((i - (1<<j)) >> k & 1) == 1){
                            f[i][j] = Math.min(f[i][j], f[i - (1<<j)][k] + w[k][j]);
                        }
                    }
                }
            }
        }
        System.out.println(f[(1<<n) - 1][n - 1]);
        sin.close();
    }
}
