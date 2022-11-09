package acwing.basic_level.graph.spfa;

import java.io.*;
import java.util.*;

public class ShortPath_spfa_851 {

    static int idx, n, m;
    static final int N = 100010, INF = 0x3f3f3f3f;

    static boolean[] st;
    static int[] dist, w, h, e, ne;

    static {
        st = new boolean[N];
        dist = new int[N];
        w = new int[N];
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        Arrays.fill(h, -1);
    }


    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        n = sin.nextInt();
        m = sin.nextInt();

        for(int i = 0; i < m; i++){
            int a = sin.nextInt(), b = sin.nextInt(), w = sin.nextInt();
            add(a, b, w);
        }
        spfa();
        if(dist[n] == INF) System.out.println("impossible");
        else System.out.println(dist[n]);

        sin.close();
    }

    static int spfa(){
        Arrays.fill(dist, INF);
        dist[1] = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        st[1] = true;

        while(!queue.isEmpty()){
            int t = queue.poll();
            st[t] = false;
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    if(!st[j]){
                        queue.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        return dist[n];
    }

    static void add(int a, int b, int c){
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx ++;
    }
}
