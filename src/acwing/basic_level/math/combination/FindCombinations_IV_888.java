package acwing.basic_level.math.combination;

import java.util.Scanner;
import java.util.ArrayList;

public class FindCombinations_IV_888 {

    static final int N = 5010;

    static int cnt;
    static int[] primes;
    static boolean[] st;

    static {
        primes = new int[N];
        st = new boolean[N];

        linearSieve(N - 1);
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        int a = sin.nextInt(), b = sin.nextInt();
        ArrayList<Integer> ans = getResult(a, b);
        for(int i = ans.size() - 1; i >= 0; i --){
            System.out.print(ans.get(i));
        }

        sin.close();
    }

    static ArrayList<Integer> getResult(int a, int b){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        for(int i = 0; i < cnt; i ++){
            int amount = count(a, primes[i]) - count(b, primes[i]) - count(a - b, primes[i]);
            multiply(list, qmi(primes[i], amount));
        }

        return list;
    }

    static void multiply(ArrayList<Integer> list, int x){
        int t = 0;
        for(int i = 0; i < list.size(); i ++){
            t += list.get(i) * x;
            list.set(i, t % 10);
            t /= 10;
        }
        while(t > 0){
            list.add(t % 10);
            t /= 10;
        }
    }

    static int qmi(int a, int k){
        int res = 1;
        while(k > 0){
            if((k & 1) == 1) res *= a;
            k >>= 1;
            a *= a;
        }
        return res;
    }

    // 统计a的阶乘里有多少个质数p
    static int count(int a, int p){
        int res = 0;
        while(a > 0){
            res += a / p;
            a /= p;
        }
        return res;
    }

    static void linearSieve(int n){
        for(int i = 2; i <= n; i ++){
            if(!st[i]) primes[cnt ++] = i;
            for(int j = 0; primes[j] <= n / i; j ++){
                st[i * primes[j]] = true;
                if(i % primes[j] == 0) break;
            }
        }
    }
}
