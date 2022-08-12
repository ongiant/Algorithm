package acwing.graph.floyd;

import java.io.*;
import java.util.*;

public class FloydShortestPath_854 {

    static int n, m, q;
    static final int N = 210, INF = 0x3f3f3f3f;
    static int[][] d;

    static{
        d = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        n = sin.nextInt();
        m = sin.nextInt();
        q = sin.nextInt();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }

        while(m -- > 0){
            int a = sin.nextInt(), b = sin.nextInt(), w = sin.nextInt();
            if(a == b) continue;
            d[a][b] = Math.min(d[a][b], w);
        }

        floyd();
        while(q -- > 0){
            int x = sin.nextInt(), y = sin.nextInt();
            if(d[x][y] > INF / 2) System.out.println("impossible");
            else System.out.println(d[x][y]);
        }

        sin.close();
    }

    static void floyd(){
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}
