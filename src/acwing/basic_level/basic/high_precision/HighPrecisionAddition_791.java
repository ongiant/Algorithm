package acwing.basic_level.basic.high_precision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighPrecisionAddition_791 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine(), y = br.readLine();
        System.out.println(add(x, y));

        br.close();
    }

    static String add(String x, String y){
        if(x.length() < y.length()) return add(y, x);

        StringBuilder sbr = new StringBuilder();
        int t = 0;
        for(int i = x.length() - 1, j = y.length() - 1; i >= 0; i --, j --){
            t += x.charAt(i) - '0';
            if(j >= 0) t += y.charAt(j) - '0';
            sbr.append(t % 10);
            t /= 10;
        }

        if(t > 0) sbr.append(t);
        return sbr.reverse().toString();
    }
}
