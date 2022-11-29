package acwing.middle_level.dp.model.backpack_model;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class ConqueringPokemon_1022 {

    static final int N = 1010, M = 510;
    static int f[][], V1, V2, K;
    static{
        f = new int[N][M];
    }
    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        V1 = sin.nextInt();
        V2 = sin.nextInt();
        K = sin.nextInt();

        f[0][0] = 0;
        for(int i = 1; i <= K; i ++){
            int v1 = sin.nextInt(), v2 = sin.nextInt();
            for(int j = V1; j >= v1; j --){
                for(int k = V2 - 1; k >= v2; k --){
                    f[j][k] = Math.max(f[j][k], f[j - v1][k - v2] + 1);
                }
            }
        }
        System.out.print(f[V1][V2 - 1] + " ");

        int k = V2 - 1;
        while(k > 0 && f[V1][k - 1] == f[V1][V2 - 1]) k --;

        System.out.println(V2 - k);

        sin.close();
    }
}
