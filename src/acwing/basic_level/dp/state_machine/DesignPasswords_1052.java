package acwing.basic_level.dp.state_machine;

import java.io.*;
import java.util.*;

public class DesignPasswords_1052 {

    final static int N = 60, mod = 1000000000 + 7;

    static int[] next;
    static int[][] f;

    static {
        next = new int[N];
        f = new int[N][N];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String p = br.readLine();
        int m = p.length();
        p = " " + p;

        Arrays.fill(next, 0);
        for(int i = 2, j = 0; i <= m; i++){
            while(j > 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];
            if(p.charAt(i) == p.charAt(j + 1)) j++;
            next[i] = i == m || p.charAt(i + 1) != p.charAt(j + 1) ? j : next[j];
        }

        f[0][0] = 1;
        for(int i = 0; i < n; i++){// i从0开始是因为我们用k枚举第i+1个字符进行Kmp匹配过程，密码的下标从1开始
            /**
             * 1、 由于我们不知道kmp算法匹配的时候哪些j能跳到，所以直接枚举所有的j，并假设：密码s[i-j+1 ~ i]与模式串t[1 ~ j]匹配。
             *     这个假设不影响计算结果的正确性。因为假设不成立时，f[i][j]的值就是0，从而f[i+1][u]也是0。
             *     即f数组中会有一些不可达状态，f[i][j]=0表示枚举密码的第i个字符时，模式串指针跳到j的方案数为0
             * 2、循环顺序：先是当前枚举到密码的第i个字符，然后枚举j是因为我们要看“密码s[i-j+1 ~ i]与模式串t[1 ~ j]匹配”时，j能跳到哪。
             *    然后密码的第i+1个字符决定了j能跳到哪个位置，因此最后枚举密码的第i+1个字符。
             */
            for(int j = 0; j < m; j++){
                for(char k = 'a'; k <= 'z'; k++){
                    int u = j;
                    while(u > 0 && k != p.charAt(u + 1)) u = next[u];
                    if(k == p.charAt(u + 1)) u++;
                    if(u < m){
                        f[i + 1][u] = (f[i + 1][u] + f[i][j]) % mod;
                    }
                }
            }
        }
        int ans = 0;
        for(int j = 0; j < m; j++){
            ans = (ans + f[n][j]) % mod;
        }
        System.out.println(ans);
    }
}
