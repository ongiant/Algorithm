package acwing.middle_level.dp.model.longest_ascending_subsequence;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class MissileDefenseSystem_187_IterativeDeepening {

    static final int N = 55;
    static int n;
    static int[] a, up, down;
    static {
        a = new int[N];
        up = new int[N];
        down = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        while((n = sin.nextInt()) != 0){
            for(int i = 0; i < n; i ++) a[i] = sin.nextInt();
            int total = 0;
            while(!dfs(total, 0, 0, 0)) total ++;
            System.out.println(total);
        }
        sin.close();
    }

    static Boolean dfs(Integer total, Integer u, Integer su, Integer sd){
        if(su + sd > total) return false;
        if(u == n) return true;

        boolean flag = false;
        for(int i = 0; i < su; i ++){
            if(up[i] < a[u]){
                int t = up[i];
                up[i] = a[u];
                if(dfs(total, u + 1, su, sd)) return true;
                up[i] = t;
                flag = true;
                break;
            }
        }
        if(!flag){
            int t = up[su];
            up[su] = a[u];
            if(dfs(total, u +  1, su + 1, sd)) return true;
            up[su] = t;
        }

        flag = false;
        for(int i = 0; i < sd; i ++){
            if(down[i] > a[u]){
                int t = down[i];
                down[i] = a[u];
                if(dfs(total, u + 1, su, sd)) return true;
                down[i] = t;
                flag = true;
                break;
            }
        }
        if(!flag){
            int t = down[sd];
            down[sd] = a[u];
            if(dfs(total, u + 1, su, sd + 1)) return true;
            down[sd] = t;
        }

        return false;
    }
}
