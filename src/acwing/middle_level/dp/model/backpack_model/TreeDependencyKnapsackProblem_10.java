package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class TreeDependencyKnapsackProblem_10 {
    static final int N = 110;
    static int[][] f;
    static int[] h, e, ne, v, w;
    static int idx, n, m;

    static{
        f = new int[N][N];
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        v = new int[N];
        w = new int[N];

        Arrays.fill(h, -1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();

        int root = -1;
        for(int i = 1; i <= n; i++){
            v[i] = sin.nextInt();
            w[i] = sin.nextInt();

            int p = sin.nextInt();
            if(p == -1) root = i;
            else insert(i, p);
        }

        for(int i = v[root]; i <= m; i++) f[root][i] = w[root];
        dfs(root, v[root]);

        System.out.println(f[root][m]);

        sin.close();
    }

    static void dfs(int root, int vsum){

        for(int i = h[root]; i != -1; i = ne[i]) {
            int son = e[i];
            for(int j = vsum + v[son]; j <= m; j++){
                f[son][j] = f[root][j - v[son]] + w[son];
            }

            dfs(son, vsum + v[son]);

            for(int j = vsum + v[son]; j <= m; j++){
                f[root][j] = Math.max(f[root][j], f[son][j]);
            }
        }
    }

    static void insert(int number, int parent){
        e[idx] = number;
        ne[idx] = h[parent];
        h[parent] = idx++;
    }
}
