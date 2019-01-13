package main;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isCorrect = false;
        Scanner reader;
        System.out.println("Select Mode: H2H,MH");
        String mode = "";
        String protocol = "";
        int serverPort1;
        int serverPort2;
        while(!isCorrect) {
            reader = new Scanner(System.in);
            mode = reader.next();
            System.out.println(mode);
            if (mode.equals("H2H") ) {
                isCorrect = true;
            } else if (mode.equals("MH")) {
                isCorrect = true;
            } else {
                System.out.println("Wrong mode, Select again: H2H,MH");
                isCorrect = false;
            }
        }
        isCorrect = false;
        while(!isCorrect){
            System.out.println("Select Protocol: TCP,UDP");
            reader = new Scanner(System.in);
            protocol = reader.next();
            if (protocol.equals("TCP")) {
                isCorrect = true;
            } else if (protocol.equals("UDP")) {
                isCorrect = true;
            } else {
                System.out.println("Wrong protocol, Select again: TCP,UDP");
                isCorrect = false;
            }
        }
        if(mode == "H2H" && protocol == "TCP"){
            System.out.println("Select server port for host1");
            reader = new Scanner(System.in);
            serverPort1 = reader.nextInt();
            System.out.println("Select server port for host2");
            reader = new Scanner(System.in);
            serverPort2 = reader.nextInt();


        }else if(mode == "MH" && protocol == "TCP"){

        }else if(mode == "H2H" && protocol == "UDP"){

        }else if(mode == "MH" && protocol == "UDP"){

        }else{
            System.out.println("Error");
        }

    }
}
