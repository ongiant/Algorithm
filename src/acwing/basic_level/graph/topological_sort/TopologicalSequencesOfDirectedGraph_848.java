package acwing.basic_level.graph.topological_sort;

import java.util.*;
import java.io.*;

public class TopologicalSequencesOfDirectedGraph_848 {

    static int n, m, idx, hh, tt;
    static final int N = 100010;
    static int[] e, ne, h, d, q;

    static {
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        d = new int[N];
        q = new int[N];
        Arrays.fill(h, -1);
    }

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = sin.nextInt();
        m = sin.nextInt();
        for(int i = 0; i < m; i++){
            int a = sin.nextInt(), b = sin.nextInt();
            insert(a, b);
            d[b]++;
        }
        if(toposort()){
            for(int i = 0; i < n; i++){
                bw.write(q[i] + " ");
            }
        }
        else bw.write("-1");

        sin.close();
        bw.close();
    }

    static boolean toposort(){

        tt = -1;
        for(int i = 1; i <= n; i++)
            if(d[i] == 0)
                q[++tt] = i;

        while(hh <= tt){
            int k = q[hh++];
            for(int i = h[k]; i != -1; i = ne[i]){
                int j = e[i];
                d[j] --;
                if(d[j] == 0){
                    q[++tt] = j;
                }
            }
        }
       return tt == n - 1;
    }

    static void insert(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
