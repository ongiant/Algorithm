package acwing.basic_level.basic.difference;

import java.io.*;
import java.util.*;

public class DifferenceMatrix_798 {
    static final int N = 1010;
    static int[][] a = new int[N][N];
    static int[][] b = new int[N][N];

    static void insert(int x1, int y1, int x2, int y2, int c){
        b[x1][y1] += c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[]  args) throws IOException {
        Scanner sin = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = sin.nextInt(), m = sin.nextInt(), q = sin.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                a[i][j] = sin.nextInt();
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                insert(i, j, i, j, a[i][j]);
            }
        }

        while(q-- > 0){
            int x1 = sin.nextInt(), y1 = sin.nextInt(), x2 = sin.nextInt(), y2 = sin.nextInt(), c = sin.nextInt();
            insert(x1, y1, x2, y2, c);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                b[i][j] += b[i -1][j] + b[i][j - 1] - b[i - 1][j - 1];
                /**
                 * 注意，不要写成以下形式：
                 * bw.write(b[i][j]);
                 * bw.write(" ");
                 *
                 * (可能是因为两次写入的参数类型不一致)会导致输出有问题
                 */
                bw.write(b[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        sin.close();
        bw.close();
    }
}
