package acwing.search.bfs;

import java.util.*;
import java.io.*;

public class HierarchyOfPointsInGraph_847 {

    static int n, m, idx;
    static final int N = 100010, M = N << 1;
    static int[] h, e, ne;
    static int[] q;
    static int[] d;
    static int hh, tt;

    static {
        d = new int[N];
        q = new int[N];
        h = new int[N];
        e = new int[M];
        ne = new int[M];
        Arrays.fill(h, -1);
        Arrays.fill(d, -1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        for(int i = 0; i < m; i++){
            int a = sin.nextInt(), b = sin.nextInt();
            insert(a, b);
        }

        System.out.println(bfs());

        sin.close();
    }

    static int bfs(){
        d[1] = 0;
        tt = -1;
        q[++tt] = 1;
        while(hh <= tt){
            int k = q[hh++];
            for(int i = h[k]; i != -1; i = ne[i]){
                int u = e[i];
                if(d[u] == -1){
                    d[u] = d[k] + 1;
                    q[++tt] = u;
                }
            }
        }
        return d[n];
    }

    static void insert(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
}
