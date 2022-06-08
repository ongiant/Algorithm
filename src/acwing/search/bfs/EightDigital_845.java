package acwing.search.bfs;

import java.io.*;
import java.util.*;

public class EightDigital_845 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sn = br.readLine().split(" ");
        StringBuilder sr = new StringBuilder();
        for(String t : sn){
            sr.append(t);
        }

        System.out.println(bfs(sr.toString()));

        br.close();
    }

    static int bfs(String start){
        String target = "12345678x";
        LinkedList<String> q = new LinkedList<>();
        HashMap<String, Integer> d = new HashMap<>();
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

        d.put(start, 0);
        q.offer(start);

        while(q.size() > 0){

            String s = q.poll();
            int distance = d.get(s);
            if(target.equals(s)) return distance;

            int k = s.indexOf('x');
            int x = k / 3, y = k % 3;

            StringBuilder sbr = new StringBuilder(s);
            for(int i = 0; i < 4; i++){
                int a = x + dx[i], b = y + dy[i];
                if(a >= 0 && a < 3 && b >= 0 && b < 3){
                    exch(sbr, k, 3 * a + b);
                    if(!d.containsKey(sbr.toString())){
                        d.put(sbr.toString(), distance + 1); //
                        q.offer(sbr.toString()); //
                    }
                    exch(sbr, k, 3 * a + b);
                }
            }
        }

        return -1;
    }

    static void exch(StringBuilder s, int i, int j){
        char c = s.charAt(i);
        s.replace(i, i + 1, String.valueOf(s.charAt(j)));
        s.replace(j, j + 1, String.valueOf(c));
    }
}
