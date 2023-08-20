package acwing.middle_level.dp.state_compression;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ArtilleryEmplacements_292 {
    static final int N = 110, M = 10, S = 1 << M;
    static int n, m;
    static int[] g, state, cnt;
    static int[][][] f;

    static {
        g = new int[N];
        state = new int[S];
        cnt = new int[S];
        f = new int[2][S][S];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        for(int i = 1; i <= n; i++){
            String line = br.readLine().trim();
            for(int j = 0; j < line.length(); j++){
                char c = line.charAt(j);
                if(c == 'H') g[i] += 1 << j;
            }
        }

        int scnt = 0;
        for(int i = 0; i < 1 << m; i++){
            if(check(i)) {
                state[scnt++] = i;
                cnt[i] = count(i);
            }
        }

        for(int i = 1; i <= n + 2; i++){
            for(int j = 0; j < scnt; j++){
                int b = state[j];
                if((g[i - 1] & b) != 0) continue;

                for(int k = 0; k < scnt; k++){
                    int c = state[k];
                    if((g[i] & c) != 0) continue;
                    if((b & c) != 0) continue;

                    for(int u = 0; u < scnt; u++){
                        int a = state[u];
                        if((a & b) != 0 || (a & c) != 0) continue;
                        f[i & 1][j][k] = Math.max(f[i & 1][j][k], f[i - 1 & 1][u][j] + cnt[c]);
                    }
                }
            }
        }

        System.out.println(f[n + 2 & 1][0][0]);

        br.close();
    }

    static boolean check(int state){
        for(int i = 0; i < m; i++){
            if((state >> i & 1) == 1 && ((state >> i + 1 & 1) == 1 || (state >> i + 2 & 1) == 1))
                return false;
        }
        return true;
    }

    static int count(int state){
        int res = 0;
        while(state > 0){
            res += state & 1;
            state >>= 1;
        }
        return res;
    }
}
