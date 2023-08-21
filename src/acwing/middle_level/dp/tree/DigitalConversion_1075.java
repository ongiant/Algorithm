package acwing.middle_level.dp.tree;
import java.util.Arrays;
import java.util.Scanner;

public class DigitalConversion_1075 {
    static final int N = 50010;
    static int n, idx, ans;
    static int[] h, e, ne, sum;
    static boolean[] st;
    static {
        h = new int[N];
        Arrays.fill(h, -1);

        e = new int[N];
        ne = new int[N];
        sum = new int[N];
        st = new boolean[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 2; j <= n / i; j++){
                sum[i * j] += i;
            }
        }

        for(int i = 2; i <= n; i++){
            if(sum[i] < i){
                add(sum[i], i);
                st[i] = true;
            }
        }

        for(int i = 1; i <= n; i++){
            if(!st[i]){
                dfs(i);
            }
        }

        System.out.println(ans);

        sin.close();
    }

    static int dfs(int x){
        int d1 = 0, d2 = 0;
        for(int i = h[x]; i != -1; i = ne[i]){
            int y = e[i];
            int d = dfs(y) + 1;
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

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
