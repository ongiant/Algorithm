package acwing.basic_level.math.divisor;

import java.util.*;

public class DivisorsByTrialDivision_869 {

    public static void main(String[] args){

        Scanner sin = new Scanner(System.in);

        int n = sin.nextInt();
        while(n -- > 0){
            int x = sin.nextInt();
            TreeSet<Integer> result = getAllDivisors(x);
            for(int e : result) System.out.print(e + " ");
            System.out.println();
        }

        sin.close();
    }

    static TreeSet<Integer> getAllDivisors(int x){

        TreeSet<Integer> result = new TreeSet<>();

        for(int i = 1; i <= x / i; i ++){
            if(x % i == 0){
                result.add(i);
                if(i != x / i) result.add(x / i);
            }
        }
        return result;
    }
}
