package acwing.basic_level.search.dfs;

import java.util.*;
import java.io.*;

public class GravityCenterOfTree_846 {

    static final int N = 100010, M = N << 1;
    static int[] h, e, ne;
    static int idx;
    static boolean[] st;
    static int ans = N;
    static int n;

    static{
        st = new boolean[N];
        h = new int[N];
        e = new int[M];
        ne = new int[M]; // 无向图中的边需要存储为2条有向边，进而导致e也需要开成2N大小

        Arrays.fill(h, -1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        for(int i = 1; i < n; i++){
            int a = sin.nextInt(), b = sin.nextInt();
            insert(a, b);
            insert(b, a);
        }

        dfs(n);
        System.out.println(ans);

        sin.close();
    }

    // 计算以编号为u的节点为根的子树的节点数量
    static int dfs(int u){
        st[u] = true;

        int res = 0, sum = 1;
        for(int i = h[u]; i != -1; i = ne[i]){
            if(!st[e[i]]){
                int j = dfs(e[i]);
                res = Math.max(res, j);
                sum += j;
            }
        }
        res = Math.max(res, n - sum);
        ans = Math.min(ans, res);

        return sum;
    }

    static void insert(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
