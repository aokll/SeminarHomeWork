package Seminar5;

/*Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
Вилки лежат на столе между каждой парой ближайших философов.
Каждый философ может либо есть, либо размышлять.
Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
Можно брать только две вилки одновременно
Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

какждый философ должен поесть 3 раза, как только все философы покушают - программа закрывается.

//вилки - volotile?
* */

import java.util.Random;

public class Philosopher implements Runnable{
   private  static boolean b;
   private volatile static int i;
   private Fork leftFork;
   private Fork reghtFork;

   public Philosopher(Fork leftFork, Fork reghtFork) {
      this.leftFork = leftFork;
      this.reghtFork = reghtFork;
   }

   private boolean count(){
      if (i >= 3){return false;}
      i++;
      return true;
   }
   private void doAction(String action) throws InterruptedException {
      System.out.println(Thread.currentThread().getName() + action);
      Thread.sleep((int) (Math.random() * 1000));
   }
   @Override
   public void run() {
      try {
         while (true){
            doAction("Думает");
            synchronized (leftFork){
               doAction("взял левую вилку i = [" + i + "]");
               if (b = false){Thread.currentThread().join();}
               leftFork.take();
               synchronized (reghtFork){
                  doAction("взял правую вилку и ест");
                  b = reghtFork.take();
                  System.out.println("...процесс поедания...");
                  Thread.sleep(3000);
                  doAction("положил правую вилку i = [" + i + "]");
                  b = reghtFork.put();

               }
               b = false;
               leftFork.put();
               boolean bool = count();
               if (!bool){
                  System.out.println("философ наелся");
                  Thread.currentThread().interrupt();
               }
               doAction("положил левую вилку - размышляет i = [" + i + "]" + b);
            }
         }
      }catch (InterruptedException e){
         Thread.currentThread().interrupt();
         return;
      }
   }
}
