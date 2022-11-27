package acwing.middle_level.dp.model.backpack_model;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class BoxPacking_1024 {

    static final int N = 20010;
    static int n, V, f[];
    static {
        f = new int[N];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        V = sin.nextInt();
        n = sin.nextInt();

        for(int i = 0; i < n; i ++){
            int v = sin.nextInt();
            for(int j = V; j >= v; j --){
                f[j] = Math.max(f[j], f[j - v] + v);
            }
        }

        System.out.println(V - f[V]);
        sin.close();
    }
}
