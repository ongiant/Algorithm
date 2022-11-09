package acwing.basic_level.greedy;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberDisjointIntervals_908 {

    static final int N = 100010;
    static Pair[] intervals;

    static {
        intervals = new Pair[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        for(int i = 0; i < n; i ++){
            int l = sin.nextInt(), r = sin.nextInt();
            intervals[i] = new Pair(l, r);
        }
        Arrays.sort(intervals, 0, n, Comparator.comparingInt(x -> x.r));

        int res = 0, ed =Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++){
            if(intervals[i].l > ed){
                res ++;
                ed = intervals[i].r;
            }
        }
        System.out.println(res);
        sin.close();
    }

    static class Pair{
        int l, r;
        Pair(int left, int right){
            l = left;
            r = right;
        }
    }
}
