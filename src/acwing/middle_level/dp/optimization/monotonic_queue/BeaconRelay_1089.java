package acwing.middle_level.dp.optimization.monotonic_queue;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class BeaconRelay_1089 {
    static final int N = 200010, INF = 0x3f3f3f3f;
    static int n, m, hh, tt;
    static int[] w, q, f;
    static{
        w = new int[N];
        q = new int[N];
        f = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        for(int i = 1; i <= n; i++){
            w[i] = sin.nextInt();
        }

        hh = tt= 0;
        for(int i = 1; i <= n; i++){
            if(q[hh] < i - m) hh++;
            f[i] = f[q[hh]] + w[i];
            while(hh <= tt && f[q[tt]] >= f[i]) tt--;
            q[++tt] = i;
        }

        int res = INF;
        for(int i = n - m + 1; i <= n; i++){
            res = Math.min(res, f[i]);
        }
        System.out.println(res);

        sin.close();
    }
}
