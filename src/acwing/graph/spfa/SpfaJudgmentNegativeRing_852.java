package acwing.graph.spfa;

import java.util.*;
import java.io.*;

public class SpfaJudgmentNegativeRing_852 {

    static final int N = 2010, M = 10010;
    static int n, m, idx;
    static boolean[] st;
    static int[] dist, cnt, w, h, e, ne;

    static {
        st = new boolean[N];
        dist = new int[N];
        cnt = new int[N];
        h = new int[N];

        w = new int[M];
        e = new int[M];
        ne = new int[M];

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

        if(spfa()) System.out.println("Yes");
        else System.out.println("No");

        sin.close();
    }

    static boolean spfa(){
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            queue.offer(i);
            st[i] = true;
        }

        while(!queue.isEmpty()){
            int t = queue.poll();
            st[t] = false;
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if(cnt[j] >= n) return true;
                    if(!st[j]){
                        queue.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }

    static void add(int a, int b, int c){
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }
}
