package acwing.middle_level.dp.model.longest_ascending_subsequence;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class MaximumAscendingSubsequenceSum_1016 {

    static final int N = 1010;
    static int n, a[], f[];
    static{
        a = new int[N];
        f = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        for(int i = 1; i <= n; i ++) a[i] = sin.nextInt();

        int res = 0;
        for(int i = 1; i <= n; i ++){
            f[i] = a[i];
            for(int j = 1; j < i; j ++){
                if(a[i] > a[j]){
                    f[i] = Math.max(f[i], f[j] + a[i]);
                }
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);

        sin.close();
    }
}
