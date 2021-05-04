package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ssocket = new ServerSocket(1234);
        System.out.println("server started");
        while(true){
            Socket socket = ssocket.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            if(TicketManager.change((String)ois.readObject())){
                oos.writeObject("ok");
            }
            else{
                oos.writeObject("no");
            }
            socket.close();

        }
    }

}
