package acwing.data_structure.monotonic_stack;

import java.util.*;
import java.io.*;

public class MonotonicStack830 {
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        int[] q = new int[n];
        for(int i=0; i<n; i++){
            q[i] = sin.nextInt();
        }

        int tt = -1;
        for(int i=0; i<n; i++){
            while(tt>=0 && q[tt] >= q[i]){
                tt--;
            }
            if(tt>=0) System.out.print(q[tt]+" ");
            else System.out.print(-1+" ");
            q[++tt] = q[i];
        }
    }
}
