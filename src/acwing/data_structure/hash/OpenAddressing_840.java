package acwing.data_structure.hash;

import java.io.*;
import java.util.*;

public class OpenAddressing_840 {

    static final int N = 200003, inf = 0x3f3f3f3f;
    static int[] h = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(h, inf);
        while(n-- > 0){
            String s = br.readLine();
            String command = s.substring(0, 1);
            int x = Integer.parseInt(s.substring(2));
            int hashcode = find(x);
            if("I".equals(command)){
                h[hashcode] = x;
            }
            else{
                if(h[hashcode] != x){
                    System.out.println("No");
                }
                else{
                    System.out.println("Yes");
                }
            }
        }
    }

    static int find(int x){
        int hashcode = (x % N + N) % N;
        while(h[hashcode] != inf && h[hashcode] != x){
            hashcode++;
            if(hashcode == N) hashcode = 0;
        }
        return hashcode;
    }
}
