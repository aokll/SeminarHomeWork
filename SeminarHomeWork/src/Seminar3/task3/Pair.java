package Seminar3.task3;

public class Pair<T,P> {
    private T First;
    private P Second;

    public Pair(T First, P Second) {
        this.First = First;
        this.Second = Second;
    }

    public T getFirst() {
        return First;
    }

    public P getSecond() {
        return Second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "First=" + First +
                ", Second=" + Second +
                '}';
    }
}
