package acwing.middle_level.dp.optimization.monotonic_queue;
import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TravelProblem_1088 {
    static final int N = (1000 * 1000 + 10) << 1;
    static int n, hh, tt;
    static int[] p, d, q;
    static long[] s;
    static boolean[] ans;
    static{
        p = new int[N];
        d = new int[N];
        s = new long[N];
        q = new int[N];
        ans = new boolean[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        n = sin.nextInt();
        for(int i = 1; i <= n; i++){
            p[i + n] = p[i] = sin.nextInt();
            d[i + n] = d[i] = sin.nextInt();
        }

        // clockwise
        for(int i = 1; i <= 2 * n; i ++){
            s[i] = p[i] - d[i] + s[i - 1];
        }

        hh = 0;
        tt = 0;
        for(int i = 1; i <= 2 * n; i++){
            if(i <= n){
                offer(i);
            }
            else{
                // handle the window of which the length is n before i
                // i.e. the window is [i-n, i-n+1, ... ,i-1]
                long minimum = s[q[hh]] - s[i - n - 1];
                ans[i - n] = minimum >= 0;
                if(q[hh] <= i - n) hh++;
                offer(i);
            }
        }

        // anticlockwise(i.e. counterclockwise)

        /**
         * map index:
         * index:[     1, ...,  n-1,    n,    n+1, ..., 2n-1, 2n]
         *     p:[  p[n], ..., p[2], p[1],   p[n], ..., p[2], p[1]]
         *     d:[d[n-1], ..., d[1], d[n], d[n-1], ..., d[1], d[n]]
         */
        for(int i = 1; i <= n; i++){
            s[i + n] = s[i] = i == n ? p[n + 1 - i] - d[n] : p[n + 1 - i] - d[(n + 1 - i) - 1];
        }
        for(int i = 1; i <= 2 * n; i++){
            s[i] += s[i - 1];
        }

        hh = tt = 0;
        for(int i = 1; i <= 2 * n; i++){
            if(i <= n){
                offer(i);
            }
            else{
                long minimum = s[q[hh]] - s[i - n - 1];
                ans[n + 1 - (i - n)] = ans[n + 1 - (i - n)] || minimum >= 0;
                if(q[hh] <= i - n) hh++;
                offer(i);
            }
        }

        for(int i = 1; i <= n; i++){
            pw.println(ans[i] ? "TAK" : "NIE");
        }

        sin.close();
        pw.close();
    }

    // insert index to monotonic queue
    static void offer(int index){
        while(hh <= tt && s[q[tt]] >= s[index]) tt--;
        q[++tt] = index;
    }
}
