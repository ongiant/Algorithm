package acwing.basic_level.data_structure.hash;

import java.io.*;
import java.util.Arrays;

public class AnalogHashTables_840 {

    static final int N = 100003;
    static int[] h, e, ne;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[N];
        ne = new int[N];


        while(n-- > 0){
            String s = br.readLine();
            String command = s.substring(0, 1);
            int x = Integer.parseInt(s.substring(2));
            if("I".equals(command)){
                insert(x);
            }
            else{
                if(find(x)){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
        }

        br.close();
    }

    static void insert(int x){
        if(find(x)) return;
        int hashCode = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[hashCode];
        h[hashCode] = idx++;
    }

    static boolean find(int x){
        int hashCode = (x % N + N) % N;
        for(int i=h[hashCode]; i!=-1; i = ne[i]){
            if(e[i] == x){
                return true;
            }
        }
        return false;
    }
}
