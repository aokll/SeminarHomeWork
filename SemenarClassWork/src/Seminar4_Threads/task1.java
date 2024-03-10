package Seminar4_Threads;
/*Задание 1
В рамках выполнения задачи необходимо:
● Создать два класс ObjectA, ObjectB
● Реализовать класс в котором два потока при запуске провоцируют DeadLock для
объектов ObjectA, ObjectB*/
public class task1{

    public static void main(String[] args) {
    Thread threadB = new Thread();
    Thread threadA = new Thread();

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (threadA){
                    System.out.println("обьект А заблокирован, ожидаем обьект В");
                    synchronized (threadB){
                        System.out.println("Обьект В заблокирован");
                    }
                }
            }
        });
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (threadB) {
                    System.out.println("обьект B заблокирован, ожидаем обьект A");
                    synchronized (threadA) {
                        System.out.println("Обьект A заблокирован");
                    }
                }
            }
        });
        firstThread.start();
        secondThread.start();
    }
}
