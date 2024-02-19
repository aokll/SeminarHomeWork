package Seminar1.Client;

import Seminar1.Server.ServerController;
import Seminar1.Server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClientWindow extends JFrame {
    private String newNick;
    private String oldNick = "0";
    private boolean b = true;
    private String name;


    private static final int WINDOW_HEIGHT = 400; //высота окна
    private static final int WINDOWS_WIDTH = 330; //ширина окна
    private static final int WINDOWS_POSX = 50;
    private static final int WINDOWS_POSY = 200;
    private ServerWindow server;
    private RegistryClient registry;


    JPanel top = new JPanel();
    JPanel middle = new JPanel();
    JPanel footer = new JPanel();
    JTextArea jTextAreaTop = new JTextArea();
    JLabel jLabelMiddle = new JLabel();
    JTextField jTextFieldMiddle = new JTextField();
    JButton jButtonMiddle = new JButton();
    JButton jButtonFooterLeft = new JButton();
    JButton jButtonFooterRight = new JButton();


    public ClientWindow(String name, ServerWindow server) {
        this.server = server;
        this.name = name;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOWS_POSX, WINDOWS_POSY);
        setSize(WINDOWS_WIDTH, WINDOW_HEIGHT);
        setTitle(name);
        setResizable(false);

        //размещение верхней области

        jTextAreaTop.setPreferredSize(new Dimension(300, 200));
        jTextAreaTop.setEditable(false);
        jTextAreaTop.setLineWrap(true);
        top.add(jTextAreaTop);

        //размещение в середине

        jLabelMiddle.setText("Введите текст сообщения: ");
        jLabelMiddle.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextFieldMiddle.setPreferredSize(new Dimension(150, 30));
        jButtonMiddle.setText("Отправить");
        jButtonMiddle.setPreferredSize(new Dimension(110, 20));

        jButtonMiddle.addActionListener(e -> {
            String jTextFieldMiddleText = jTextFieldMiddle.getText();
            server.sendMessage(jTextFieldMiddleText, this);
            try {
                server.Message(jTextFieldMiddleText, getNew_Nick());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            jTextFieldMiddle.setText("");
        });

        middle.add(jLabelMiddle);
        middle.add(jTextFieldMiddle);
        middle.add(jButtonMiddle);

        //размещение внизу

        footer.setLayout(new GridLayout(1, 2));
        jButtonFooterLeft.setText("Войти в чат");
        jButtonFooterRight.setText("Выйти из чата");
        footer.add(jButtonFooterLeft);
        footer.add(jButtonFooterRight);


        jButtonFooterLeft.addActionListener(e -> {
            if (isB() == true) {
                registry = new RegistryClient(server, this);
            } else jTextAreaTop.append("Вы уже вошли в чат" + "\n");
        });

        jButtonFooterRight.addActionListener(e -> {
            if (isB() == false) {
                try {
                    jTextAreaTop.append("Вы вышли из чата, удачи!" + "\n");
                    setB(true);
                    setOld_Nick(getNew_Nick());
                    server.Write(this, getNew_Nick(), false);
                    server.removeClient(this);
                    server.printBD();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                jTextAreaTop.append("Вы уже вышли из чата" + "\n");
            }
        });


        add(top, BorderLayout.NORTH);
        add(middle, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);


        setVisible(true);
    }

    void Change_Nick() throws IOException {
        if (getOld_Nick().equals("0")) {
            server.ChangeNick(this, "0", getNew_Nick());
        } else {
            server.ChangeNick(this, getOld_Nick(), getNew_Nick());
        }
    }

    public void message(String mess) {
        jTextAreaTop.append(mess + "\n");
    }

    void Write(String name) {
        jTextAreaTop.append(name + ": присоединился к чату" + "\n");
    }

    void Write() {
        jTextAreaTop.append("Привет! Ты присоединился к чату" + "\n");
    }


    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public void setNew_Nick(String newNick) {
        this.newNick = newNick;
    }

    public String getNew_Nick() {
        return newNick;
    }

    public void setOld_Nick(String oldNick) {
        this.oldNick = oldNick;
    }

    public String getOld_Nick() {
        return oldNick;
    }

    @Override
    public String getName() {
        return name;
    }
}