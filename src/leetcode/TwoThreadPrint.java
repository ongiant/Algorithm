package leetcode;

import java.util.concurrent.Semaphore;

public class TwoThreadPrint {

    public static void main(String[] args){
        Semaphore s1 = new Semaphore(1), s2 = new Semaphore(0);

        Thread t1 = new Thread(() -> {
            int x = 100;
            while(x -- > 0){
                try{
                    s1.acquire();
                    System.out.print('A');
                    s2.release();
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            int x = 100;
            while(x -- > 0){
                try{
                    s2.acquire();
                    System.out.print('B');
                    s1.release();
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }
}
