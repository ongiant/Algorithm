package acwing.basic.sort;

import java.io.*;
import java.util.*;

public class Kth_number_786 {
    static int N = 100000 + 10;
    public static void main(String[] args){
        BufferedInputStream br = new BufferedInputStream(System.in);
        Scanner sc = new Scanner(br);

        int[] a = new int[N];

        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        System.out.print(quick_select(a, 0, n-1, k));
    }

    static int quick_select(int[] a, int low, int high, int k){
        if(low==high) return a[low]; // 因为算法保证了k一定在区间[low, high]里，根据夹逼准则可知，此时这个区间里唯一的数就是解
        int z = partition(a, low, high);
        if(k<=z-low+1){
            return quick_select(a, low, z, k);
        }else{
            return quick_select(a, z+1, high, k-z+low-1);
        }
    }
    static int partition(int[] a, int low, int high){
        int p=low-1, q=high+1, v=a[(low + high)>>1];
        while(p<q){
            do p++; while(a[p]<v);
            do q--; while(a[q]>v);
            if(p<q) exchange(a, p, q);
        }
        return q;
    }

    static void exchange(int[] a, int p, int q){
        a[p] = a[p] + a[q];
        a[q] = a[p] - a[q];
        a[p] = a[p] - a[q];
    }
}
