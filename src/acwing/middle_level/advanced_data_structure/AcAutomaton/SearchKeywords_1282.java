package acwing.middle_level.advanced_data_structure.AcAutomaton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class SearchKeywords_1282 {

    static final int N = 100 * 100 + 10, L = 55, M = 1000 * 1000 + 10;
    static int[] tr[], cnt, ne, q;
    static int idx, hh, tt;

    static{
        tr = new int[N * L][26];
        cnt = new int[N * L];

        ne = new int[N * L];

        q = new int[N * L];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            init();

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i ++){
                insert(br.readLine());
            }
            String str = br.readLine().trim();

            build();

            int ans = 0;
            for(int i = 0, j = 0; i < str.length(); i++){
                int x = str.charAt(i) - 'a';
                while(j != 0 && tr[j][x] == 0) {
                    j = ne[j];
                }
                if(tr[j][x] != 0) j = tr[j][x];

                int p = j;
                while(p != 0){
                    ans += cnt[p];
                    cnt[p] = 0;
                    p = ne[p];
                }
            }
            System.out.println(ans);
        }

        br.close();
    }

    static void build(){
        hh = 0;
        tt = -1;

        for(int i = 0; i < 26; i++){
            if(tr[0][i] != 0){
                q[++tt] = tr[0][i];
            }
        }

        while(hh <= tt){
            int x = q[hh++];
            for(int i = 0; i < 26; i ++){
                int y = tr[x][i];
                if(y == 0) continue;

                int z = ne[x];
                while(z != 0 && tr[z][i] == 0){
                    z = ne[z];
                }

                if(tr[z][i] != 0) z = tr[z][i];
                ne[y] = z;

                q[++tt] = y;
            }
        }
    }

    static void insert(String s){
        int r = 0;
        for(int i = 0; i < s.length(); i++){
            int x = s.charAt(i) - 'a';
            if(tr[r][x] == 0) tr[r][x] = ++idx;
            r = tr[r][x];
        }
        cnt[r]++;
    }

    static void init(){
        idx = 0;
        for(int i = 0; i < N * L; i++){
            Arrays.fill(tr[i], 0);
        }
        Arrays.fill(cnt, 0);
        Arrays.fill(ne, 0);
    }
}
