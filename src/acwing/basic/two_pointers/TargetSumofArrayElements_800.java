package acwing.basic.two_pointers;

import java.util.*;
import java.io.*;

public class TargetSumofArrayElements_800 {

    static int[] a, b;
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        int n = sin.nextInt(), m = sin.nextInt(), x = sin.nextInt();

        a = new int[n];
        b = new int[m];

        for(int i=0; i<n; i++){
            a[i] = sin.nextInt();
        }
        for(int i=0; i<m; i++){
            b[i] = sin.nextInt();
        }

        for(int i=0, j=m-1; i<n; i++){
            while(j >=0 && a[i] + b[j] >= x){
                if(a[i] + b[j] == x){
                    System.out.println(i + " " + j);
                    break;
                }
                j--;
            }
        }
    }
}
