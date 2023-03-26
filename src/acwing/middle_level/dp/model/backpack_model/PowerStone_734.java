package acwing.middle_level.dp.model.backpack_model;

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class PowerStone_734 {

    static final int N = 110, M = 10010, INF = 0x3f3f3f3f;
    static int[] f;
    static Stone[] stones;

    static{
        f = new int[M];
        stones = new Stone[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int T = sin.nextInt();
        for(int t = 0; t < T; t ++){
            int n = sin.nextInt();
            int m = 0;
            for(int i = 0; i < n; i ++){
                int s = sin.nextInt(), e = sin.nextInt(), l = sin.nextInt();
                stones[i] = new Stone(s, e, l);
                m += s;
            }

            Arrays.sort(stones, 0, n, (x, y) -> x.s * y.l - y.s * x.l);

            Arrays.fill(f, -INF);
            f[0] = 0;
            for(int i = 0; i < n; i ++){
                int s = stones[i].s, e = stones[i].e, l = stones[i].l;
                for(int j = m; j >= s; j --){
                    f[j] = Math.max(f[j], f[j - s] + Math.max(0, e - (j - s) * l));
                }
            }

            int ans = 0;
            for(int j = 0; j <= m; j ++) ans = Math.max(ans, f[j]);

            System.out.printf("Case #%d: %d\n", t + 1, ans);

        }

        sin.close();
    }

    static class Stone{
        int s, e, l;
        public Stone(int s, int e, int l){
            this.s = s;
            this.e = e;
            this.l = l;
        }
    }
}
