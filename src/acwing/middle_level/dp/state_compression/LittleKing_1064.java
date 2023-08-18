package acwing.middle_level.dp.state_compression;
import java.util.Scanner;
import java.util.LinkedList;

public class LittleKing_1064 {

    static final int N = 12, M = 110, S = 1 << 10;
    static int n, k;
    static int[] state, cnt;
    static LinkedList<Integer>[] forward;
    static long[][][] f;

    static{
        state = new int[S];
        forward = new LinkedList[S];
        cnt = new int[N];
        f = new long[N][M][S];
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        n = sin.nextInt();
        k = sin.nextInt();

        int scnt = 0;
        for(int i = 0; i < 1 << n; i++){
            if(check(i)) state[scnt++] = i;
        }


        for(int i = 0; i < scnt; i++){
            for(int j = 0; j < scnt; j++){
                int a = state[i], b = state[j];
                if((a & b) == 0 && check(a | b)){
                    if(forward[a] == null) forward[a] = new LinkedList<>();
                    forward[a].add(b);
                }
            }
        }

        f[0][0][0] = 1;
        for(int i = 1; i <= n + 1; i++){
            for(int j = 0; j <= k; j++){
                for(int p = 0; p < scnt; p++){
                    int a = state[p];
                    for(Integer b : forward[a]){
                        if(j - count(a) >= count(b)){
                            f[i][j][a] += f[i - 1][j - count(a)][b];
                        }
                    }
                }
            }
        }

        System.out.println(f[n + 1][k][0]);

        sin.close();
    }

    static boolean check(int state){
        for(int i = 0; i < n; i++){
            if(((state >> i) & 1) == 1 && ((state >> (i + 1)) & 1) == 1) return false;
        }
        return true;
    }

    static int count(int state){
        int res = 0;
        while(state > 0) {
            res += state & 1;
            state >>= 1;
        }
        return res;
    }
}
