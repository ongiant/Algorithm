package acwing.middle_level.dp.model.backpack_model;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class BudgetPlanOfJinMing_487 {

    static final int N = 65, V = 32010;
    static int[] f[], v, w;

    static int idx;
    static int[] h, e, ne;
    static int n, m;

    static{
        f = new int[N][V];
        v = new int[N];
        w = new int[N];

        h = new int[N];
        e = new int[N];
        ne = new int[N];
        Arrays.fill(h, -1);
    }
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        m = sin.nextInt();
        n = sin.nextInt();

        for(int i = 1; i <= n; i++){
            v[i] = sin.nextInt();
            w[i] = v[i] * sin.nextInt();

            insert(i, sin.nextInt());
        }

        dfs(0, 0);

        System.out.println(f[0][m]);

        sin.close();
    }

    static void dfs(int root, int vsum){
        if(vsum > m) return;

        for(int i = h[root]; i != -1; i = ne[i]){
            int son = e[i];
            for(int j = vsum + v[son]; j <= m; j++){
                f[son][j] = f[root][j - v[son]] + w[son];
            }
            dfs(son, vsum + v[son]);
            for(int j = vsum + v[son]; j <= m; j++){
                f[root][j] = Math.max(f[root][j], f[son][j]);
            }
        }
    }

    static void insert(int number, int parent){
        e[idx] = number;
        ne[idx] = h[parent];
        h[parent] = idx++;
    }
}
