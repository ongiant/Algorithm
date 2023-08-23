package acwing.middle_level.dp.digital_statistics;
import java.io.*;

public class NumbersGame_1082 {
    static final int N = 15;
    static int L, R, cnt;
    static int[] d;
    static int[][] f;
    static {
        d = new int[N];
        f = new int[N][N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        init();

        String input;
        while((input = br.readLine()) != null){
            String[] nums = input.split(" ");
            L = Integer.parseInt(nums[0]);
            R = Integer.parseInt(nums[1]);

            pw.println(dp(R) - dp(L - 1));
            pw.flush();
        }

        br.close();
        pw.close();
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
            if(x < last) break;
            for(int j = last; j < x; j++){
                res += f[i + 1][j];
            }
            last = x;
            if(i == 0) res ++;
        }
        return res;
    }

    static void init(){
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= 9; j++){
                if(i == 1) f[i][j] = 1;
                else {
                    for(int k = j; k <= 9; k++){
                        f[i][j] += f[i - 1][k];
                    }
                }
            }
        }
    }
}
