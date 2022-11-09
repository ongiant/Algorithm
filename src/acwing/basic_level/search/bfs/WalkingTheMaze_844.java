package acwing.basic_level.search.bfs;

import java.util.*;

public class WalkingTheMaze_844 {
    static int n, m;
    static final int N = 110;
    static int[][] g, d;
    static Pair[] q;

    static {
        g = new int[N][N];
        d = new int[N][N];
        q = new Pair[N * N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        n = sin.nextInt();
        m = sin.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                g[i][j] = sin.nextInt();
                d[i][j] = -1;
            }
        }

        System.out.println(bfs());
        sin.close();
    }

    static int bfs(){
        int hh = 0, tt = 0;
        int [] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

        q[0] = new Pair(0, 0);
        d[0][0] = 0;
        while(hh <= tt){
            Pair p = q[hh++];
            for(int i = 0; i < 4; i++){
                int x = p.first + dx[i], y = p.second + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1){
                    d[x][y] = d[p.first][p.second] + 1;
                    q[++tt] = new Pair(x, y);
                }
            }
        }
        return d[n - 1][m - 1];
    }

    static class Pair{
        int first;
        int second;
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }
}
