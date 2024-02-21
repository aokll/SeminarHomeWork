package Seminar1.Server;

import Seminar1.Client.ClientWindow;

import java.io.IOException;

public class ServerController {
    private final Server server = new Server();

    IServer iServer = new IServer() {
        @Override
        public void toWriteInFileLog(String text) throws IOException {
            server.toWriteInFileLog(text);
        }
    };

    public IServer getiServer() {
        return iServer;
    }
}
