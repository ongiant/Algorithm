package acwing.dp.state_compression;

import java.io.*;
import java.util.*;

public class MondriansDream_291 {

    static final int N = 12;

    static boolean[] st;
    static long[][] f;

    static {
        st = new boolean[1<<N];
        f = new long[N][1 << N];
    }

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;
        while((n = sin.nextInt()) != 0 && (m = sin.nextInt()) != 0){

            for(int i=0; i< 1<<n; i++){
                int cnt = 0, has_odd = 0;

                for(int k=0; k<n; k++){ // k必须严格小于n，因为i最多为n-1位数字
                    if((i>>k & 1) == 1){
                        has_odd |= cnt;
                        cnt = 0;
                    }
                    else{
                        cnt ^= 1;
                    }
                }
                st[i] = (has_odd | cnt) != 1;
            }

            /**
             * 关于f[0][0] = 1 目前没有想到一个清晰直观的解释
             */
            f[0][0] = 1; // 第0列状态为0时，前0列的分割方案总数，第0列作为棋盘的第一列
            for(int i=1; i<=m; i++){
                for(int j=0; j< 1<<n; j++){
                    f[i][j] = 0;
                    for(int k=0; k < 1<<n; k++){
                        if((j & k) == 0 && st[j | k]){
                            f[i][j] += f[i - 1][k];
                        }
                    }

                }
            }
            bw.write(f[m][0] + "\n"); // 此处可以得知，我们的最后一列是第m-1列
        }

        bw.flush();
        sin.close();
        bw.close();
    }
}
