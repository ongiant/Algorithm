package acwing.basic.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class MockQueue_829 {

    static final int N = 100010;
    static int q[], hh, tt = -1;

    static {
        q = new int[N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        while(M -- > 0){
            String[] s = br.readLine().split(" ");
            if("push".equals(s[0])){
                int x = Integer.parseInt(s[1]);
                q[++ tt] = x;
            }
            if("pop".equals(s[0])){
                hh ++;
            }
            if("empty".equals(s[0])){
                bw.write(hh > tt ? "YES\n" : "NO\n");
            }
            if("query".equals(s[0])){
                bw.write(q[hh] + "\n");
            }
        }

        br.close();
        bw.close();
    }
}
