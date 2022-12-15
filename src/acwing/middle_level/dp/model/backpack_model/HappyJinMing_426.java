package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class HappyJinMing_426 {

    static final int V = 30010;
    static int[] f;
    static int n, m;

    static{
        f = new int[V];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        m = sin.nextInt();
        n = sin.nextInt();
        for(int i = 1; i <= n; i ++){
            int v = sin.nextInt(), p = sin.nextInt();
            for(int j = m; j >= v; j --){
                f[j] = Math.max(f[j], f[j - v] + v * p);
            }
        }
        System.out.println(f[m]);

        sin.close();
    }
}
