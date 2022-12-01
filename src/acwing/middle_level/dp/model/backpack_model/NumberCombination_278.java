package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class NumberCombination_278 {

    static final int M = 10010;
    static int n, m, f[];

    static {
        f = new int[M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();
        f[0] = 1;
        for(int i = 0; i < n; i ++){
            int v = sin.nextInt();
            for(int j = m; j >= v; j --){
                f[j] += f[j - v];
            }
        }
        System.out.println(f[m]);

        sin.close();
    }
}
