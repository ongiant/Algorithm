package acwing.dp.memoization;

import java.util.*;

public class Skiing_901 {
    static final int N = 310;
    static int r, c;
    static final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] h, f;

    static{
        h = new int[N][N];
        f = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        r = sin.nextInt();
        c = sin.nextInt();
        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                h[i][j] = sin.nextInt();
            }
        }

        for(int i=1; i<=r; i++){
            Arrays.fill(f[i], -1);
        }

        int ans = 0;
        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                ans = Math.max(ans, dp(i, j));
            }
        }
        System.out.println(ans);

        sin.close();
    }

    static int dp(int x, int y){
        if(f[x][y] != -1){
            // 这一步少了就不是记忆化搜索了
            return f[x][y];
        }
        f[x][y] = 1;
        for(int i=0; i<4; i++){
            int a = x + dx[i], b = y + dy[i];
            if(a>=1 && a<=r && b>=1 && b<=c && h[x][y]>h[a][b]){
                f[x][y] = Math.max(f[x][y], dp(a, b) + 1);
            }
        }
        return f[x][y];
    }
}
