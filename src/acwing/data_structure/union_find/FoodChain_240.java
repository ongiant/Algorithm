package acwing.data_structure.union_find;

import java.io.*;

public class FoodChain_240 {

    static final int N = 100010;
    static int[] p, d;

    static {
        p = new int[N];
        d = new int[N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);

        for(int i=1; i<=n; i++){
            p[i] = i;
        }

        int ans = 0;
        while(k-- > 0){
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[1]), y = Integer.parseInt(s[2]);
            int rx = find(x), ry = find(y);
            if(x > n || y > n){
                ans++;
            }
            else if("1".equals(s[0])){
                if(rx == ry && (d[x] - d[y]) % 3 != 0) {
                    ans++;
                }
                // 同一个树里的两个节点之间的关系通过并查集维护， 可以直接得出两者的食物链关系
                else if(rx != ry) { // x与y在两个集合中，表明这两者之间的关系尚未维护
                    p[rx] = ry;
                    d[rx] = d[y] - d[x];
                }
            }
            else{
                if(rx == ry && (d[x] - d[y] -1) % 3 != 0){
                    ans++;
                }
                else if(rx != ry){
                    p[rx] = ry;
                    d[rx] = d[y] + 1 - d[x];
                }
            }
        }
        System.out.println(ans);
    }

    static int find(int x){
        if(p[x] == x) return x;

        int t = find(p[x]);
        d[x] += d[p[x]];
        p[x] = t;
        return p[x];
    }
}
