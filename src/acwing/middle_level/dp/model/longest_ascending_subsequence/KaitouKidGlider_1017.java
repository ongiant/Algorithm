package acwing.middle_level.dp.model.longest_ascending_subsequence;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class KaitouKidGlider_1017 {

    static final int N = 110;
    static int k, n, a[], f[], g[];
    static{
        a = new int[N];
        f = new int[N];
        g = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        k = sin.nextInt();
        while(k -- > 0){
            n = sin.nextInt();
            for(int i = 1; i <= n; i ++) a[i] = sin.nextInt();

            int res = 0;
            for(int i = 1; i <= n; i ++){
                f[i] = g[i] = 1;
                for(int j = 1; j < i; j ++){
                    if(a[i] > a[j]){
                        f[i] = Math.max(f[i], f[j] + 1);
                        res = Math.max(res, f[i]);
                    }
                    if(a[i] < a[j]){
                        g[i] = Math.max(g[i], g[j] + 1);
                        res = Math.max(res, g[i]);
                    }
                }
            }
            System.out.println(res);
        }

        sin.close();
    }
}
