package acwing.middle_level.dp.digital_statistics;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class DoNotSixtyTwo_1085 {
    static final int N = 15;
    static int L, R, cnt;
    static int[] d;
    static int[][] f;
    static{
        d = new int[N];
        f = new int[N][N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        init();

        while((L = sin.nextInt()) != 0 && (R = sin.nextInt()) != 0){
            System.out.println(dp(R) - dp(L - 1));
        }

        sin.close();
    }

    static int dp(int n){
        if(n == 0) return 1;

        cnt = 0;
        while(n > 0) {
            d[cnt++] = n % 10;
            n /= 10;
        }

        int res = 0, last = 0;
        for(int i = cnt - 1; i >= 0; i--){
            int x = d[i];
            for(int j = 0; j < x; j++){
                if(j == 4 || last == 6 && j == 2) continue;
                res += f[i + 1][j];
            }

            if(x == 4 || last == 6 && x == 2) break;
            last = x;
            if(i == 0) res ++;
        }
        return res;
    }

    static void init(){
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= 9; j++){
                if(j == 4) continue;
                if(i == 1){
                    f[i][j] = 1;
                }else{
                    for(int k = 0; k <= 9; k++){
                        if(k == 4 || j == 6 && k == 2) continue;
                        f[i][j] += f[i - 1][k];
                    }
                }
            }
        }
    }
}
