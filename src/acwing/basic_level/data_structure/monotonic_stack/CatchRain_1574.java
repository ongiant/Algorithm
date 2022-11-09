package acwing.basic_level.data_structure.monotonic_stack;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class CatchRain_1574 {
    public static void main(String[] args){

        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();

        int[] q = new int[n];
        int[] h = new int[n];

        for(int i=0; i<n; i++){
            h[i] = sin.nextInt();
        }

        int tt = -1;
        int ans = 0;
        for(int i=0; i<n; i++){
            int last_height = 0;
            while(tt >= 0 && h[q[tt]] < h[i]){
                ans += (h[q[tt]] - last_height) * (i - q[tt] - 1);
                last_height = h[q[tt]];
                tt--;
            }
            if(tt>=0) ans += (h[i] - last_height) * (i - q[tt] - 1);
            q[++tt] = i;
        }

        System.out.print(ans);
    }
}
