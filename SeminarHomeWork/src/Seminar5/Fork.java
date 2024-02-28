package Seminar5;

public class Fork {
    private boolean flag;

    public boolean put(){
        flag = true;
        return flag;
    }
    public boolean take(){
        flag = false;
        return flag;
    }
}
