package acwing.basic_level.graph.bigraph;

import java.io.*;
import java.util.*;

public class DyeingDeterminingBipartiteGraphs_860 {

    static final int N = 100010;
    static int idx, n, m;
    static int[] color, h, e, ne;

    static {
        h = new int[N];
        e = new int[N << 1];
        ne = new int[N << 1];
        Arrays.fill(h, -1);

        color = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        while(m -- > 0){
            int a = sin.nextInt(), b = sin.nextInt();
            add(a, b);
            add(b, a);
        }
        if(dyeing()) System.out.println("Yes");
        else System.out.println("No");

        sin.close();
    }

    static boolean dyeing(){
        for(int i = 1; i <= n; i++){
            if(color[i] == 0){
                if(!dfs(i, 1)) return false;
            }
        }
        return true;
    }

    static boolean dfs(int u, int c){
        color[u] = c;
        for(int i = h[u]; i != -1; i = ne[i]){
            int j = e[i];
            if(color[j] == 0){
                if(!dfs(j, 3 - c)) return false;
            }
            else if(color[j] == c) return false;
        }
        return true;
    }

    static void add(int a, int b){
        e[idx] = b; ne[idx] = h[a]; h[a] = idx ++;
    }
}
