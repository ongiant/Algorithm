package acwing.middle_level.dp.model.automata;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RepairDNA_1053 {

    static final int M = 1010, INF = 0x3f3f3f3f;
    static int[][] f;
    static int hh, tt, q[];
    static int trie[][], ne[], dar[], idx;

    static{
        f = new int[M][M];
        q = new int[M];
        trie = new int[M][4];
        ne = new int[M];
        dar = new int[M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, T = 1;
        while((n = Integer.parseInt(br.readLine())) != 0){
            init();

            for(int i = 0; i < n; i++) insert(br.readLine());

            build();

            String text = br.readLine();
            int m = text.length();
            text =  " " + text;

            f[0][0] = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j <= idx; j++){
                    for(int k = 0; k < 4; k++){
                        int t = index(text.charAt(i + 1)) != k ? 1 : 0;
                        int p = trie[j][k];
                        if(dar[p] == 0) f[i + 1][p] = Math.min(f[i + 1][p], f[i][j] + t);
                    }
                }
            }

            int res = INF;
            for(int j = 0; j <= idx; j++) res = Math.min(res, f[m][j]);
            if(res == INF) res = -1;

            System.out.printf("Case %d: %d\n", T++, res);
        }

        br.close();
    }

    static void build(){
        hh = 0;
        tt = -1;
        for(int i = 0; i < 4; i++){
            if(trie[0][i] != 0) q[++tt] = trie[0][i];
        }

        while(hh <= tt){
            int p = q[hh++];
            for(int i = 0; i < 4; i++){
                int s = trie[p][i], next = trie[ne[p]][i];

                if(s == 0) trie[p][i] = next;
                else{
                    ne[s] = next;
                    q[++tt] = s;
                    dar[s] |= dar[ne[s]];
                }
            }
        }
    }

    static void insert(String s){
        int p = 0;
        for(int i = 0; i < s.length(); i++){
            int t = index(s.charAt(i));
            if(trie[p][t] == 0) trie[p][t] = ++idx;
            p = trie[p][t];
        }
        dar[p] = 1;
    }

    static int index(Character c){
        if(c == 'A') return 0;
        if(c == 'T') return 1;
        if(c == 'C') return 2;
        return 3;
    }

    static void init(){
        idx = 0;
        Arrays.fill(dar, 0);
        Arrays.fill(ne, 0);
        for(int i = 0; i < M; i++) {
            Arrays.fill(trie[i], 0);
            Arrays.fill(f[i], INF);
        }
    }
}
