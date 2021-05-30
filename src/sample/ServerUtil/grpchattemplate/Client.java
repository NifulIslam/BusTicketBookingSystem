package sample.ServerUtil.grpchattemplate;

import sample.ServerUtil.util.NetworkUtil;

public class Client {
	public static void main(String args[]) {
		try {
			String serverAddress = "127.0.0.1";
			int serverPort = 8080;
			NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);
			new ClientReaderThread(nc);
			new ClientWriterThread(nc,"Client");
		} catch(Exception e) {
			System.out.println (e);
		}
	}
}

