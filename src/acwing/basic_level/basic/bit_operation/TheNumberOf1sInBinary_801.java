package acwing.basic_level.basic.bit_operation;

import java.util.*;
public class TheNumberOf1sInBinary_801 {

    static int f(int x){
        int s = 0;
        while(x > 0){
            x -= x&-x;
            s++;
        }
        return s;
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sin.nextInt();
        }
        for(int i = 0; i<n; i++){
             System.out.printf("%d ", f(a[i]));
        }
    }
}
