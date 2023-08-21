package acwing.middle_level.dp.tree;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class LongestPathInTree_1072 {

    static final int N = 10010 << 1, INF = 0x3f3f3f3f;
    static int n, idx, ans;
    static int[] h, e, w, ne;
    static{
        h = new int[N];
        e = new int[N];
        w = new int[N];
        ne = new int[N];

        ans = -INF;
        Arrays.fill(h, -1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        for(int i = 1; i < n; i++){
            int a = sin.nextInt(), b = sin.nextInt(), weight = sin.nextInt();
            add(a, b, weight);
            add(b, a, weight);
        }

        dfs(1, -1);

        System.out.println(ans);

        sin.close();
    }

    static int dfs(int a, int father){
        int d1 = 0, d2 = 0;
        for(int i = h[a]; i != -1; i = ne[i]){
            int b = e[i];
            if(b == father) continue;
            int d = dfs(b, a) + w[i];
            if(d >= d1){
                d2 = d1;
                d1 = d;
            }
            else if(d > d2){
                d2 = d;
            }
        }
        ans = Math.max(ans, d1 + d2);
        return d1;
    }

    static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
