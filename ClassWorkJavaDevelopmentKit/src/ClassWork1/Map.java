package ClassWork1;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public Map() {
        setBackground(Color.BLACK);
    }
    void startNewGame(int mode, int fSzX, int fSzY, int wLength){
        System.out.printf("Mode - %d;/n Size x = %d, y = %d;/n Win length - %d",mode,fSzX,fSzY,wLength);
    }
}
