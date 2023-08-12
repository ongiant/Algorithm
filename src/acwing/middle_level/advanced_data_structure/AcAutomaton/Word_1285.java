package acwing.middle_level.advanced_data_structure.AcAutomaton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Word_1285 {

    static final int R = 1000 * 1000 + 10, S = 26, J = 210;
    static int trie[][], cnt[], id[], ne[], idx;
    static int q[], hh, tt;

    static{
        trie = new int[R][S];
        cnt = new int[R];
        id = new int[J];
        ne = new int[R];

        q = new int[R];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            insert(br.readLine(), i);
        }

        build();

        for(int i = idx - 1; i >= 0; i--){
            cnt[ne[q[i]]] += cnt[q[i]];
        }

        for(int i = 0; i < n; i++){
            System.out.println(cnt[id[i]]);
        }

        br.close();
    }

    static void build(){
        hh = 0;
        tt = -1;
        for(int i = 0; i < 26; i++){
            if(trie[0][i] != 0){
                q[++tt] = trie[0][i];
            }
        }

        while(hh <= tt){
            int p = q[hh++];
            for(int i = 0; i < 26; i++){
                int s = trie[p][i];
                if(s == 0) trie[p][i] = trie[ne[p]][i];
                else{
                    ne[s] = trie[ne[p]][i];
                    q[++tt] = s;
                }
            }
        }
    }

    static void insert(String s, int x){
        int p = 0;
        for(int i = 0; i < s.length(); i ++){
            int t = s.charAt(i) - 'a';
            if(trie[p][t] == 0) trie[p][t] = ++idx;
            p = trie[p][t];
            cnt[p] ++;
        }
        id[x] = p;
    }
}
