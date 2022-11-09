package acwing.basic_level.dp.interval;

import java.util.*;

public class StoneHeapsMerge_282 {
    static final int N = 310;
    static int[] m;
    static long[][] f;

    static {
        m = new int[N];
        f = new long[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        for(int i=1; i<=n; i++){
            m[i] = sin.nextInt();
            m[i] += m[i - 1];
        }
        for(int j=2; j<=n; j++){
            for(int i= j - 1; i>0; i--){
                f[i][j] = Long.MAX_VALUE;
                for(int k=i; k<j; k++){
                    /**
                     * 这个方程决定了求f[i][j]的时候，第一维要降序遍历，第二维要升序遍历
                     * 因为f[k + 1][j]在第一维上相对于f[i][j]为后面的状态
                     * 而f[i][k]在第二维上相对于f[i][j]是前面的状态
                     */

                   f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j]);
                }
                f[i][j] += m[j] - m[i - 1];
            }
        }
        System.out.println(f[1][n]);
        sin.close();
    }
}
