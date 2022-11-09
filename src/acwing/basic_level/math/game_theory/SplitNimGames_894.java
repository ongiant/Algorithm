package acwing.basic_level.math.game_theory;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.io.BufferedInputStream;

public class SplitNimGames_894 {

    static final int N = 110;
    static int n;

    static int[] f;

    static {
        f = new int[N];

        Arrays.fill(f, -1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        n = sin.nextInt();
        int ans = 0;
        for(int i = 0; i < n; i ++){
            ans ^= sg(sin.nextInt());
        }
        if(ans != 0) System.out.println("Yes");
        else System.out.println("No");

        sin.close();
    }

    static int sg(int x){
        if(f[x] != -1) return f[x];

        HashSet<Integer> S = new HashSet<>();
        for(int i = 0; i < x; i ++){
            for(int j = 0; j <= i; j ++){
                S.add(sg(i) ^ sg(j));
            }
        }

        for(int i = 0; ; i ++){
            if(!S.contains(i)) return f[x] = i;
        }
    }
}
