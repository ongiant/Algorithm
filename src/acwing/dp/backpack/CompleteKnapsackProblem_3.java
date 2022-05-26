package acwing.dp.backpack;

import java.util.*;

public class CompleteKnapsackProblem_3 {
    static final int N = 1010;
    static int[] v, w, f;

    static {
        v = new int[N];
        w = new int[N];
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
            for(int j=v[i]; j<=m; j++){
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
