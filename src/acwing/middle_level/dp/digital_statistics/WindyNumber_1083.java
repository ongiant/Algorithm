package acwing.middle_level.dp.digital_statistics;

import java.util.Scanner;

public class WindyNumber_1083 {
    static final int N = 15;
    static int L, R, cnt;
    static int[] d;
    static int[][] f;
    static{
        d = new int[N];
        f = new int[N][N];
    }
    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        init();

        L = sin.nextInt();
        R = sin.nextInt();

        System.out.println(dp(R) - dp(L - 1));

        sin.close();
    }

    static int dp(int n){
        // zero is not Windy number
        if(n == 0) return 0;

        cnt = 0;
        while(n > 0){
            d[cnt++] = n % 10;
            n /= 10;
        }

        int res = 0, last = -1;
        for(int i = cnt - 1; i >= 0; i--){
            int x = d[i];
            for(int j = i == cnt - 1 ? 1 : 0; j < x; j++){
                if(Math.abs(j - last) >= 2){
                    res += f[i + 1][j];
                }
            }
            if(Math.abs(x - last) < 2) break;
            last = x;
            if(i == 0) res ++;
        }

        for(int i = 1; i < cnt; i++){
            for(int j = 1; j <= 9; j++){
                res += f[i][j];
            }
        }

        return res;
    }

    static void init(){
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= 9; j++){
                if(i == 1) f[i][j] = 1;
                else{
                    for(int k = 0; k <= 9; k++){
                        if(Math.abs(j - k) >= 2){
                            f[i][j] += f[i - 1][k];
                        }
                    }
                }
            }
        }
    }
}
