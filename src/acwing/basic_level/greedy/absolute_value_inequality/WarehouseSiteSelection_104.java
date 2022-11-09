package acwing.basic_level.greedy.absolute_value_inequality;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class WarehouseSiteSelection_104 {

    static final int N = 100010;
    static int[] a;
    static{
        a = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        for(int i = 0; i < n; i ++){
            a[i] = sin.nextInt();
        }
        Arrays.sort(a, 0, n);

        long ans = 0;
        for(int i = 0; i < n; i ++){
            ans += Math.abs(a[i] - a[n / 2]);
        }
        System.out.println(ans);
        sin.close();
    }
}
