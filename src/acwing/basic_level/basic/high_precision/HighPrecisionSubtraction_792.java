package acwing.basic_level.basic.high_precision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighPrecisionSubtraction_792 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine(), y = br.readLine();
        System.out.print(sub(x, y));

        br.close();
    }

    static String sub(String x, String y){
        StringBuilder sbr = new StringBuilder();
        if(!cmp(x, y)){
            sbr.append("-").append(sub(y, x));
            return sbr.toString();
        }
        for(int i = x.length() - 1, j = y.length() - 1, t = 0; i >= 0; i --, j --){
            t = x.charAt(i) - '0' - t;
            if(j >= 0) t -= y.charAt(j) - '0';
            sbr.append((t + 10) % 10);
            t = t < 0 ? 1 : 0;
        }

        while(sbr.length() > 1 && sbr.charAt(sbr.length() - 1) == '0') sbr.deleteCharAt(sbr.length() - 1);

        return sbr.reverse().toString();
    }

    static boolean cmp(String x, String y){
        if(x.length() != y.length()) return x.length() > y.length();
        for(int i = 0; i < x.length(); i ++){
            if(x.charAt(i) != y.charAt(i)) {
                return x.charAt(i) >= y.charAt(i);
            }
        }
        return true;
    }
}
