package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class CollectingHerbs_423 {

    static final int N = 110, M = 1010;
    static int n, m, f[];
    static{
        f = new int[M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        m = sin.nextInt();
        n = sin.nextInt();

        for(int i = 0; i < n; i ++){
            int v = sin.nextInt(), w = sin.nextInt();
            for(int j = m; j >= v; j --){
                f[j] = Math.max(f[j], f[j - v] + w);
            }
        }
        System.out.println(f[m]);

        sin.close();
    }
}
