package acwing.basic_level.basic.two_pointers;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class LongestContinuousNon_RepeatingSubsequence_799 {

    static final int N = 100010;
    static int[] a = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        int n = sin.nextInt();
        for(int i=0; i<n; i++){
            a[i] = sin.nextInt();
        }

        int ans = 0;
        for(int i=0, j=0; i<n; i++){
            s[a[i]]++;
            while(s[a[i]] > 1){
                s[a[j]]--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        System.out.println(ans);
    }
}
