package Seminar6.Model;

public interface ILead {
    void startThePresentation(IBlackBox iBlackBox, int x);
    void finish(IBlackBox iBlackBox, int x);
    String[] getGetDoor();
    String[] getDoor();
}
