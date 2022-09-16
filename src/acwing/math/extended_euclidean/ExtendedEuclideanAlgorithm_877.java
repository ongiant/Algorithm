package acwing.math.extended_euclidean;

import java.util.*;
import java.io.*;

public class ExtendedEuclideanAlgorithm_877 {

    static int[] x, y;

    static {
        x = new int[1];
        y = new int[1];
    }

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sin.nextInt();
        while(n -- > 0){
            int a = sin.nextInt(), b = sin.nextInt();
            exgcd(a, b, x, y);
            bw.write(x[0] + " " + y[0] + "\n");
        }

        sin.close();
        bw.close();
    }

    static int exgcd(int a, int b, int[] x, int[] y){
        int d;
        if(b == 0){
            x[0] = 1;
            y[0] = 0;
            d = a;
        }
        else{
            d = exgcd(b, a % b, y, x);
            y[0] -= a / b * x[0];
        }

        return d;
    }
}
