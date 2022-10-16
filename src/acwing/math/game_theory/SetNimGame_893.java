package acwing.math.game_theory;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;
import java.io.BufferedInputStream;

public class SetNimGame_893 {

    static final int N = 10010;
    static int n, k;
    static int[] s, f;

    static{
        s = new int[N];
        f = new int[N];

        Arrays.fill(f, -1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        k = sin.nextInt();
        for(int i = 0; i < k; i ++) s[i] = sin.nextInt();

        n = sin.nextInt();
        int ans = 0;
        for(int i = 0; i < n; i ++){
            int t = sin.nextInt();
            ans ^= sg(t);
        }

        if(ans != 0) System.out.println("Yes");
        else System.out.println("No");

        sin.close();
    }

    static int sg(int x){
        if(f[x] != -1) return f[x];

        HashSet<Integer> S = new HashSet<>();
        for(int i = 0; i < k; i ++){
            if(x >= s[i]) S.add(sg(x - s[i]));
        }

        for(int i = 0; ; i ++){
            if(!S.contains(i)) return f[x] = i;
        }
    }
}
