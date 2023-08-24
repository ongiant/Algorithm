package acwing.middle_level.dp.optimization.monotonic_queue;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class GreenChannel_1090 {
    static final int N = 50010;
    static int hh, tt, n, t;
    static int[] w, q, f;
    static{
        w = new int[N];
        q = new int[N];
        f = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        t = sin.nextInt();

        for(int i = 1; i <= n; i++){
            w[i] = sin.nextInt();
        }

        int L = 0, R = n;
        while(L < R){
            int mid = L + R >> 1;
            if(check(mid)) R = mid;
            else L = mid + 1;
        }

        System.out.println(R);

        sin.close();
    }

    static boolean check(int len){
        hh = tt= 0;
        for(int i = 1; i <= n; i++){
            if(q[hh] < i - len - 1) hh++;
            f[i] = f[q[hh]] + w[i];
            while(hh <= tt && f[q[tt]] >= f[i]) tt--;
            q[++tt] = i;
        }

        for(int i = n - len; i <= n; i++){
            if(f[i] <= t) return true;
        }
        return false;
    }
}
