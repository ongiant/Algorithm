package acwing.basic_level.basic.discretization;

import java.io.*;
import java.util.*;

public class IntervalSum_802 {

    static ArrayList<Integer> all = new ArrayList<>(300010);

    static int find(int x){
        int left = 0, right = all.size() - 1;
        while(left < right){
            int mid = left + right >> 1;
            if(all.get(mid) >= x){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left + 1;
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        int m = sin.nextInt();

        ArrayList<Pair> pairs = new ArrayList<>(n);
        ArrayList<Pair> queries = new ArrayList<>(m);
        for(int i=0; i<n; i++){
            int x = sin.nextInt();
            int c = sin.nextInt();
            all.add(x);
            pairs.add(new Pair(x, c));
        }

        for(int i=0; i<m; i++){
            int l = sin.nextInt();
            int r = sin.nextInt();
            all.add(l);
            all.add(r);
            queries.add(new Pair(l, r));
        }

        Collections.sort(all);
        int j = 0;
        for(int i=0; i<all.size(); i++){
            if(i==0 || !Objects.equals(all.get(i), all.get(i - 1))){
                all.set(j++, all.get(i));
            }
        }
        /**
         * 基类的 protected 成员是包内可见的，并且对子类可见；
         * 若子类与基类不在同一包中，那么在子类中，子类实例可以访问其从基类继承而来的protected方法，而不能访问基类实例的protected方法
         */
//        Arrays.removeRange(j, all.size());
        if (all.size() > j) {
            all.subList(j, all.size()).clear();
        }

        int len = all.size();
        int[] b = new int[len+1];
        for (Pair p: pairs) {
            int x = find(p.first);
            b[x] += p.second;
        }

        int[] sum = new int[len + 1];
        for(int i=1; i<len+1; i++) {
            sum[i] = sum[i-1] + b[i];
        }

        for(Pair query: queries){
            System.out.println(sum[find(query.second)] - sum[find(query.first) -1]);
        }
    }

    static class Pair{
        int first;
        int second;
        Pair(int x, int y){
            this.first = x;
            this.second = y;
        }
    }
}
