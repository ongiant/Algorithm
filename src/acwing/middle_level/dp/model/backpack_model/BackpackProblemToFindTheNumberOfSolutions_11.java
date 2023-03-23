package acwing.middle_level.dp.model.backpack_model;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class BackpackProblemToFindTheNumberOfSolutions_11 {

    static final int mod = 1000000007, N = 1010;
    static int[] f, g;
    static int[] v, w;

    static{
        f = new int[N];
        g = new int[N];
        v = new int[N];
        w = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        int n = sin.nextInt(), m = sin.nextInt();
        for(int i = 1; i <= n; i ++){
            v[i] = sin.nextInt();
            w[i] = sin.nextInt();
        }

        for(int i = 0; i <= m; i ++) g[i] = 1;

        for(int i = 1; i <= n; i ++){
            for(int j = m; j >= v[i]; j --){
                int a = f[j], b = f[j - v[i]] + w[i];
                if(a < b){
                    f[j] = b;
                    g[j] = g[j - v[i]];
                }
                else if(a == b){
                    f[j] = b;
                    g[j] += g[j - v[i]];
                }
                g[j] %= mod;
            }
        }
        System.out.println(g[m]);
        sin.close();
    }
}
