package acwing.basic_level.greedy.sorting_inequality;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class QueuingForWater_913 {

    static final int N = 100010;
    static int[] t;
    static {
        t = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        for(int i = 0; i < n; i ++) t[i] = sin.nextInt();

        Arrays.sort(t, 0, n);
        long ans = 0;
        for(int i = 0; i < n; i ++){
            ans += t[i] * (n - i - 1);
        }
        System.out.println(ans);
        sin.close();
    }
}
