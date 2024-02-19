package Seminar1;

import Seminar1.Client.ClientWindow;
import Seminar1.Server.ServerWindow;

public class Main {
    public static void main(String[] args) {
       ServerWindow server = new ServerWindow();

       ClientWindow client1 = new ClientWindow("client1", server);
       ClientWindow client2 = new ClientWindow("client2", server);



    }
}