package acwing.basic_level.graph.dijkstra;

import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int first;
    int second;
    Pair(int f, int s){
        first = f;
        second = s;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.first != p.first) return this.first - p.first;
        else return this.second - p.second;
    }
}

public class DijkstraForShortestPath_II_850 {

    static final int N = 150010, INF = 0x3f3f3f3f;
    static int n, m, idx;
    static int[] h, e, ne, dist, w;
    static boolean[] st;
    static PriorityQueue<Pair> heap;

    static{
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        dist = new int[N];
        st = new boolean[N];
        w = new int[N];
        heap = new PriorityQueue<>();

        Arrays.fill(h, -1);
        Arrays.fill(dist, INF);
        Arrays.fill(w, INF);
        dist[1] = 0;
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        n = sin.nextInt();
        m = sin.nextInt();

        while(m-- > 0){
            int a = sin.nextInt(), b = sin.nextInt(), c = sin.nextInt();
            insert(a, b, c);
        }

        System.out.println(dijkstra());

        sin.close();
    }

    static int dijkstra(){
        Pair pr = new Pair(0, 1);
        heap.offer(pr);

        while(heap.size() > 0){

            Pair p = heap.poll();

            assert p != null;

            int ver = p.second, distance = p.first;
            if(st[ver]) continue;
            st[ver] = true;

            for(int i = h[ver]; i != -1; i = ne[i]){
                int u = e[i];
                if(dist[u] > distance + w[i]){
                    dist[u] = distance + w[i];
                    heap.offer(new Pair(dist[u], u));
                }
            }
        }
        return dist[n] == INF ? -1 : dist[n];
    }

    static void insert(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
