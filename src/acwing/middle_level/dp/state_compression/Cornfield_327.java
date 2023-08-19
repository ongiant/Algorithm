package acwing.middle_level.dp.state_compression;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

public class Cornfield_327 {

    static final int N = 14, S = 1 << N, MOD = 10000 * 10000;
    static int n, m;
    static int[] g, state;
    static int[][] f;
    static LinkedList<Integer>[] forward;

    static{
        g = new int[N];
        state = new int[S];
        f = new int[N][S];

        forward = new LinkedList[S];
//        Arrays.fill(forward, new LinkedList<>()); // do not use this, because all elements will use a same reference object
    }
    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        m = sin.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < m; j++){
                int t = sin.nextInt();
                g[i] += (t ^ 1) << j;
            }
        }

        int scnt = 0;
        for(int i = 0; i < 1 << m; i ++){
            if(check(i)) state[scnt++] = i;
        }

        for(int i = 0; i < scnt; i++){
            for(int j = 0; j < scnt; j++){
                int a = state[i], b = state[j];
                if(forward[a] == null) forward[a] = new LinkedList<>();
                if((a & b) == 0 && check(b)){
                    forward[a].add(b);
                }
            }
        }

        f[0][0] = 1;
        for(int i = 1; i <= n + 1; i++){
            for(int j = 0; j < scnt; j++){
                int a = state[j];
                if((g[i] & a) != 0) continue;
                for(Integer b : forward[a]){
                    if((g[i - 1] & b) != 0) continue;
                    f[i][a] = (f[i][a] + f[i - 1][b]) % MOD;
                }
            }
        }

        System.out.println(f[n + 1][0]);

        sin.close();
    }

    static boolean check(int state){
        for(int i = 1; i < m; i++){
            if((state >> i - 1 & 1) == 1 && (state >> i & 1) == 1) return false;
        }
        return true;
    }
}
