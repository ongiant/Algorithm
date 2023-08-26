package acwing.middle_level.dp.optimization.slope;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.math.BigInteger;

public class TaskArrangement_II_301 {
    static final int N = 300010;
    static final BigInteger INF = BigInteger.valueOf(Long.MAX_VALUE).pow(2);
    static int n, s, hh, tt;
    static int[] t, c, q;
    static BigInteger[] f;
    static {
        t = new int[N];
        c = new int[N];
        q = new int[N];
        f = new BigInteger[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        s = sin.nextInt();

        for(int i = 1; i <= n; i++){
            t[i] = sin.nextInt();
            t[i] += t[i - 1];
            c[i] = sin.nextInt();
            c[i] += c[i - 1];
        }

        hh = tt = 0;
        q[0] = 0;
        Arrays.fill(f, INF);
        f[0] = BigInteger.ZERO;
        for(int i = 1; i <= n; i++){

                while(hh < tt) {
                    BigInteger df = f[q[hh + 1]].subtract(f[q[hh]]);
                    BigInteger dc = BigInteger.valueOf(c[q[hh + 1]] - c[q[hh]]);
                    BigInteger aux = BigInteger.valueOf(s + t[i]);
                    if(df.compareTo(aux.multiply(dc)) > 0) break;
                    hh ++;
                }

                int j = q[hh];
                BigInteger u = BigInteger.valueOf((long) s * (c[n] - c[j])), v = BigInteger.valueOf(t[i] * (long) (c[i] - c[j]));
                f[i] = f[i].min(f[j].add(u).add(v));


                while(hh < tt) {
                    BigInteger x = f[q[tt]].subtract(f[q[tt - 1]]).multiply(BigInteger.valueOf(c[i] - c[q[tt]]));
                    BigInteger y = f[i].subtract(f[q[tt]]).multiply(BigInteger.valueOf(c[q[tt]] - c[q[tt - 1]]));
                    if(x.compareTo(y) < 0) break;
                    tt --;
                }

                q[++tt] = i;
        }

        System.out.println(f[n]);

        sin.close();
    }
}
