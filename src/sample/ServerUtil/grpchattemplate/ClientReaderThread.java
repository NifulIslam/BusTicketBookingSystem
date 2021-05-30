package sample.ServerUtil.grpchattemplate;
import sample.ServerUtil.util.NetworkUtil;

public class ClientReaderThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;

	public ClientReaderThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			while(true) {
				String s=(String)nc.read();
				System.out.println(s);
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}



