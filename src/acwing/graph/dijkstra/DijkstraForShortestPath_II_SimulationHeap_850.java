package acwing.graph.dijkstra;

import java.util.*;
import java.io.*;

/**
 * key point: ph[节点编号]=节点在堆中的索引，因为节点编号彼此不同，所以可以这么维护
 */

public class DijkstraForShortestPath_II_SimulationHeap_850 {

    static final int N = 150010, INF = 0x3f3f3f3f;
    static int n, m, idx;
    static int [] h, e, ne, dist, w;
    static boolean[] st;

    static int[] heap, ph, hp;
    static int sz;

    static{
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        Arrays.fill(h, -1);

        dist = new int[N];
        w = new int[N];
        st = new boolean[N];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        Arrays.fill(w, INF);

        heap = new int[N];
        ph = new int[N];
        hp = new int[N];
        Arrays.fill(ph, -1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        n = sin.nextInt();
        m = sin.nextInt();
        for(int i = 0; i < m; i++){
            int a = sin.nextInt(), b = sin.nextInt(), c = sin.nextInt();
            add(a, b, c);
        }

        System.out.println(dijkstra());

        sin.close();
    }

    static int dijkstra(){
        heap_push(1, 0);

        while(heap_size() > 0){
            Node v = heap_pop();
            int ver = v.number, distance = v.distance;

            if(st[ver]) continue;
            st[ver] = true;

            for(int i = h[ver]; i != -1; i = ne[i]){
                int u = e[i];
                if(dist[u] > distance + w[i]){
                    dist[u] = distance + w[i];
                    heap_update(u, dist[u]);
                }
            }
        }

        return dist[n] == INF ? -1 : dist[n];
    }

    // 邻接表插入边
    static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    /**
     * 以下内容为手写堆
     *
     */

    static Node heap_pop(){
        int dist = heap[1];
        int num = hp[1];
        heap_swap(1, sz--);
        ph[num] = -1;
        sink(1);
        return new Node(num, dist);
    }

    static void heap_update(int number, int distance){
        int index = ph[number];
        if(!contains(number)) {
            heap_push(number, distance);
            return;
        }

        heap[index] = distance;
        sink(index);
        swim(index);
    }

    static void heap_push(int number, int distance){
        ph[number] = ++sz;
        hp[sz] = number;
        heap[sz] = distance;
        swim(sz);
    }

    // 堆中是否包含编号为number的节点
    static boolean contains(int number){
        return ph[number] != -1;
    }

    static int heap_size(){
        return sz;
    }

    static void swim(int index){
        while(index / 2 > 0 && heap[index / 2] > heap[index]){
            heap_swap(index / 2, index);
            index /= 2;
        }
    }

    static void sink(int index){
        while(2 * index <= sz){
            int j = 2 * index;
            if(j < sz && heap[j] > heap[j + 1]) j += 1;
            if(heap[index] <= heap[j]) break;

            heap_swap(index, j);
            index = j;
        }
    }

    static void heap_swap(int i, int j){
        exch(ph, hp[i], hp[j]);
        exch(hp, i, j);
        exch(heap, i, j);
    }

    static void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

class Node {
    int number;
    int distance;

    Node(int number, int distance){
        this.number = number;
        this.distance = distance;
    }
}
