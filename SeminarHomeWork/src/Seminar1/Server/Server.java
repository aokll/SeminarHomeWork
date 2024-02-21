package Seminar1.Server;

import java.io.FileWriter;
import java.io.IOException;

public class Server implements IServer{

    public void toWriteInFileLog(String text) throws IOException {
        String fileLogCreationPath = "src//Seminar1//fileLog.txt";

        try (
                FileWriter fileWriter = new FileWriter(fileLogCreationPath,true);
        ){
            fileWriter.write(text);

        }
    }

}
