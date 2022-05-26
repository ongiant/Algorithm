package acwing.dp.linear;

import java.util.*;

public class DigitalTriangle_898 {

    static final int N = 510;
    static int[][] f;

    static {
        f = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                f[i][j] = sin.nextInt();
            }
        }

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                f[i][j] += Math.max(f[i + 1][j], f[i + 1][j + 1]);
            }
        }
        System.out.println(f[0][0]);
        sin.close();
    }
}
