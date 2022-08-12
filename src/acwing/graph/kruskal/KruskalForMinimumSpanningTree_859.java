package acwing.graph.kruskal;

import java.util.*;
import java.io.*;

public class KruskalForMinimumSpanningTree_859 {

    static final int N = 100010, INF = 0x3f3f3f3f;
    static int n, m;
    static int[] p;
    static Edge[] edges;

    static{
        p = new int[N];
        for(int i = 0; i < N; i ++) p[i] = i;

        edges = new Edge[N << 1];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        n = sin.nextInt();
        m = sin.nextInt();

        for(int i = 0; i < m; i ++){
            int a = sin.nextInt(), b = sin.nextInt(), w = sin.nextInt();
            edges[i] = new Edge(a, b, w);
        }

        int ans = kruskal();
        if(ans == INF) System.out.println("impossible");
        else System.out.println(ans);

        sin.close();
    }

    static int kruskal(){
        Arrays.sort(edges, 0, m);

        int res = 0, cnt = 1;
        for(int i = 0; i < m; i++){
            int a = edges[i].a, b = edges[i].b, w = edges[i].w;
            a = find(a);
            b = find(b);
            if(a != b){
                p[a] = b;
                res += w;
                cnt++;
            }
        }
        return cnt == n ? res : INF;
    }

    static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}

class Edge implements Comparable<Edge>{
    int a, b, w;

    Edge(int a, int b, int w){
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Edge x){
        return this.w - x.w;
    }
}
