package acwing.middle_level.dp.model.longest_ascending_subsequence;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class InterceptingMissiles_1010 {

    static final int N = 1010;
    static int n, q[], f[], g[];
    static{
        q = new int[N];
        f = new int[N];
        g = new int[N];
    }

    private static class StringTokenizerPlus extends StringTokenizer {

        public StringTokenizerPlus(String str) {
            super(str);
        }

        public Integer nextInt(){
            return Integer.parseInt(this.nextToken());
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizerPlus sin = new StringTokenizerPlus(br.readLine());

        while(sin.hasMoreTokens()) q[n ++] = sin.nextInt();

        int res = 0, cnt = 0;
        for(int i = 0; i < n; i ++){
            f[i] = 1;
            for(int j = 0; j < i; j ++){
                if(q[i] <= q[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            res = Math.max(res, f[i]);

            int k = 0;
            while(k < cnt && g[k] < q[i]) k ++;
            g[k] = q[i];
            if(k >= cnt) cnt ++;
        }

        System.out.printf("%d\n%d", res, cnt);
        br.close();
    }
}
