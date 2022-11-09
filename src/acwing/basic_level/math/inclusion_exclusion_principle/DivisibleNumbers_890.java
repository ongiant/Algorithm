package acwing.basic_level.math.inclusion_exclusion_principle;

import java.util.Scanner;

public class DivisibleNumbers_890 {

    static final int N = 20;
    static int n, m;

    static int[] p;

    static {
        p = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        m = sin.nextInt();

        for(int i = 0; i < m; i ++) p[i] = sin.nextInt();

        int ans = 0;
        for(int i = 1; i < 1 << m; i ++){
            int cnt = 0;
            long t = 1;
            for(int j = 0; j < m; j ++){
                if((i >> j & 1) == 1){
                    cnt ++;
                    t *= p[j];
                    if(t > n) break;
                }
            }
            if((cnt & 1) == 1) ans += n / t;
            else ans -= n / t;
        }

        System.out.println(ans);
        sin.close();
    }
}
