package acwing.graph.dijkstra;

import java.util.*;
import java.io.*;

public class DijkstraForShortestPath_I_849 {

    static int n, m;
    static final int N = 510, INF = 0x3f3f3f3f;
    static int[][] g;
    static boolean[] st;
    static int[] dist;

    static{
        g = new int[N][N];
        st = new boolean[N];
        dist = new int[N];

        for(int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }

        Arrays.fill(dist, INF);
        dist[1] = 0;
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        while(m-- > 0){
            int a = sin.nextInt(), b = sin.nextInt(), c = sin.nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }

        int r = dijkstra();
        System.out.println(r);

        sin.close();
    }

    static int dijkstra(){
        for(int i = 0; i < n; i++){
            int x = -1, m = INF; // 此处参考的《算法竞赛入门经典》359页的代码实现
            for(int y = 1; y <= n; y++){
                if(!st[y] && dist[y] <= m){ // 若所有未确定最短距离的点的dist均为INF，那么<=号可保证此种情况下x也能被正确更新
                    m = dist[x = y];
                }
            }
            st[x] = true;
            for(int y = 1; y <= n; y++){
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);// 此处可知当x等于y时，并且自环边的权值为非负时，则自环不会影响算法的正确性
            }
        }
        return dist[n] == INF ? -1 : dist[n];
    }
}
