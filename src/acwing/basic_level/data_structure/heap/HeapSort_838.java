package acwing.basic_level.data_structure.heap;

import java.util.*;
import java.io.*;

public class HeapSort_838 {

    static int size;
    static final int N = 100010;
    static int[] heap;
    static {
        heap = new int[N];
    }

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sin.nextInt(), m = sin.nextInt();

        for(int i = 1; i <= n; i++) heap[i] = sin.nextInt();
        size = n;
        // 建堆
        for(int i = n / 2; i > 0; i--){
            sink(i);
        }

        while(m-- > 0){
            bw.write(heap[1] + " ");
            heap[1] = heap[size];
            size--;
            sink(1);
        }

        bw.flush();
        sin.close();
        bw.close();
    }

    static void sink(int index){

        int t = index;
        if(2 * index <= size && heap[2 * index] < heap[t]) t = 2 * index;
        if(2 * index + 1 <= size && heap[2 * index + 1] < heap[t]) t = 2 * index + 1;
        if(t != index){
            exch(index, t);
            sink(t);
        }
    }

    static void exch(int i, int j){
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
}
