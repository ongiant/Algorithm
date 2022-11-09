package acwing.basic_level.dp.linear;

import java.util.*;

public class LongestAscendingSubsequence_895 {

    static final int N = 1010;
    static int[] a, f;

    static {
        a = new int[N];
        f = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        for(int i=0; i<n; i++){
            a[i] = sin.nextInt();
            f[i] = 1;
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(a[j]  < a[i]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }

        System.out.println(ans);
        sin.close();
    }
}
