package Seminar1.Client;

import Seminar1.Server.IServer;
import Seminar1.Server.ServerController;
import Seminar1.Server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RegistryClient extends JFrame{
    private boolean b;
    private String nick;
    private ServerWindow serverWindow;
    private IServer iServer;
    private final ClientWindow clientWindow;
    private static final int WINDOW_HEIGHT = 130; //высота окна
    private static final int WINDOWS_WIDTH = 250; //ширина окна
    private static final int WINDOWS_POSX = 510;
    private static final int WINDOWS_POSY = 200;
    JPanel top = new JPanel();
    JPanel footer = new JPanel();


    public RegistryClient(ServerWindow serverWindow, ClientWindow clientWindow) throws HeadlessException {
        this.serverWindow = serverWindow;
        this.clientWindow = clientWindow;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOWS_POSX, WINDOWS_POSY);
        setSize(WINDOWS_WIDTH, WINDOW_HEIGHT);
        setTitle("registry");
        setResizable(false);


        JLabel jLabel = new JLabel("введите свой ник");
        JTextField jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(80, 30));

        top.add(jLabel);
        top.add(jTextField);

        JButton ok = new JButton("OK");

        footer.add(ok);

        ok.addActionListener(e -> {

            if (clientWindow.isB() == true) {
                try {
                    setNick(jTextField.getText()); //записываем ник
                    WriteNickServer(getNick(),true);
                    clientWindow.setNew_Nick(getNick());//+
                    clientWindow.Write();//+
                    clientWindow.setB(false);//+
                    clientWindow.Change_Nick();
                    serverWindow.connectUser(clientWindow);
                    serverWindow.printBD();
                    setVisible(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        add(top, BorderLayout.NORTH);
        add(footer, BorderLayout.SOUTH);


        setVisible(true);
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public void WriteNickServer(String name,boolean flag) throws IOException {
        serverWindow.Write(clientWindow,name,true,iServer);
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}