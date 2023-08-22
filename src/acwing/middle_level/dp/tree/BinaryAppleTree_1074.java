package acwing.middle_level.dp.tree;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryAppleTree_1074 {
    static final int N = 110, M = N << 1;
    static int n, m, idx;
    static int[] h, e, w, ne;
    static int[][] f;
    static{
        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[M];
        ne = new int[M];
        w = new int[M];
        f = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        m = sin.nextInt();
        for(int i = 1; i < n; i++){
            int a = sin.nextInt(), b = sin.nextInt(), c = sin.nextInt();
            add(a, b, c);
            add(b, a, c);
        }

        for(int j = 1; j <= m; j++) f[1][j] = 0;
        dfs(1, -1, 0);

        System.out.println(f[1][m]);

        sin.close();
    }

    static void dfs(int x, int father, int vsum){
        if(vsum > m) return;
        for(int i = h[x]; i != -1; i = ne[i]){
            int y = e[i];
            if(y == father) continue;
            for(int j = vsum + 1; j <= m; j++){
                f[y][j] = f[x][j - 1] + w[i];
            }
            dfs(y, x, vsum + 1);
            for(int j = vsum + 1; j <= m; j++){
                f[x][j] = Math.max(f[x][j], f[y][j]);
            }
        }
    }

    static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
