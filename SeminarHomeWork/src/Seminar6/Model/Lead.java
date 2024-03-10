package Seminar6.Model;


import Seminar6.Model.IBlackBox;

public class Lead implements ILead{
    private String[] door = new String[]{"closed door[1] ","closed door[2] ","closed door[3] "};
    private String[] getDoor = new String[3];

    public void startThePresentation(IBlackBox iBlackBox, int x){

        if (iBlackBox.getBox()[x].equals("Машина")){
            for (int i = 0; i < iBlackBox.getBox().length ; i++) {
                if (iBlackBox.getBox()[i].equals("Коза")){
                    door[i] = iBlackBox.getBox()[i];
                    break;
                }
            }
        } else if (iBlackBox.getBox()[x].equals("Коза")) {
            for (int i = 0; i < iBlackBox.getBox().length ; i++) {
                if (iBlackBox.getBox()[i].equals("Коза") && i != x){
                    door[i] = iBlackBox.getBox()[i];
                    break;
                }
            }
        }
        for (int i = 0; i < door.length; i++) {
            getDoor[i] = door[i];
        }
    }

    public void finish(IBlackBox iBlackBox, int x){
        if (iBlackBox.getBox()[x].equals("Машина")){
            getDoor[x] = "Машина";
        } else if (iBlackBox.getBox()[x].equals("Коза")) {
            getDoor[x] = "Коза";
        }
    }

    public String[] getGetDoor() {
        return getDoor;
    }

    public String[] getDoor() {
        return door;
    }
}
