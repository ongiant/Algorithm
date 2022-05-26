package acwing.data_structure.heap;

import java.io.*;

public class AnalogHeap_839 {
    static int sz;
    static final int N = 100010;
    static int [] h, ph, hp;
    static {
        h = new int[N];
        ph = new int[N];
        hp = new int[N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), m = 0;
        while(n-- > 0){
            String[] s = br.readLine().split(" ");
            if("I".equals(s[0])){
                sz++;
                m++;
                ph[m] = sz; hp[sz] = m;
                h[sz] = Integer.parseInt(s[1]);
                swim(sz);
            }
            else if("PM".equals(s[0])){
                bw.write(h[1] + "\n");
            }
            else if("DM".equals(s[0])){
                heap_swap(1, sz);
                sz--;
                sink(1);
            }
            else if("D".equals(s[0])){
                int k = Integer.parseInt(s[1]);
                int index = ph[k];
                heap_swap(index, sz);
                sz--;
                sink(index); swim(index);
            }
            else{
                int k = Integer.parseInt(s[1]), x = Integer.parseInt(s[2]);
                int index = ph[k];
                h[index] = x;
                sink(index); swim(index);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    // 下沉
    static void sink(int index){
        int t = index;
        if(2 * index <= sz && h[2 * index] < h[t]) t = 2 * index;
        if(2 * index + 1 <= sz && h[2 * index + 1] < h[t]) t = 2 * index + 1;
        if(t != index){
            heap_swap(index, t);
            sink(t);
        }
    }

    // 上浮
    static void swim(int index){
        while(index / 2 > 0 && h[index / 2] > h[index]){
            heap_swap(index / 2, index);
            index /= 2;
        }
    }

    static void heap_swap(int i, int j){
        exch(ph, hp[i], hp[j]);
        exch(hp, i, j);
        exch(h, i, j);
    }

    static void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
