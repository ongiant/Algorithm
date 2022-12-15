package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class MixedKnapsackProblem_7 {

    static final int M = 1010;
    static int n, m;
    static int[] f;
    static int hh, tt, q[];

    static {
        f = new int[M];
        q = new int[M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();

        for(int i = 1; i <= n; i ++){
            int v = sin.nextInt(), w = sin.nextInt(), s = sin.nextInt();
            if(s == 0){
                for(int j = v; j <= m; j ++){
                    f[j] = Math.max(f[j], f[j - v] + w);
                }
            }
            else{
                if(s == -1) s = 1;
                // 单调队列优化多重背包这部分计算
                for(int r = 0; r < v;  r ++){
                    hh = 0;
                    tt = -1;
                    int mx = (m - r) / v;
                    for(int j = mx - 1; j >= Math.max(mx - s, 0); j --){
                        while(hh <= tt && calc(r, q[tt], v, w) <= calc(r, j, v, w)) tt --;
                        q[++ tt] = j;
                    }
                    for(int p = mx; p >= 0; p --){
                        while(hh <= tt && q[hh] > p - 1) hh ++;
                        if(hh <= tt){
                            f[r + p * v] = Math.max(f[r + p * v], calc(r, q[hh], v, w) + p * w);
                        }
                        int next = p - s - 1;
                        if(next >= 0){
                            while(hh <= tt && calc(r, q[tt], v, w) <= calc(r, next, v, w)) tt --;
                            q[++ tt] = next;
                        }
                    }
                }

            }
        }
        System.out.println(f[m]);

        sin.close();
    }

    static int calc(int r, int k, int v, int w){
        return f[r + k * v] - k * w;
    }
}
