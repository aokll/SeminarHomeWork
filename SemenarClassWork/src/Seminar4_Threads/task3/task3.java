package Seminar4_Threads.task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/*Задание 3
В рамках выполнения задачи необходимо:
● 3 бегуна должны прийти к старту гонки
● Программа должна гарантировать, что гонка начнется только когда все три
участника будут на старте
● Программа должна отсчитать “На старт”, “Внимание”, “Марш”
● Программа должна завершиться когда все участники закончат гонку.
● Подумайте об использовании примитива синхронизации */
public class task3 implements Runnable{
    private String name;
    private CountDownLatch cdl;

    public task3(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
    }
    @Override
    public void run() {
        try {
            goToStart();
            cdl.await();// будем ждать пока значение этого счетчика не станет = 0.
            //и после этого все стартуют
            running();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void goToStart() throws InterruptedException {
        System.out.println(name + " идет к старту");
        Thread.sleep(1000 + new Random().nextInt(2000));
        System.out.println(name + " подошел к старту");
        cdl.countDown();//метод который уменьшает значение указанное вначале на 1.
    }

    private void running() throws InterruptedException {
        System.out.println(name + " стратовал");
        Thread.sleep(1000 + new Random().nextInt(2000));
        System.out.println(name + " финишировал");
    }
}
