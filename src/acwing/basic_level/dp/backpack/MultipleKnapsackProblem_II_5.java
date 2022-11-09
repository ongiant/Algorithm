package acwing.basic_level.dp.backpack;

import java.util.*;
import java.io.*;

public class MultipleKnapsackProblem_II_5 {

    static final int N = 1010;
    static int[] f;

    static {
        f = new int[12 * N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        int n = sin.nextInt(), m = sin.nextInt();

        ArrayList<Goods> goods = new ArrayList<>(12 * N);
        for(int i=0; i<n; i++){
            int v = sin.nextInt(), w = sin.nextInt(), s = sin.nextInt(), k = 1;
            while(s >= k){
                goods.add(new Goods(k * v, k * w));
                s -= k;
                k *= 2;
            }
            goods.add(new Goods(s * v, s * w));
        }

        for(Goods good : goods){
            for(int j=m; j>=good.v; j--){
                f[j] = Math.max(f[j], f[j - good.v] + good.w);
            }
        }

        System.out.println(f[m]);
    }

    static class Goods{
        int v, w;
        Goods(int x, int y){
            v = x;
            w = y;
        }
    }
}
