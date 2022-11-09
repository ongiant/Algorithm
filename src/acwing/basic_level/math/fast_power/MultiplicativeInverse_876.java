package acwing.basic_level.math.fast_power;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MultiplicativeInverse_876 {

    public static void main(String[] args) throws IOException {
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sin.nextInt();
        while(n -- > 0){
            int a = sin.nextInt(), p = sin.nextInt();
            long t = qmi(a, p - 2, p);
            if(a % p != 0) bw.write(t + "\n");
            else bw.write("impossible\n");
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
