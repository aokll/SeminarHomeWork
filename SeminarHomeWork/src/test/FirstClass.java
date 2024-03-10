package test;

public class FirstClass implements IFirst{

    private ISecond iSecond;
    public FirstClass() {
        this.iSecond = new SecondClass();
    }

    @Override
    public String printFirst() {
        return "First";
    }
    @Override
    public void x() {
        System.out.println(iSecond.printSec());
    }
}
