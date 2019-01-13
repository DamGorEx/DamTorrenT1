package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private ServerSocket servsocket;
    private Socket socket;
    private String msg;

    public Server(int port) throws IOException {
        servsocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = servsocket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                while (!socket.isClosed() && (msg = in.readLine()) != null) {
                    if (msg.equals("PULL")) {
                        System.out.println("Mock:PULL");
                    } else if (msg.equals("SHOW")) {
                        System.out.println("Mock:SHOW");
                    } else if (msg.startsWith("file")) {
                        System.out.println("Mock:file");
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Polaczenie nieudane");
        }
    }
}
