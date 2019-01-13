package onlyPack;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

public class Client implements Runnable {
    Socket socket;

    @Override
    public void run() {
        try {
            Scanner sc=new Scanner(System.in);

            while (true) {

                System.out.println("Wybierz komende:");
                String command=sc.nextLine();

                if(command.equals("add") || command.equals("show") || command.startsWith("file")) {
                    Socket s = new Socket("localhost", 60016);
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

                    out.write(command);
                    out.newLine();
                    out.flush();

                    if(command.startsWith("file")) {

                        InputStream in = s.getInputStream();
                        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int byteToBeRead = -1;


                        final File folder = new File("./Pobrane");
                        File newFile=new File(folder.getAbsolutePath()+File.separator+new Date().getTime());
                        FileOutputStream fs = new FileOutputStream(newFile);
                        while((byteToBeRead = in.read())!=-1){
                            //System.out.println(byteToBeRead);
                            fs.write(byteToBeRead);
                        }

                        fs.flush();
                        fs.close();
                    }

                    //s.close();

                }else if(command.equals("exit")) {
                    break;
                }

                Thread.sleep(200);
            }

            sc.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
