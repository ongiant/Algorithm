package acwing.middle_level.dp.interval;
import java.util.Scanner;

public class BonusBinaryTree_479 {
    static final int N = 30;
    static int n;
    static int[] w;
    static int[][] f, g;
    static{
        w = new int[N];
        f = new int[N][N];
        g = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        for(int i = 1; i <= n; i ++) w[i] = sin.nextInt();

        for(int len = 1; len <= n; len++){
            for(int L = 1; L + len - 1 <= n; L++){
                int R = L + len - 1;
                if(L == R){
                    f[L][R] = w[L];
                    g[L][R] = L;
                }
                else{
                    for(int k = L; k <= R; k++){
                        int left = k == L ? 1 : f[L][k - 1];
                        int right = k == R ? 1 : f[k + 1][R];
                        int score = w[k] + left * right;
                        if(score > f[L][R]){
                            f[L][R] = score;
                            g[L][R] = k;
                        }
                    }
                }
            }
        }

        System.out.println(f[1][n]);

        dfs(1, n);

        sin.close();
    }

    static void dfs(int L, int R){
        if(L > R) return;
        int root = g[L][R];
        System.out.print(root + " ");
        dfs(L, root - 1);
        dfs(root + 1, R);
    }
}
