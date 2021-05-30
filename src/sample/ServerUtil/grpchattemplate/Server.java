package sample.ServerUtil.grpchattemplate;

import sample.ServerUtil.util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class Server {

	private ServerSocket ServSock;
	private int nConnectedClient;
        public String name;
        public static Hashtable<String, NetworkUtil> hash= new Hashtable<String, NetworkUtil>();
	Server() {
		nConnectedClient = 0;
		try {
			ServSock = new ServerSocket(8080);
			while (true) {
				Socket clientSock = ServSock.accept();
				NetworkUtil nc = new NetworkUtil(clientSock);
                                name= "client"+(++nConnectedClient);
                                hash.put(name, nc);
				nc.write("hello "+name);
                                nc.write("history");
                                nc.write(MsgManager.getMsg(name));
				new ServerSocketHandlerThread(nc,name);
				
			}
		} catch (Exception e) {
			System.out.println("Server starts:" + e);
		}
	}

	public static void main(String args[]) {
		Server objServer = new Server();
	}
}
