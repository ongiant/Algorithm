package acwing.dp.linear;

import java.io.*;

public class LongestCommonSubsequence_897 {

    static final int N = 1010;
    static int[][] f;
    static {
        f = new int[N][N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        String s1 = br.readLine(), s2 = br.readLine();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
