package acwing.middle_level.dp.tree;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class PalaceCaretaker_1077 {
    static final int N = 1510, INF = 0x3f3f3f3f;
    static int n, idx, root;
    static int[] h, e, ne, w;
    static boolean[] st;
    static int[][] f;
    static{
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        w = new int[N];
        st = new boolean[N];
        f = new int[N][3];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        init();

        n = sin.nextInt();
        for(int i = 1; i <= n; i++){
            int p = sin.nextInt();
            w[p] = sin.nextInt();
            int m = sin.nextInt();
            for(int j = 0; j < m; j++){
                int son = sin.nextInt();
                add(p, son);
                st[son] = true;
            }
        }
        root = 1;
        while(st[root]) root ++;

        dfs(root);

        System.out.println(Math.min(f[root][1], f[root][2]));

        sin.close();
    }

    static void dfs(int u){
        f[u][1] = w[u];
        for(int i = h[u]; i != -1; i = ne[i]){
            int t = e[i];
            dfs(t);
            f[u][0] += Math.min(f[t][1], f[t][2]);
            f[u][1] += Math.min(f[t][0], Math.min(f[t][1], f[t][2]));
        }

        f[u][2] = INF;
        for(int i = h[u]; i != -1; i = ne[i]){
            int t = e[i];
            f[u][2] = Math.min(f[u][2], f[u][0] - Math.min(f[t][1], f[t][2]) + f[t][1]);
        }
    }

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void init(){
        idx = 0;
        Arrays.fill(h, -1);
    }
}
