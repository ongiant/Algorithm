package acwing.math.fast_power;

import java.util.Scanner;
import java.io.*;

public class FastPower_875 {

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sin.nextInt();
        while(n -- > 0){
            int a = sin.nextInt(), k = sin.nextInt(), p = sin.nextInt();
            bw.write(qmi(a, k, p) + "\n");
        }

        sin.close();
        bw.close();
    }

    static long qmi(long a, long k, long p){
        long result = 1;
        while(k > 0){
            if((k & 1) == 1) result = result * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return result;
    }
}
