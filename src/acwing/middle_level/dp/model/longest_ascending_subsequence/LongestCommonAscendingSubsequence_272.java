package acwing.middle_level.dp.model.longest_ascending_subsequence;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class LongestCommonAscendingSubsequence_272 {

    static final int N = 3010;
    static int n;
    static int[] a, b, f[];
    static{
        a = new int[N];
        b = new int[N];
        f = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        for(int i = 1; i <= n; i ++) a[i] = sin.nextInt();
        for(int i = 1; i <= n; i ++) b[i] = sin.nextInt();

        for(int i = 1; i <= n; i ++){
            int maxv = 1;
            for(int j = 1; j <= n; j ++){
                f[i][j] = f[i - 1][j];
                if(a[i] == b[j]){
                    f[i][j] = Math.max(f[i][j], maxv);
                }
                if(b[j] < a[i]){
                    maxv = Math.max(maxv, f[i - 1][j] + 1);
                }
            }
        }

        int res = 0;
        for(int i = 1; i <= n; i ++) res = Math.max(res, f[n][i]);
        System.out.println(res);
        sin.close();
    }
}
