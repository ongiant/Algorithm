package acwing.basic.high_precision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighPrecisionMultiplication_793 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        int b = Integer.parseInt(br.readLine());
        System.out.print(mul(A, b));

        br.close();
    }

    static String mul(String A, int b){
        StringBuilder sbr = new StringBuilder();
        for(int i = A.length() - 1, t = 0; i >= 0 || t > 0; i --){
            if(i >= 0) t += (A.charAt(i) - '0') * b;
            sbr.append(t % 10);
            t /= 10;
        }
        while(sbr.length() > 1 && sbr.charAt(sbr.length() - 1) == '0') sbr.deleteCharAt(sbr.length() - 1);
        return sbr.reverse().toString();
    }
}
