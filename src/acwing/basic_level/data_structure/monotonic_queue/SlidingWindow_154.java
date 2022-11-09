package acwing.basic_level.data_structure.monotonic_queue;

import java.util.*;
import java.io.*;

public class SlidingWindow_154 {

    static final int N = 1000010;
    static int[] a, q;

    static {
        a = new int[N];
        q = new int[N];
    }
    public static void main(String[] args) throws IOException {
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sin.nextInt(), k = sin.nextInt();
        for(int i=0; i<n; i++){
            a[i] = sin.nextInt();
        }
        int hh = 0, tt = -1;
        for(int i=0; i<n; i++){
            if(hh <= tt && i - k + 1 > q[hh]) hh++;
            while(hh <= tt && a[q[tt]] >= a[i]) tt--;
            q[++tt] = i;
            if(i >= k - 1) bw.write(a[q[hh]] + " ");
        }
        bw.write("\n");

        hh = 0;
        tt = -1;
        for(int i=0; i<n; i++){
            if(hh <= tt && i - k + 1 > q[hh]) hh++;
            while(hh <= tt && a[q[tt]] <= a[i]) tt--;
            q[++tt] = i;
            if(i >= k - 1) bw.write(a[q[hh]] + " ");
        }
        bw.flush();
        sin.close();
        bw.close();
    }
}
