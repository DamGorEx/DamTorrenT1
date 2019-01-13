package onlyPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class TrackerThread_TCP extends Thread {
    ServerSocket socket;
    Tracker tracker = Tracker.getTracker();
    @Override
    public void run() {
        try {
            socket = new ServerSocket(60016);

            while(true){
                Socket client = socket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                String line = null;
                while (!client.isClosed() && (line = in.readLine()) != null) {
                    if(line.equals("PULL")) {


                    }else if(line.equals("SHOW")) {
                        tracker.showFiles();
                    }else if(line.startsWith("file")) {
                        int fileNumber=Integer.parseInt(line.split(" ")[1]);
                        //in.close();

                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
