package acwing.basic.difference;

import java.util.*;
import java.io.*;

public class Difference_797 {

    static final int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];

    static void insert(int l, int r, int c){
        b[l] += c;
        b[r+1] -= c;
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        int m = sin.nextInt();

        for(int i=1; i<=n; i++){
            a[i] = sin.nextInt();
        }

        for(int i=1; i<=n; i++){
            insert(i, i, a[i]);
        }

        while(m-- > 0){
            int l = sin.nextInt(), r = sin.nextInt(), c = sin.nextInt();
            insert(l, r, c);
        }

        for(int i=1; i<=n; i++){
            b[i] += b[i-1];
            System.out.printf("%d ", b[i]);
        }
    }
}
