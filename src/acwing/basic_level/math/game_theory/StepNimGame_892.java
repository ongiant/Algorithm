package acwing.basic_level.math.game_theory;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class StepNimGame_892 {

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        int res = 0;
        for(int i = 0; i < n; i ++){
            int a = sin.nextInt();
            if(i % 2 == 0) res ^= a;
        }
        if(res != 0) System.out.println("Yes");
        else System.out.println("No");

        sin.close();
    }
}
