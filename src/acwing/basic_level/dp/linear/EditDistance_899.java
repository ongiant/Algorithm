package acwing.basic_level.dp.linear;

import java.io.*;
import java.util.*;

public class EditDistance_899 {

    static final int N = 15;
    static int[][] f;
    static String[] ss;
    static {
        f = new int[N][N];
    }

    static int compute(String s, int x){
        int ret = 0;
        for (String value : ss) {

            for(int i=0; i<N; i++){
                Arrays.fill(f[i], 0);
            }

            for(int i=1; i<N; i++) {
                f[i][0] = i;
                f[0][i] = i;
            }

            int n = value.length(), m = s.length();
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    f[j][k] = Math.min(f[j - 1][k] + 1, f[j][k - 1] + 1);
                    if (value.charAt(j - 1) == s.charAt(k - 1)) {
                        f[j][k] = Math.min(f[j][k], f[j - 1][k - 1]);
                    } else {
                        f[j][k] = Math.min(f[j][k], f[j - 1][k - 1] + 1);
                    }
                }
            }
            if (f[n][m] <= x) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);

        ss = new String[n];
        for(int i=0; i<n; i++){
            ss[i] = br.readLine();
        }

        while(m-- > 0) {
            s = br.readLine().split(" ");
            System.out.println(compute(s[0], Integer.parseInt(s[1])));
        }
        br.close();
    }
}
