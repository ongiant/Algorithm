package acwing.math.combination;

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class FindTheNumberOfCombinations_I_885 {

    static final int N = 2010, mod = 1000000000 + 7;
    static int[][] c;

    static {
        c = new int[N][N];
    }

    public static void main(String[] args) throws IOException{
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();

        int n = sin.nextInt();
        while(n -- > 0){
            int a = sin.nextInt(), b = sin.nextInt();
            bw.write(c[a][b] + "\n");
        }

        sin.close();
        bw.close();
    }

    static void init(){
        for(int i = 0; i < N; i ++){
            for(int j = 0; j <= i; j ++){
                if(j == 0) c[i][j] = 1;
                else c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
            }
        }
    }
}
