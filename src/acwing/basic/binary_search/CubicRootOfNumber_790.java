package acwing.basic.binary_search;

import java.util.*;
import java.io.*;

public class CubicRootOfNumber_790 {
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        double n = sin.nextDouble();
        binarySearch(n);
    }

    static void binarySearch(double n){
        double le = -10000, ri = 10000;
        while(ri - le > 1e-8){
            double mid = (le + ri) / 2;
            if(mid * mid * mid >= n){
                ri = mid;
            }
            else{
                le = mid;
            }

        }
        System.out.printf("%6f", ri);
    }
}
