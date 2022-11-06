package acwing.basic.singly_linked_list;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SinglyLinkedList_826 {

    static final int N = 100010;
    static int head, idx, e[], ne[];

    static {
        e = new int[N];
        ne = new int[N];

        init();
    }

    static void init(){
        head = -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        while(M -- > 0){
            String[] s = br.readLine().split(" ");
            if("H".equals(s[0])){
                int x = Integer.parseInt(s[1]);
                insertToHead(x);

            }
            if("D".equals(s[0])){
                int k = Integer.parseInt(s[1]);
                remove(k);
            }
            if("I".equals(s[0])){
                int k = Integer.parseInt(s[1]), x = Integer.parseInt(s[2]);
                insert(k, x);
            }
        }

        for(int i = head; i != -1; i = ne[i]){
            bw.write(e[i] + " ");
        }

        br.close();
        bw.close();
    }

    static void insertToHead(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx ++;
    }

    static void insert(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k - 1];
        ne[k - 1] = idx ++;
    }

    static void remove(int k){
        if(k == 0) head = ne[head];
        else ne[k - 1] = ne[ne[k - 1]];
    }
}
