package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class BuyingBooks_1023 {
    static final int M = 1010;
    static int m;
    static int[] f, v;
    static{
        f = new int[M];
        v = new int[]{10, 20, 50, 100};
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        m = sin.nextInt();

        f[0] = 1;
        for(int i = 0; i < 4; i ++){
            for(int j = v[i]; j <= m; j ++){
                f[j] += f[j - v[i]];
            }
        }
        System.out.println(f[m]);

        sin.close();
    }
}
