package acwing.greedy;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;

public class IntervalCoverage_907 {

    static final int N = 100010;
    static Pair[] intervals;

    static{
        intervals = new Pair[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int start = sin.nextInt(), end = sin.nextInt();
        int n = sin.nextInt();
        for(int i = 0; i < n; i ++){
            int l = sin.nextInt(), r = sin.nextInt();
            intervals[i] = new Pair(l, r);
        }
        Arrays.sort(intervals, 0, n, Comparator.comparingInt(x -> x.l));

        int res = 0;
        boolean success = false;
        for(int i = 0; i < n; i ++){
            int j = i, r = Integer.MIN_VALUE;
            while(j < n && intervals[j].l <= start){
                r = Math.max(r, intervals[j].r);
                j ++;
            }
            if(r < start){
                res = -1;
                break;
            }
            res ++;
            if(r >= end){
                success = true;
                break;
            }
            start = r;
            i = j - 1;
        }
        if(!success) res = -1;
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
