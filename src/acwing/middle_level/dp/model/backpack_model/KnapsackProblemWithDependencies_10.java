package acwing.middle_level.dp.model.backpack_model;

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class KnapsackProblemWithDependencies_10 {
    static final int N = 110;
    static int n, m;
    static int h[], e[], ne[], idx;
    static int[] v, w;
    static int[][] f;

    static {
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        Arrays.fill(h, -1);

        v = new int[N];
        w = new int[N];
        f = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();

        int root = 0, p;
        for(int i = 1; i <= n; i ++){
            v[i] = sin.nextInt();
            w[i] = sin.nextInt();
            p = sin.nextInt();
            if(p == -1){
                root = i;
            }
            else{
                insert(i, p);
            }
        }

        dfs(root);

        System.out.println(f[root][m]);

        sin.close();
    }

    static void dfs(int u){

        for(int j = v[u]; j <= m; j ++){
            f[u][j] = w[u];
        }

        for(int i = h[u]; i != -1; i = ne[i]){
            int son = e[i];
            dfs(son);

            for(int j = m; j >= v[u]; j --){
                for(int k = 0; k <= j - v[u]; k ++){
                    f[u][j] = Math.max(f[u][j], f[u][j - k] + f[son][k]);
                }
            }
        }
    }

    static void insert(int x, int head){
        e[idx] = x;
        ne[idx] = h[head];
        h[head] = idx ++;
    }
}
