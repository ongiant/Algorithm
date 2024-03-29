package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class TheMultipleKnapsackProblem_III_6 {

    static final int M = 20010;
    static int n, m;
    static int v, w, s;
    static int[] f, q;
    static{
        f = new int[M];
        q = new int[M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();

        // 不用初始化，因为对于前0种物品，任意背包体积所能获得的最大价值就是0
        for(int i = 1; i <= n; i ++){
            v = sin.nextInt();
            w = sin.nextInt();
            s = sin.nextInt();
            for(int r = 0; r < v; r ++){
                int hh = 0, tt = -1, maxk = (m - r) / v;
                for(int j = maxk - 1; j >= Math.max(maxk - s, 0); j --){
                    while(hh <= tt && calc(r, q[tt]) <= calc(r, j)) tt --;
                    q[++ tt] = j;
                }
                for(int p = maxk; p >= 0; p --){
                    while(hh <= tt && q[hh] > p - 1) hh ++;
                    if(hh <= tt){
                        f[r + p * v] = Math.max(f[r + p * v], calc(r, q[hh]) + p * w);
                    }
                    if(p - s - 1 >= 0){
                        while(hh <= tt && calc(r, q[tt]) <= calc(r, p - s - 1)) tt --;
                        q[++ tt] = p - s - 1;
                    }
                }
            }
        }

        System.out.println(f[m]);

        sin.close();
    }

    static int calc(int r, int k){
        return f[r + k * v] - k * w;
    }
}
