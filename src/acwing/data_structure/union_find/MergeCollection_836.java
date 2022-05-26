package acwing.data_structure.union_find;

import java.io.*;
import java.util.*;

public class MergeCollection_836 {

    static int[] p;
    static final int N = 100010;

    static{
        p = new int[N];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);

        for(int i=1; i<=n; i++){
            p[i] = i;
        }

        while(m-- > 0){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[1]), b = Integer.parseInt(s[2]);
            int ra = find(a), rb = find(b);
            if("M".equals(s[0])){
                if(ra != rb){
                    p[ra] = rb;
                }
            }
            else{
                if(ra == rb){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
        }

        br.close();
    }

    static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
