package acwing.dp.backpack;

import java.util.*;

public class Knapsack_0_1_Problem_2 {
    static final int N = 1010;
    static int[] w, v, f;

    static {
        w = new int[N];
        v = new int[N];
        f = new int[N];
    }
    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt(), m = sin.nextInt();
        for(int i=1; i<=n; i++){
            v[i] = sin.nextInt();
            w[i] = sin.nextInt();
        }
        for(int i=1; i<=n; i++){
            for(int j=m; j >= v[i]; j--){
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
