package acwing.dp.tree;

import java.util.*;

public class DancePartyWithoutBoss_285 {
    static final int N = 6010;
    static int[] w, flag;
    static LinkedList<LinkedList<Integer>> son;
    static int[][] f;

    static {
        w = new int[N];
        flag = new int[N];
        f = new int[N][2];
        son = new LinkedList<>();
        for(int i=0; i<N; i++){
            son.add(new LinkedList<>());
        }
    }

    static void dp(int x){
        f[x][0] = 0;
        f[x][1] = w[x];
        for(int i=0; i<son.get(x).size(); i++){
            int y = son.get(x).get(i);
            dp(y);
            f[x][0] += Math.max(f[y][0], f[y][1]);
            f[x][1] += f[y][0];
        }
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        for(int i=1; i<=n; i++){
            w[i] = sin.nextInt();
        }
        for(int i=1; i<n; i++){
            int a = sin.nextInt(), b = sin.nextInt();
            son.get(b).add(a);
            flag[a] = 1;
        }

        int root = 0;
        for(int i=1; i<=n; i++){
            if(flag[i] == 0){
                root = i;
                break;
            }
        }

        dp(root);
        System.out.println(Math.max(f[root][0], f[root][1]));

        sin.close();
    }
}
