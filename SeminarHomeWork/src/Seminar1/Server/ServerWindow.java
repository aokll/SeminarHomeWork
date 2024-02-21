package Seminar1.Server;

import Seminar1.Client.ClientWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ServerWindow extends JFrame{
    private static final int WINDOW_HEIGHT = 550; //высота окна
    private static final int WINDOWS_WIDTH = 410; //ширина окна
    private static final int WINDOWS_POSX = 500;
    private static final int WINDOWS_POSY = 0;
    List<ClientWindow> dataBaseClients;

    JPanel top = new JPanel();
    JPanel middle = new JPanel();
    JPanel footer = new JPanel();
    JTextArea jTextAreaTop = new JTextArea();
    JTextArea jTextAreaTopLose = new JTextArea();
    JButton jButtonFooterLeft = new JButton();
    JButton jButtonFooterRight = new JButton();
    JButton jButtonFooterMiddle = new JButton();
    ServerController serverController = new ServerController();



    public ServerWindow()
    {
        dataBaseClients = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOWS_POSX,WINDOWS_POSY);
        setSize(WINDOWS_WIDTH,WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);

        //размещение верхней области

        jTextAreaTop.setPreferredSize(new Dimension(380,300));
        jTextAreaTop.setEditable(false);
        jTextAreaTop.setLineWrap(true);


        top.add(jTextAreaTopLose);

        //размещение верхней области


        jTextAreaTopLose.setPreferredSize(new Dimension(380,100));
        jTextAreaTopLose.setEditable(false);
        jTextAreaTopLose.setLineWrap(true);


        middle.add(jTextAreaTop);
        //размещение внизу

        footer.setLayout(new GridLayout(1,3));
        jButtonFooterLeft.setText("Включить чат");
        jButtonFooterMiddle.setText("Выключить чат");
        jButtonFooterRight.setText("Выход");
        footer.add(jButtonFooterLeft);
        footer.add(jButtonFooterMiddle);
        footer.add(jButtonFooterRight);

        jButtonFooterRight.addActionListener(e->{
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        });


        add(top, BorderLayout.NORTH);
        add(middle,BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);


        setVisible(true);
    }
    public void Write(ClientWindow client, String nick, boolean flag) throws IOException {
        if (flag) {
            jTextAreaTop.append(nick + ": присоединился к чату" + "\n");
            serverController.getiServer().toWriteInFileLog(client.getName() + ": присоединился к чату" + "\n");
        }
        else {
            jTextAreaTop.append(nick + ": отсоединился от чата." + "\n");
            serverController.getiServer().toWriteInFileLog(nick + ": отсоединился от чата." + "\n");
        }
    }

    public void ChangeNick(ClientWindow client, String oldNick, String newNick) throws IOException {
        if (oldNick.equals("0")){
            jTextAreaTop.append(client.getName() + " Зарегистрировался под ником: [" + newNick + "]\n");
            serverController.getiServer().toWriteInFileLog(client.getName() + " Зарегистрировался под ником: [" + newNick + "]\n");
        }else{
            jTextAreaTop.append(client.getName() + " Сменил ник с ["+ oldNick +"] на [" + newNick + "]\n");
            serverController.getiServer().toWriteInFileLog(client.getName() + " Зарегистрировался под ником: [" + newNick + "]\n");
        }
    }
    public void Message(String text, String newNick) throws IOException {
        jTextAreaTop.append(newNick + " : [" + text + "]\n");
        serverController.getiServer().toWriteInFileLog(newNick + " : [" + text + "]\n");
    }
    public void printBD() throws IOException {
        jTextAreaTopLose.setText(null);
        for (ClientWindow c : dataBaseClients) {
            jTextAreaTopLose.append("данные интерфейса: " + c.getName() +
                    " ник: " + c.getNew_Nick() + "\n");
        }
    }
    public void connectUser(ClientWindow client){
        dataBaseClients.add(client);
    }
    public void removeClient(ClientWindow client){
        dataBaseClients.remove(client);
    }

    public void sendMessage(String mess, ClientWindow client){
        for (ClientWindow c : dataBaseClients) {
            c.message(c.getNew_Nick() + ": " + mess);
        }
    }

}














