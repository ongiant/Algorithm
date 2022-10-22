package acwing.basic.high_precision;

import java.util.Collections;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class HighPrecisionDivision_794 {

    static ArrayList<Integer> A, C;
    static{
        A = new ArrayList<>();
        C = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        for(int i = s.length() - 1; i >= 0; i --) A.add(s.charAt(i) - '0');

        Integer b = Integer.valueOf(br.readLine());
        int r = div(A, b);

        for(int i = C.size() - 1; i >= 0; i --){
            bw.write("" + C.get(i));
        }
        bw.write("\n" + r);

        br.close();
        bw.close();
    }

    static Integer div(ArrayList<Integer> A, Integer b){
        Integer r = 0;
        for(int i = A.size() - 1; i >= 0; i --){
            r = r * 10 + A.get(i);
            C.add(r / b);
            r %= b;
        }
        Collections.reverse(C);
        while(C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);
        return r;
    }
}
