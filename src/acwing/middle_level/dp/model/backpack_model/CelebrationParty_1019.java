package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class CelebrationParty_1019 {

    static final int N = 2000, M = 6010;
    static int[] v, w, f;
    static int n, m, cnt;

    static {
        v = new int[N];
        w = new int[N];
        f = new int[M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();

        for(int i = 1; i <= n; i ++){
            int a = sin.nextInt(), b = sin.nextInt(), s = sin.nextInt();
            int k = 1;
            while(k <= s){
                cnt ++;
                v[cnt] = k * a;
                w[cnt] = k * b;
                s -= k;
                k <<= 1;
            }
            if(s > 0){
                cnt ++;
                v[cnt] = s * a;
                w[cnt] = s * b;
            }
        }
        for(int i = 1; i <= cnt; i ++){
            for(int j = m; j >= v[i]; j --){
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);

        sin.close();
    }
}
