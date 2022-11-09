package acwing.basic_level.data_structure.trie;

import java.util.*;
import java.io.*;

public class MaximumXORPair_143 {

    static int idx;
    static final int N = 100010, M = 32 * N;
    static int[] son[], a;

    static{
        son = new int[M][2];
        a = new int[N];
    }

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        int n = sin.nextInt(), res = 0;
        for(int i = 0; i < n; i++){
            a[i] = sin.nextInt();
            insert(a[i]);
            res = Math.max(res, a[i] ^ query(a[i]));
        }
        System.out.println(res);
        sin.close();
    }

    static void insert(int x){
        int p = 0;
        for(int i = 31; i >= 0; i--){
            int u = x >> i & 1;
            if(son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
    }

    static int query(int x){
        int p = 0, res = 0;
        for(int i = 31; i >= 0; i--){
            int u = x >> i & 1, t = u ^ 1;
            if(son[p][t] > 0) {
                res = (res << 1) + t;
                p = son[p][t];
            }
            else {// 因为是在main函数里先insert再查询，保证了此处无需再判断s[p][u]
                res = (res << 1) + u;
                p = son[p][u];
            }
        }
        return res;
    }
}
