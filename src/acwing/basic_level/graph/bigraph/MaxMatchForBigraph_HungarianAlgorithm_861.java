package acwing.basic_level.graph.bigraph;

import java.util.*;
import java.io.*;

public class MaxMatchForBigraph_HungarianAlgorithm_861 {

    static int n1, n2, m, idx;
    static final int N = 510, M = 100010;
    static int[] st, match, h, e, ne;

    static {
        st = new int[N];
        match = new int[N];
        h = new int[N];
        e = new int[M];
        ne = new int[M];
        Arrays.fill(h, -1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        n1 = sin.nextInt();
        n2 = sin.nextInt();
        m = sin.nextInt();

        while(m -- > 0){
            int a = sin.nextInt(), b = sin.nextInt();
            add(a, b);
        }

        System.out.println(hungarian());

        sin.close();
    }

    static int hungarian(){
        int res = 0;
        for(int i = 1; i <= n1; i ++){
            Arrays.fill(st, 0);
            if(dfs(i)) res ++;
        }
        return res;
    }

    static boolean dfs(int x){

        for(int i = h[x]; i != -1; i = ne[i]){
            int j = e[i];
            if(st[j] == 0){
                st[j] = 1;
                if(match[j] == 0 || dfs(match[j])){
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    static void add(int a, int b){
        e[idx] = b; ne[idx] = h[a]; h[a] = idx ++;
    }
}
