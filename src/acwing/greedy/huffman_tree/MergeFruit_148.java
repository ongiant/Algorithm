package acwing.greedy.huffman_tree;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.PriorityQueue;

public class MergeFruit_148 {

    static PriorityQueue<Integer> heap;
    static{
        heap = new PriorityQueue<>();
    }

    public static void main(String[] args){
        Scanner sin = new Scanner(new BufferedInputStream(System.in));

        int n = sin.nextInt();
        while(n -- > 0){
            heap.offer(sin.nextInt());
        }

        int res = 0;
        while(heap.size() > 1){
            int x = heap.poll(), y = heap.poll();
            res += x + y;
            heap.offer(x + y);
        }
        System.out.println(res);
        sin.close();
    }
}
