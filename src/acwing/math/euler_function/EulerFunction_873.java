package acwing.math.euler_function;

import java.util.*;

public class EulerFunction_873 {

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);

        int n = sin.nextInt();

        while(n -- > 0){
            int a = sin.nextInt();
            System.out.println(eulerFunc(a));
        }
        sin.close();
    }

    static int eulerFunc(int x){
        int result = x;
        for(int i = 2; i <= x / i; i ++){
            if(x % i == 0){
                result = result / i * (i - 1);
                while(x % i == 0) x /= i;
            }
        }
        if(x > 1) result = result / x * (x - 1);
        return result;
    }
}
