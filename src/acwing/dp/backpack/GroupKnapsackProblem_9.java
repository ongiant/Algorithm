package acwing.dp.backpack;

import java.io.*;
import java.util.*;

public class GroupKnapsackProblem_9 {

    static final int N = 110;
    static int[] f, s, v, w;

    static {
        f = new int[N];
        s = new int[N];
        v = new int[N];
        w = new int[N];
    }
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        int n = sin.nextInt(), m = sin.nextInt();

        for(int i=1; i<=n; i++){
            s[i] = sin.nextInt();
            for(int k=1; k<=s[i]; k++){
                v[k] = sin.nextInt();
                w[k] = sin.nextInt();
            }

            for(int j=m; j>=0; j--){
                for(int k=0; k<=s[i]; k++){
                    if(j >= v[k]){
                        f[j] = Math.max(f[j], f[j - v[k]] + w[k]);
                    }
                }
            }
        }

        System.out.println(f[m]);
    }
}
