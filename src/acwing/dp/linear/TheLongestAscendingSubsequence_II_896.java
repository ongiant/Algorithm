package acwing.dp.linear;

import java.util.*;

public class TheLongestAscendingSubsequence_II_896 {

    static final int N = 100010;
    static int[] a, q;

    static {
        a = new int[N];
        q = new int[N];
    }

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        for(int i=0; i<n; i++){
            a[i] = sin.nextInt();
        }

        int len = 0;
        for(int i=0; i<n; i++){
            int l = 0, r = len;
            while(l < r) {
                int mid = l + r + 1 >> 1;
                if(q[mid] < a[i]){
                    l = mid;
                }
                else{
                    r = mid - 1;
                }
            }
            len = Math.max(len, r + 1);

            // len的长度值不包括q[0]
            q[r + 1] = a[i];
        }
        System.out.println(len);
    }
}
