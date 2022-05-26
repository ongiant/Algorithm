package acwing.basic.binary_search;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class RangeOfNumbers_789 {
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n, q;
        n = sin.nextInt();
        q = sin.nextInt();

        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sin.nextInt();
        }

        for(int i=0; i<q; i++){
            int k = sin.nextInt();
            getRange(a, k);
        }
    }

    static void getRange(int[] a, int k){
        int le = 0, ri = a.length - 1;
        while(le < ri){
            int mid = le + ri >> 1;
            if(a[mid] >= k){
                ri = mid;
            }
            else {
                le = mid + 1;
            }
        }
        if(a[le] != k){
            System.out.println("-1 -1");
        }
        else{
            int start = le;
            le = 0;
            ri = a.length - 1;
            while(le < ri){
                int mid = le + ri +1 >> 1;
                if(a[mid] <= k){
                    le = mid;
                }
                else{
                    ri = mid - 1;
                }
            }
            System.out.println(start + " " + le);
        }
    }
}
