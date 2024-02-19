package Seminar1;

import Seminar1.Client.Client;
import Seminar1.Server.Server;

public class Main {
    public static void main(String[] args) {
       Server server = new Server();

       Client client1 = new Client("client1", server);
       Client client2 = new Client("client2", server);



    }
}