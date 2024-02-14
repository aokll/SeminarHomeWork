package Seminar1.Client;

import Seminar1.Server.Server;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RegistryClient_1 extends JFrame{
    private boolean b;
    private String nick;
    private final Server server;
    private final Client client;
    private static final int WINDOW_HEIGHT = 130; //высота окна
    private static final int WINDOWS_WIDTH = 250; //ширина окна
    private static final int WINDOWS_POSX = 510;
    private static final int WINDOWS_POSY = 200;
    JPanel top = new JPanel();
    JPanel footer = new JPanel();


    public RegistryClient_1(Server server, Client client) throws HeadlessException {

        this.server = server;
        this.client = client;

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

            if (client.isB() == true) {
                try {
                setNick(jTextField.getText());
                WriteNickServer(getNick(), server,true);
                client.setNew_Nick(getNick());
                client.Write();
                client.setB(false);
                client.Change_Nick();
                server.connectUser(client);
                server.printBD();
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

    public void WriteNickServer(String name, Server server, boolean flag) throws IOException {
        server.Write(client,getName(),true);
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}
