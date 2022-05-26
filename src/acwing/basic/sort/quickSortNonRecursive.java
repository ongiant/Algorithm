package acwing.basic.sort;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class quickSortNonRecursive {

    static final int N = 1000010;
    static LinkedList<Interval> st = new LinkedList<>();

    public static void main(String[] args){
        InputStream ism = new BufferedInputStream(System.in);
        Scanner sc = new Scanner(ism);

        int[] a = new int[N];

        int n;
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        quick_sort(a, 0, n-1);
        for(int i=0; i<n; i++){
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }

    static void quick_sort(int[] a, int low, int high){
        st.push(new Interval(low, high));
        while(0 != st.size()){
            Interval z = st.pop();
            partition(a, z.begin, z.end);
        }
    }

    static void partition(int[] a, int low, int high){
        int p=low-1, q=high+1, v=a[low+high >>1];
        while(p<q){
            do p++; while(a[p]<v);
            do q--; while(a[q]>v);
            if(p<q) exchange(a, p, q);
        }

        if(q-low+1 > high-q){
            if(low<q) st.push(new Interval(low, q)); //静态内部类Interval在静态方法内部使用new关键字创建对象看起来总是怪怪的
            if(q+1<high) st.push(new Interval(q+1, high));
        }
        else{
            if(q+1<high) st.push(new Interval(q+1, high));
            if(low<q) st.push(new Interval(low, q));
        }
    }

    static void exchange(int[] a, int i, int j){
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

    static class Interval{
        int begin;
        int end;
        Interval(int begin, int end){
            this.begin = begin;
            this.end = end;
        }
    }
}
