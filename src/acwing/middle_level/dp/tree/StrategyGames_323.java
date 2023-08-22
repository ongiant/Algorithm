package acwing.middle_level.dp.tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStreamReader;

public class StrategyGames_323 {

    static final int N = 1510;
    static int n, idx;
    static int[] h, e, ne;
    static boolean[] st;
    static int[][] f;
    static{
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        st = new boolean[N];
        f = new int[N][2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader jin = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String sn = jin.readLine();
            if(null == sn) break;

            n = Integer.parseInt(sn);

            init();
            for(int t = 0; t < n; t++){
                String[] a = jin.readLine().split("[:()\\s]+");

                int p = Integer.parseInt(a[0]);
                for(int i = 2; i < a.length; i++){
                    int son = Integer.parseInt(a[i]);
                    add(p, son);
                    st[son] = true;
                }
            }
            int root = 0;
            for(int i = 0; i < n; i++){
                if(!st[i]){
                    root = i;
                    break;
                }
            }

            dfs(root);
            System.out.println(Math.min(f[root][0], f[root][1]));
        }
        jin.close();
    }

    static void dfs(int root){
        f[root][0] = 0;
        f[root][1] = 1;
        for(int i = h[root]; i != -1; i = ne[i]){
            int son = e[i];
            dfs(son);
            f[root][0] += f[son][1];
            f[root][1] += Math.min(f[son][0], f[son][1]);
        }
    }

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void init(){
        idx = 0;
        Arrays.fill(h, -1);
        Arrays.fill(st, false);
    }
}
