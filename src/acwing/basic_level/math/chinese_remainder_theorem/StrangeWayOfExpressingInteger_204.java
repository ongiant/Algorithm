package acwing.basic_level.math.chinese_remainder_theorem;

import java.util.*;

public class StrangeWayOfExpressingInteger_204 {

    static long[] x, y;

    static{
        x = new long[1];
        y = new long[1];
    }

    public static void main(String[] args){

        Scanner sin = new Scanner(System.in);

        long n = sin.nextLong(), m1 = sin.nextLong(), a1 = sin.nextLong();

        boolean hasAnswer = true;
        while(n -- > 1){
            long m2 = sin.nextLong(), a2 = sin.nextLong();
            long d = exgcd(m1, m2, x, y);

            if((a2 - a1) % d != 0){
                hasAnswer = false;
                break;
            }

            /**
             * 不能写成x[0] = x[0] / d * (a2 - a1);
             * 因为上面的if语句只保证(a2 - a1) / d 结果为整数
             * 当x[0]不是d的倍数时，更改顺序会导致计算结果错误
             */
            x[0] *= (a2 - a1) / d;
            long t = Math.abs(m2 / d);
            x[0] = (x[0] % t + t) % t; // 将x[0]取道一个较小的正整数


            a1 += x[0] * m1;
            m1 = Math.abs(m1 / d * m2);
        }

        if(hasAnswer) System.out.println((a1 % m1 + m1) % m1);
        else System.out.println(-1);

        sin.close();
    }

    static long exgcd(long a, long b, long[] x, long[] y){
        if(b == 0){
            x[0] = 1;
            y[0] = 0;
            return a;
        }
        long d = exgcd(b, a % b, y, x);
        y[0] -= a / b * x[0];
        return d;
    }
}
