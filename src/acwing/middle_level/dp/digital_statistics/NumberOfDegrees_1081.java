package acwing.middle_level.dp.digital_statistics;
import java.util.Scanner;
import java.util.LinkedList;

public class NumberOfDegrees_1081 {
    static final int N = 35;
    static int X, Y, K, B;
    static int[][] c;
    static{
        c = new int[N][N];
        init();
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        X = sin.nextInt();
        Y = sin.nextInt();
        K = sin.nextInt();
        B = sin.nextInt();

        System.out.println(dp(Y) - dp(X - 1));

        sin.close();
    }

    static int dp(int n){
        LinkedList<Integer> list = new LinkedList<>();
        while(n > 0){
            list.push(n % B);
            n /= B;
        }

        int res = 0, last = 0;
        n = list.size();
        for(Integer x : list){
            n --;

            if(x > 0){
                res += c[n][K - last];
                if(x > 1){
                    if(K - last - 1 > 0) res += c[n][K - last - 1];
                    break;
                }
                else{
                    last ++;
                    if(last > K) break;
                }
            }
            if(n == 0 && last == K) res ++;
        }
        return res;
    }

    static void init(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0) c[i][j] = 1;
                else c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
            }
        }
    }
}
