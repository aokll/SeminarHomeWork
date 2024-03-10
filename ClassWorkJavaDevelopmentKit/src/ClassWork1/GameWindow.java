package ClassWork1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 350;
    private static final int WINDOWS_WIDTH = 300;
    private static final int WINDOWS_POSX = 500;
    private static final int WINDOWS_POSY = 200;

    JButton newGame = new JButton("New Game");
    JButton exit = new JButton("Exit");
            Map map;
            SittingsWindows sittingsWindows;
    public GameWindow() throws HeadlessException
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOWS_POSX,WINDOWS_POSY);
        setSize(WINDOWS_WIDTH,WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);


        JPanel jPanel = new JPanel(new GridLayout(1,2));
        jPanel.add(newGame);
        jPanel.add(exit);
        add(jPanel,BorderLayout.SOUTH);

        map = new Map();
        sittingsWindows = new SittingsWindows(this);

        add(map);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sittingsWindows.setVisible(true);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
    void startNewGame(int mode, int fSzX, int fSzY, int wLength){
        map.startNewGame(mode, fSzX, fSzY, wLength);
    }
}
