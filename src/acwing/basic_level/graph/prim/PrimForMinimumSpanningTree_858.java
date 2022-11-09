package acwing.basic_level.graph.prim;

import java.io.*;
import java.util.*;

public class PrimForMinimumSpanningTree_858 {

    static final int N = 510, INF = 0x3f3f3f3f;
    static int n;
    static boolean[] st;
    static int[] dist;
    static int[][] g;

    static {
        st = new boolean[N];
        dist = new int[N];
        g = new int[N][N];
        for(int i = 0; i < N; i++) Arrays.fill(g[i], INF);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        n = sin.nextInt();
        int m = sin.nextInt();

        while(m -- > 0){
            int a = sin.nextInt(), b = sin.nextInt(), w = sin.nextInt();
            g[a][b] =g[b][a] = Math.min(g[a][b], w);
        }
        int ans = prim();
        if(ans == INF) System.out.println("impossible");
        else System.out.println(ans);
        sin.close();
    }

    static int prim(){
        Arrays.fill(dist, INF);

        int res = 0;
        for(int i = 0; i < n; i ++){
            int t = -1;
            for(int j = 1; j <= n; j ++){
                if(!st[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }
            if(i > 0 && dist[t] == INF) return INF;
            if(i > 0) res += dist[t];
            st[t] = true;

            for(int j = 1; j <= n; j++) dist[j] = Math.min(dist[j], g[t][j]);
        }

        return res;
    }
}
