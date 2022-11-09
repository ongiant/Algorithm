package acwing.basic_level.data_structure.kmp;

import java.util.*;
import java.io.*;

public class KmpStrings_831  {

    static final int N = 100010;
    static int[] next = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String p = br.readLine();
        p = " " + p;
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        s = " " + s;

        Arrays.fill(next, 0);
        // 构造next数组, next[j]表示模式串中j后面的那个字符失配时，我们需要用next[next[j]]+1位置上的字符进行匹配
        for(int i = 2, j = 0; i <=n; i++){
            while(j > 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];
            if(p.charAt(i) == p.charAt(j + 1)) j++;
            /**
             1、因为从第二个字符开始自匹配，所以j永远小于n
             2、想象在这两个自匹配的模式串上面再对应加上一个主文本串，就很容易理解邓俊辉老师课程中对kmp改进的思想了：
                  即我们用p[i+1]与主文本串进行匹配，如果失败了，那么根据普通的kmp算法，我们会继续拿p[j+1]来与主文本串匹配。
                  那么当p[i+1]与p[j+1]相同时，这次匹配其实是没必要的，可以直接跳过，即可以直接将next[i]赋值为next[j]而不是j
             */
            next[i] = i == n || p.charAt(i + 1) != p.charAt(j + 1) ? j : next[j];

            // 较之上面只优化一步，下面是优化多步的代码，不过效果不明显
//            int k = j; // 必须用一个新的变量，因为i自增后，第j+1个字符有可能继续匹配
//            while(i < n && k > 0 && p.charAt(i + 1) == p.charAt(k + 1)) k = next[k];
//            next[i] = k;
        }

        // 实现模式串与目标文本串的匹配过程
        for(int i = 1, j = 0; i <= m; i++){
            while(j > 0 && s.charAt(i) != p.charAt(j + 1)) j = next[j];
            if(s.charAt(i) == p.charAt(j + 1)) j++;
            if(j == n){
                bw.write(i - j + " ");
                /**
                 1、与邓俊辉的课程类似，我们在模式串最后加上一个假想的哨兵字符，并规定此哨兵字符与文本串中的任意字符均不匹配.
                    那么此处j=next[j]可以理解为模式串的哨兵字符失配时，你需要将next[j]与当前i对齐，那么随后就可以对next[j]+1与i+1进行字符匹配.
                    相当于提前执行了一次上面while的循环，节省了while循环的一个条件.
                 */
                j = next[j];
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
