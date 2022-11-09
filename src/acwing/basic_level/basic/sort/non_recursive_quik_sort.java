package acwing.basic_level.basic.sort;

import java.io.*;
import java.util.*;


class Main{

    int N = 100000 + 10;
    static int a[];
    static LinkedList<Interval> st = new LinkedList<>();

    public static void main(String[] args){
        try{
            a = new int[100010];
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n;
            n = Integer.parseInt(br.readLine());

            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for(int i=0; tokenizer.hasMoreTokens(); i++){
                a[i] = Integer.parseInt(tokenizer.nextToken());
            }
            quick_sort(a, 0, n-1);
            for(int i=0; i<n; i++){
                System.out.print(a[i]);
                System.out.print(" ");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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
            if(low<q) st.push(new Interval(low, q));
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
}

class Interval {
    int begin;
    int end;
    Interval(int begin, int end){
        this.begin = begin;
        this.end = end;
    }
}
