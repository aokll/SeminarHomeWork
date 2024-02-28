package Seminar5;

public class Main {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Fork leftFork = forks[i];
            Fork reghtFork = forks[(i + 1) % forks.length];

            philosophers[i] = new Philosopher(leftFork,reghtFork);

            Thread thread = new Thread(philosophers[i],"Philosorher[" + (i + 1) + "] ");

            thread.start();
        }

    }
}
