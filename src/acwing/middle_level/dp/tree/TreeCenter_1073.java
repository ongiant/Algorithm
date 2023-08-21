package acwing.middle_level.dp.tree;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class TreeCenter_1073 {
    static final int N = 10010, M = N << 1, INF = 0x3f3f3f3f;
    static int n, idx;
    static int[] h, e, ne, up, d1, d2, p1, w;
    static boolean[] isLeaf;
    static{
        h = new int[N];
        e = new int[M];
        ne = new int[M];
        up = new int[N];
        d1 = new int[N];
        d2 = new int[N];
        p1 = new int[N];
        w = new int[M];
        isLeaf = new boolean[N];

        Arrays.fill(h, -1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        for(int i = 1; i < n; i++){
            int a = sin.nextInt(), b = sin.nextInt(), weight = sin.nextInt();
            add(a, b, weight);
            add(b, a, weight);
        }

        dfs_d(1, -1);
        dfs_u(1, -1);

        int ans = d1[1];
        for(int i = 2; i <= n; i++){
            if(isLeaf[i]) ans = Math.min(ans, up[i]);
            else ans = Math.min(ans, Math.max(d1[i], up[i]));
        }
        System.out.println(ans);

        sin.close();
    }

    static int dfs_u(int a, int father){
        for(int i = h[a]; i != -1; i = ne[i]){
            int b = e[i];
            if(b == father) continue;
            if(p1[a] == b) up[b] = Math.max(up[a], d2[a]) + w[i];
            else up[b] = Math.max(up[a], d1[a]) + w[i];
            dfs_u(b, a);
        }
        return up[a];
    }

    static int dfs_d(int a, int father){
        d1[a] = -INF;
        d2[a] = -INF;
        for(int i = h[a]; i != -1; i = ne[i]){
            int b = e[i];
            if(b == father) continue;
            int d = dfs_d(b, a) + w[i];
            if(d >= d1[a]){
                d2[a] = d1[a];
                d1[a] = d;
                p1[a] = b;
            }
            else if(d > d2[a]){
                d2[a] = d;
            }
        }
        if(d1[a] == -INF){
            d1[a] = 0;
            d2[a] = 0;
            isLeaf[a] = true;
        }

        return d1[a];
    }

    static void add(int a, int b, int weight){
        e[idx] = b;
        w[idx] = weight;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
