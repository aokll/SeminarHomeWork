package Seminar4_Threads.task3;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch cdl = new CountDownLatch(4);

        Thread t1 = new Thread(new task3("Иван",cdl));
        Thread t2 = new Thread(new task3("Николай",cdl));
        Thread t3 = new Thread(new task3("Павел",cdl));

        t1.start();
        t2.start();
        t3.start();

        while (cdl.getCount() > 1){
            Thread.sleep(100);
        }

        System.out.println("На старт");
        Thread.sleep(500);
        System.out.println("Внимание");
        Thread.sleep(500);
        System.out.println("Марш");
        cdl.countDown();
    }
}
