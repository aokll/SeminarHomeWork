package ClassWork1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SittingsWindows extends JFrame {
    private static final int WINDOW_HEIGHT = 200;
    private static final int WINDOWS_WIDTH = 200;
    JButton start = new JButton("Start new game");
    public SittingsWindows(GameWindow gameWindow) throws HeadlessException
    {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOWS_WIDTH,WINDOW_HEIGHT);

        add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0,3,3,3);
                setVisible(false);
            }
        });
    }
}
