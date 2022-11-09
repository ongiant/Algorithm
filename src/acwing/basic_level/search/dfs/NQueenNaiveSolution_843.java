package acwing.basic_level.search.dfs;

import java.util.*;

public class NQueenNaiveSolution_843 {
    static int n;
    static final int N = 10;
    static Character[][] c;
    static boolean[] row, col, dg, udg;

    static{
        c = new Character[N][N];
        row = new boolean[N];
        col = new boolean[N];
        dg = new boolean[N << 1];
        udg = new boolean[N << 1];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();

        dfs(0, 0, 0);
    }

    static void dfs(int x, int y, int s){
        if(y == n){
            y = 0;
            x++;
        }

        if(x == n){
            if(s == n){
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        System.out.print(c[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }

        // 不放皇后
        c[x][y] = '.';
        dfs(x, y + 1, s);

        // 放皇后
        if(!row[x] && !col[y] && !dg[x + y] && !udg[x - y + n]){
            c[x][y] = 'Q';
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = true;
            dfs(x, y + 1, s + 1);
            c[x][y] = '.';
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = false;
        }
    }
}
