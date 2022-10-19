package acwing.basic.interval_merge;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class IntervalMerge_803 {

    static final int INF = 0x3f3f3f3f;

    static LinkedList<Integer[]> intervals, ans;

    static{
        intervals = new LinkedList<>();
        ans = new LinkedList<>();
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        while(n -- > 0){
            Integer[] t = new Integer[2];
            t[0] = sin.nextInt();
            t[1] = sin.nextInt();
            intervals.add(t);
        }

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        int start = INF, end = -INF;
        for(Integer[] e : intervals){
            if(end >= e[0]){
                end = Math.max(end, e[1]);
            }
            else{
                if(end != INF) ans.add(new Integer[]{start, end});
                start = e[0];
                end = e[1];
            }
        }
        System.out.println(ans.size());

        sin.close();
    }
}
