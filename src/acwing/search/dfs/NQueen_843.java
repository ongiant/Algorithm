package acwing.search.dfs;

import java.util.*;

public class NQueen_843 {
    static int n;
    static final int N = 10;

    static Character[][] c;
    static boolean[] col, dg, udg;

    static{
        c = new Character[N][N];
        col = new boolean[N];
        dg = new boolean[N << 1];
        udg = new boolean[N << 1];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                c[i][j] = '.';
            }
        }

        dfs(0);

        sin.close();
    }

    static void dfs(int u){
        if(u == n){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(c[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        for(int i = 0; i < n; i++){
            if(!col[i] && !dg[u + i] && !udg[u - i + n]){
                c[u][i] = 'Q';
                col[i] = dg[u + i] = udg[u - i + n] = true;
                dfs(u + 1);
                c[u][i] = '.';
                col[i] = dg[u + i] = udg[u - i + n] = false;
            }
        }
    }
}
