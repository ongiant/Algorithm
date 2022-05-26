package acwing.data_structure.union_find;

import java.io.*;

public class TheNumberOfPointsInTheConnectedBlock_837 {

    static final int N = 100010;

    static int[] p, size;

    static {
        p = new int[N];
        size = new int[N];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);

        for(int i=1; i<=n; i++){
            p[i] = i;
            size[i] = 1;
        }

        while(m-- > 0){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[1]);

            if("C".equals(s[0])){
                int b = Integer.parseInt(s[2]);
                int ra = find(a), rb = find(b);
                if(ra != rb){
                    p[ra] = rb;
                    size[rb] += size[ra];
                }
            }
            else if("Q1".equals(s[0])){
                int b = Integer.parseInt(s[2]);
                if(find(a) == find(b)) {
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
            else{

                System.out.println(size[find(a)]);
            }
        }
    }

    static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
