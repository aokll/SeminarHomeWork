package Seminar4_Threads;
/*Задание 2
В рамках выполнения задачи необходимо:
● Создайте два потока A и B.
● Поток A меняет значение Boolean переменной switcher с задержкой 1000
миллисекунд (true в состояние false и наоборот).
● Поток B ожидает состояния true переменной switcher и выводит на консоль
обратный отсчет от 100 с задержкой 100 миллисекунд и приостанавливает свое
действие, как только поток A переключит switcher в состояние false.
● Условием завершения работы потоков является достижение отсчета нулевой
отметки.
● Можно воспользоваться синхронизацией для управления значения переменной или
volatile */
public class task2 {
    public static volatile boolean switcher;//если переменную пометить как volotile то каждый поток
    //будет вынужден возвращаться сюда и брать его значение.
    //sinchronozed - расстовление очередности потоков
    //volotile - управление памятью
    public static boolean flag = true;
    public static void main(String[] args) {


        Thread A = new Thread(()->{
            System.out.println("поток А начался");
            while (flag) {
                switcher = !switcher;
                try {
                    System.out.println("задержка 1000 началась");
                    Thread.sleep(1000);
                    System.out.println("состояние" + switcher);
                    System.out.println("задержка прошла");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("поток А закончился");
        });

        Thread B = new Thread(()->{
            System.out.println("поток В начался");
            int count = 100;
            while (count > 0){
                if (switcher){
                System.out.println(count--);
                    try {
                        Thread.sleep(100);
                        System.out.println("состояние" + switcher);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            flag = false;
            System.out.println("поток В закончился");
        });
        A.start();
        B.start();



    }
}
