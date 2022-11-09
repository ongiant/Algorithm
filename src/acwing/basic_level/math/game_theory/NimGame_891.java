package acwing.basic_level.math.game_theory;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class NimGame_891 {

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt(), res = 0;
        while(n -- > 0){
            int x = sin.nextInt();
            res ^= x;
        }
        if(res == 0) System.out.println("No");
        else System.out.println("Yes");

        sin.close();
    }
}
