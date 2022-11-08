package acwing.greedy;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class IntervalGrouping_906 {

    static final int N = 100010;
    static Pair[] intervals;

    static{
        intervals = new Pair[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        for(int i = 0; i < n; i ++){
            int l = sin.nextInt(), r = sin.nextInt();
            intervals[i] = new Pair(l, r);
        }
        Arrays.sort(intervals, 0, n, Comparator.comparingInt(x -> x.l));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < n; i ++){
            Pair x = intervals[i];
            if(!heap.isEmpty() && heap.peek() < x.l){
                heap.poll();
            }
            heap.offer(x.r);
        }
        System.out.println(heap.size());

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
