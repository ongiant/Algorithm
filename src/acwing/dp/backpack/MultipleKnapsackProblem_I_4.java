package acwing.dp.backpack;

import java.util.*;
import java.io.*;

public class MultipleKnapsackProblem_I_4 {

    static final int N = 110;

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        int n = sin.nextInt(), m = sin.nextInt();
        int[] f = new int[N];

        for(int i=1; i<=n; i++){
            int v = sin.nextInt(), w = sin.nextInt(), s = sin.nextInt();
            for(int j=m; j>=0; j--){
                for(int k=0; k<=s && k*v<=j; k++){
                    f[j] = Math.max(f[j], f[j - k * v] + k * w);
                }
            }
        }
        System.out.println(f[m]);
    }
}
