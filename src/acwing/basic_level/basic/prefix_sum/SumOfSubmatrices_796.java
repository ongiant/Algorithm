package acwing.basic_level.basic.prefix_sum;

import java.util.*;
import java.io.*;

public class SumOfSubmatrices_796 {
    static final int N = 10010;

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt(), m = sin.nextInt(), q = sin.nextInt();

        int[][] a = new int[N][N];
        int[][] s = new int[N][N];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                a[i][j] = sin.nextInt();
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + a[i][j];
            }
        }

        while(q-- > 0){
            int x1 = sin.nextInt(), y1 = sin.nextInt(), x2 = sin.nextInt(), y2 = sin.nextInt();
            System.out.println(s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 -1][y1 - 1]);
        }
    }
}
