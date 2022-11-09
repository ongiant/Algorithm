package acwing.basic_level.basic.prefix_sum;

import java.util.*;
import java.io.*;

public class PrefixSum_795 {
    static final int N = 100010;

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

//        int[][] a = new int[N][N];
        int[] s = new int[N];

        int n = sin.nextInt(), m = sin.nextInt();
        for(int i=1; i<=n; i++){
            s[i] = s[i-1] + sin.nextInt();
        }

        while(m-- > 0){
            int l = sin.nextInt(), r = sin.nextInt();
            System.out.println(s[r] - s[l-1]);
        }
    }
}
