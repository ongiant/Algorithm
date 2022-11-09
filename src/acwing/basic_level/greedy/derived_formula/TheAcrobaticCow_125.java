package acwing.basic_level.greedy.derived_formula;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;

public class TheAcrobaticCow_125 {

    static final int N = 50010;
    static Pair[] a;
    static{
        a = new Pair[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        for(int i = 0; i < n; i ++){
            int w = sin.nextInt(), s = sin.nextInt();
            a[i] = new Pair(w + s, w);
        }
        Arrays.sort(a, 0, n, Comparator.comparingInt(e -> e.x));

        int ans = Integer.MIN_VALUE;
        for(int i = 0, sum = 0; i < n; i ++){
            int w = a[i].y, s = a[i].x - w;
            ans = Math.max(ans, sum - s);
            sum += w;
        }
        System.out.println(ans);

        sin.close();
    }

    private static class Pair{
        int x, y;
        Pair(int total, int weight){
            x = total;
            y = weight;
        }
    }
}
