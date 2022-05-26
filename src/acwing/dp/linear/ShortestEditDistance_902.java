package acwing.dp.linear;

import java.io.*;

public class ShortestEditDistance_902 {
    static final int N = 1010;
    static int[][] f;

    static {
        f = new int[N][N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s1 = br.readLine();

        int m = Integer.parseInt(br.readLine().trim());
        String s2 = br.readLine();

        for(int i=1; i<=n; i++) f[i][0] = i;
        for(int i=1; i<=m; i++) f[0][i] = i;

        for(int i = 1; i<=n; i++){
            for(int j=1; j<=m; j++){
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                }
                else{
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(f[n][m]);
        br.close();
    }
}
