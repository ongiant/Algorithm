package acwing.basic_level.search.dfs;

import java.util.*;

public class ArrangeNumbers_842 {
    static int n;
    static final int N = 10;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        n = sin.nextInt();
        dfs(0);
    }

    static void dfs(int u){
        if(u == n) {
            for(int i = 0; i < n; i++) System.out.printf("%d ", path[i]);
            System.out.println();
        }
        for(int i = 1; i <= n; i++){
            if(!st[i]){
                st[i] = true;
                path[u] = i;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }
}
