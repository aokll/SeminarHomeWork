package Seminar6.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BlackBox implements IBlackBox {

    Car car = new Car();
    Goat goat = new Goat();
    private String[] box;

    public BlackBox() {

        this.box = new String[3];
    }
    @Override
    public void blackBox(){
        int[] arr = new int[]{1,2,3};

        List<Integer> res = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));
        Collections.shuffle(res);

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == 1){
                box[i] = car.toString();
            } else if (res.get(i) == 2){
                box[i] = goat.toString();
            }if (res.get(i) == 3){
                box[i] = goat.toString();
            }
        }
    }

    public String[] getBox() {
        return box;
    }
}
