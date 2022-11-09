package acwing.basic_level.basic.two_pointers;

import java.io.BufferedInputStream;
import java.util.*;

public class JudgmentSubsequence_2816 {
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        int n = sin.nextInt(), m = sin.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i=0; i<n; i++){
            a[i] = sin.nextInt();
        }
        for(int i=0; i<m; i++){
            b[i] = sin.nextInt();
        }

        int k=0, j=0;
        while(k<n && j<m){
            if(a[k] == b[j]){
                k++;
            }
            j++;
        }
        if(k == n){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
    }
}
