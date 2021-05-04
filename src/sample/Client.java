package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
    public static boolean buy(String ticket) throws UnknownHostException, IOException, ClassNotFoundException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream  ois= new ObjectInputStream(socket.getInputStream());
        oos.writeObject(ticket);
        if(((String)ois.readObject()).equals("ok")){
            socket.close();
            return true;
        }
        socket.close();
        return false;



    }
}
