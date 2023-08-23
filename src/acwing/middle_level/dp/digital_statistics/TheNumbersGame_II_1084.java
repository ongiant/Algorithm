package acwing.middle_level.dp.digital_statistics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheNumbersGame_II_1084 {
    static final int N = 15, M = 110;
    static int L, R, P, cnt;
    static int[] d;
    static int[][][] f;
    static{
        d = new int[N];
        f = new int[N][10][M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while((input = br.readLine()) != null){
            String[] nums = input.split("\\s");
            L = Integer.parseInt(nums[0]);
            R = Integer.parseInt(nums[1]);
            P = Integer.parseInt(nums[2]);

            init();

            System.out.println(dp(R) - dp(L - 1));
        }

        br.close();
    }

    static int dp(int n){
        if(n == 0) return 1;

        cnt = 0;
        while (n > 0){
            d[cnt++] = n % 10;
            n /= 10;
        }

        int res = 0, last = 0;
        for(int i = cnt - 1; i >= 0; i--){
            int x = d[i];
            for(int j = 0; j < x; j++){
                res += f[i + 1][j][mod(- last, P)];
            }
            last += x;
            if(i == 0 && mod(last, P) == 0) res ++;
        }
        return res;
    }

    static void init(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= 9; j++){
                Arrays.fill(f[i][j], 0);
            }
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j <= 9; j++){
                if(i == 1) f[i][j][j % P] ++;
                else{
                    for(int k = 0; k < P; k++){
                        for(int x = 0; x <= 9; x++){
                            f[i][j][k] += f[i - 1][x][mod(k - j, P)];
                        }
                    }
                }
            }
        }
    }

    static int mod(int x, int y){
        return (x % y + y) % y;
    }
}
