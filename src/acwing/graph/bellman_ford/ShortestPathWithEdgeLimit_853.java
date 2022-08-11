package acwing.graph.bellman_ford;

import java.util.*;
import java.io.*;

public class ShortestPathWithEdgeLimit_853 {

    static final int N = 510, M = 10010, INF = 0x3f3f3f3f;
    static int n, m, k;
    static int[] dist, backup;
    static Edge[] edges;

    static {
        dist = new int[N];
        backup = new int[N];
        edges = new Edge[M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        n = sin.nextInt();
        m = sin.nextInt();
        k = sin.nextInt();
        for(int i = 0; i < m; i++){
            int a = sin.nextInt(), b = sin.nextInt(), w = sin.nextInt();
            edges[i] = new Edge(a, b, w);
        }

        int distance = bellman_ford();
        if(distance == INF){
            System.out.println("impossible");
        }
        else{
            System.out.println(distance);
        }

        sin.close();
    }

    static int bellman_ford(){
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for(int i = 0; i < k; i ++){
            backup = Arrays.copyOf(dist, n + 1);
            for(int j = 0; j < m; j ++){
                int a = edges[j].a, b = edges[j].b, w = edges[j].w;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }
        return dist[n] > (INF >> 1) ? INF : dist[n];
    }
}

class Edge{
    int a, b, w;

    Edge(int a, int b, int w){
        this.a = a;
        this.b = b;
        this.w = w;
    }
}
