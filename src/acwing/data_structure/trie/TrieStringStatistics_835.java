package acwing.data_structure.trie;

import java.io.*;

public class TrieStringStatistics_835 {

    static int idx;
    static final int N = 100010;
    static int[] son[], cnt;

    static{
        son = new int[N][26];
        cnt = new int[N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            String[] in = br.readLine().split(" ");
            if("I".equals(in[0])) insert(in[1]);
            else bw.write(query(in[1]) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void insert(String s){
        int p = 0;
        for(int i = 0; i < s.length(); i++){
            int u = s.charAt(i) - 'a';
            if(son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }

    static int query(String s){
        int p = 0;
        for(int i = 0; i < s.length(); i++){
            int u = s.charAt(i) - 'a';
            if(son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
}
