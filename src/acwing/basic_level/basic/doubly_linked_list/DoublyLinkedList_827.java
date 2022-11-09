package acwing.basic_level.basic.doubly_linked_list;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class DoublyLinkedList_827 {

    static final int N = 100010, head = 0, tail = N - 1;
    static int idx;
    static int[] e, l, r;

    static {
        e = new int[N];
        l = new int[N];
        r = new int[N];
        init();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        while(M -- > 0){
            String[] s = br.readLine().split(" ");
            if(s.length == 2){
                int v = Integer.parseInt(s[1]);
                if("L".equals(s[0])){
                    insertRight(head, v);
                }
                if("R".equals(s[0])){
                    insertRight(l[tail], v);
                }
                if("D".equals(s[0])){
                    remove(v);
                }
            }
            if(s.length == 3){
                int k = Integer.parseInt(s[1]), v = Integer.parseInt(s[2]);
                if("IL".equals(s[0])){
                    insertRight(l[k], v);
                }
                if("IR".equals(s[0])){
                    insertRight(k, v);
                }
            }
        }
        for(int i = r[head]; i != tail; i = r[i]){
            bw.write(e[i] + " ");
        }

        br.close();
        bw.close();
    }

    static void init(){
        // 双链表的头节点下标为0,尾节点下标为N-1
        r[head] = tail;
        l[tail] = head;
        idx = head + 1;
    }

    static void insertRight(int index, int value){
        e[idx] = value;
        l[idx] = index;
        r[idx] = r[index];
        l[r[index]] = idx;
        r[index] = idx ++;
    }

    static void remove(int index){
        r[l[index]] = r[index];
        l[r[index]] = l[index];
    }
}
