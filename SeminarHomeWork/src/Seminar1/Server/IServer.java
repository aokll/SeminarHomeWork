package Seminar1.Server;

import Seminar1.Client.ClientWindow;

import java.io.IOException;

public interface IServer {
    void toWriteInFileLog(String text) throws IOException;
}
