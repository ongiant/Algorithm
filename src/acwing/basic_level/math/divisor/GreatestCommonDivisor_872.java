package acwing.basic_level.math.divisor;

import java.util.*;
import java.io.*;

public class GreatestCommonDivisor_872 {

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sin.nextInt();
        while(n -- > 0){
            int a = sin.nextInt(), b = sin.nextInt();
            bw.write(gcd(a, b) + "\n");
        }
        sin.close();
        bw.close();
    }

    static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
