package acwing;

import java.io.*;
import java.util.*;

public class ZipperMethod_799 {

    static final int N = 100003;
    static int idx = 0;

    static int[] h = new int[N], e = new int[N], ne = new int[N], a;


    public static void main(String[] args) throws IOException{
        Arrays.fill(h, -1);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sin = new Scanner(new BufferedInputStream(System.in));// 不能两个输入流同时使用，原因不明

//        int n = Integer.parseInt(br.readLine());

        int n = sin.nextInt();

        a = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sin.nextInt();
        }

        int ans = 0;
        for(int i=0, j=0; i<n; i++){
            while(find(a[i])){
                delete(a[j++]);
            }
            insert(a[i]);
            ans = Math.max(ans, i - j + 1);
        }
        System.out.println(ans);
        sin.close();
    }

    static boolean find(int x){
        int hashcode = (x % N + N) % N;
        for(int i = h[hashcode]; i!=-1; i = ne[i]){
            if(e[i] == x){
                return true;
            }
        }
        return false;
    }

    static void insert(int x){
        if(find(x)) return;
        int hashcode = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[hashcode];
        h[hashcode] = idx++;
    }

    static void delete(int x){
        int hashcode = (x % N + N) % N;

        if(h[hashcode] == -1) return;
        if(ne[h[hashcode]] == -1){
            h[hashcode] = ne[h[hashcode]];
            return;
        }

        for(int i = h[hashcode]; ne[i]!=-1; i = ne[i]){
            if(e[ne[i]] == x){
                ne[i] = ne[ne[i]];
                break;
            }
        }
    }
}
