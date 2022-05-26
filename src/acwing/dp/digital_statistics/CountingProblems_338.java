package acwing.dp.digital_statistics;

import java.io.*;
import java.util.*;

public class CountingProblems_338 {

    static LinkedList<Integer> num;

    static int get(LinkedList<Integer> num, int l, int r){
        int k = 0;
        while(l >= r){
            k = k * 10 + num.get(l--);
        }
        return k;
    }

    static int power10(int x){
        int k = 1;
        while(x-- > 0) k *= 10;
        return k;
    }

    static int count(int n, int x){
        if(n == 0) return 0;

        num = new LinkedList<>();
        while(n > 0){
            num.add(n % 10);
            n /= 10;
        }

        n = num.size();
        int ans = 0;
        for(int i = x == 0 ? n-2 : n-1; i>=0; i--){
            if(i < n - 1){
                ans += get(num, n-1, i + 1) * power10(i);
                if(x == 0) ans -= power10(i);
            }
            if(num.get(i) == x){
                ans += get(num, i - 1, 0) + 1;
            }
            else if(num.get(i) > x){
                ans += power10(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a, b ;
        while((a = sin.nextInt()) != 0 && (b = sin.nextInt()) != 0){

            if(a > b) {
                int t = a;
                a = b;
                b = t;
            }

            for(int i=0; i<10; i++){
                bw.write((count(b, i) - count(a - 1, i)) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        sin.close();
        bw.close();
    }
}
