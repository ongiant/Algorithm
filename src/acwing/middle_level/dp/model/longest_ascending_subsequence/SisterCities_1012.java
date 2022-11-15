package acwing.middle_level.dp.model.longest_ascending_subsequence;
import java.util.Comparator;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;

public class SisterCities_1012 {

    static final int N = 5010;
    static Pair[] a;
    static int[] f;
    static{
        a = new Pair[N];
        f = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        for(int i = 0; i < n; i ++){
            a[i] = new Pair(sin.nextInt(), sin.nextInt());
        }

        Arrays.sort(a, 0, n, Comparator.comparingInt(x -> x.first));

        for(int i = 0; i < n; i ++){
            f[i] = 1;
            for(int j = 0; j < i; j ++){
                if(a[i].second > a[j].second){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i ++) res = Math.max(res, f[i]);
        System.out.println(res);

        sin.close();
    }

    private static class Pair{
        int first;
        int second;
        Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
}
