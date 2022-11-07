package acwing.basic.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class SimulationStack_828 {

    static final int N = 100010;
    static int stk[], tt;

    static {
        stk = new int[N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        while(M -- > 0){
            String[] s = br.readLine().split(" ");
            if("push".equals(s[0])){
                int x = Integer.parseInt(s[1]);
                push(x);
            }
            if("pop".equals(s[0])){
                pop();
            }
            if("empty".equals(s[0])){
                bw.write(empty() ? "YES\n" : "NO\n");
            }
            if("query".equals(s[0])){
                bw.write(top() + "\n");
            }
        }

        br.close();
        bw.close();
    }

    static void push(int x){
        stk[++ tt] = x;
    }

    static int pop(){
        return stk[tt --];
    }

    static int top(){
        return stk[tt];
    }

    static boolean empty(){
        return tt == 0;
    }
}
