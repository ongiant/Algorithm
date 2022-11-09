package acwing.basic_level.basic.sort;

import java.util.*;
import java.io.*;

public class NumberOfReversePairs_788 {
    static final int N = 100010;
    static int[] a = new int[N], aux = new int[N];

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        for(int i = 0; i < n; i++) a[i] = sin.nextInt();
        System.out.println(merge_sort(a, 0, n - 1));

        sin.close();
    }

    static long merge_sort(int[] a, int l, int r){

        if(l == r) return 0;
        int mid = l + r >> 1;
        long res = merge_sort(a, l, mid) + merge_sort(a, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while(i <= mid && j <= r){
            if(a[i] <= a[j]) aux[k++] = a[i++];
            else{
                res += mid - i + 1;
                aux[k++] = a[j++];
            }
        }
        while(i <= mid) aux[k++] = a[i++];
        while(j <= r) aux[k++] = a[j++];

        for(i = l, k = 0; i <= r; i++, k++) a[i] = aux[k];
        return res;
    }
}
