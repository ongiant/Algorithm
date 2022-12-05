package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class CurrencySystem_1021 {

    static final int M = 3010;
    static int n, m;
    static long[] f;
    static{
        f = new long[M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        m = sin.nextInt();

        f[0] = 1;
        for(int i = 0; i < n; i ++){
            int v = sin.nextInt();
            for(int j = v; j <= m; j ++){
                f[j] += f[j - v];
            }
        }
        System.out.println(f[m]);

        sin.close();
    }
}
