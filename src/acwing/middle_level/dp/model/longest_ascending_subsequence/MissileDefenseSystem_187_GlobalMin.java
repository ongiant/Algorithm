package acwing.middle_level.dp.model.longest_ascending_subsequence;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class MissileDefenseSystem_187_GlobalMin {

    static final int N = 60;
    static int n, su, sd, res;
    static int[] a, up, down;
    static {
        a = new int[N];
        up = new int[N];
        down = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        while((n = sin.nextInt()) != 0){
            for(int i = 0; i < n; i ++){
                a[i] = sin.nextInt();
            }

            res = n;
            dfs(0, 0, 0);
            System.out.println(res);
        }

        sin.close();
    }

    static void dfs(int u, int su, int sd){
        if(su + sd >= res) return;
        if(u == n) {
            res = su + sd;
            return;
        }
        boolean flag = false;
        for(int i = 0; i < su; i ++){
            if(up[i] < a[u]) {
                flag = true;
                int t = up[i];
                up[i] = a[u];
                dfs(u + 1, su, sd);
                up[i] = t;
                break;
            }
        }
        if(!flag){
            int t = up[su];
            up[su] = a[u];
            dfs(u + 1, su + 1, sd);
            up[su] = t;
        }

        flag = false;
        for(int i = 0; i < sd; i ++){
            if(down[i] > a[u]){
                flag = true;
                int t = down[i];
                down[i] = a[u];
                dfs(u + 1, su, sd);
                down[i] = t;
                break;
            }
        }
        if(!flag){
            int t = down[sd];
            down[sd] = a[u];
            dfs(u + 1, su, sd + 1);
            down[sd] = t;
        }
    }
}
