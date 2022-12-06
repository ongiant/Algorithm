package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedInputStream;

public class CurrencySystem_532 {
    static final int N = 110, M = 25010;
    static int T, n;
    static int[] a, f;
    static{
        a = new int[N];
        f = new int[M];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        T = sin.nextInt();
        while(T -- > 0){
            n = sin.nextInt();
            for(int i = 0; i < n; i ++) a[i] = sin.nextInt();
            Arrays.sort(a, 0, n);

            Arrays.fill(f, 0);
            int ans = 0, m = a[n - 1];
            f[0] = 1;
            for(int i = 0; i < n; i ++){
                if(f[a[i]] == 0)  ans ++;
                for(int j = a[i]; j <= m; j ++){
                    f[j] += f[j - a[i]];
                }
            }
            System.out.println(ans);
        }

        sin.close();
    }
}
