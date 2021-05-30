package sample.ServerUtil.grpchattemplate;



import sample.ServerUtil.util.NetworkUtil;

import java.util.Iterator;
import java.util.Map;

public class ServerSocketHandlerThread implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    private String name;
    String name2 ;

    public ServerSocketHandlerThread(NetworkUtil nc, String name) {
        this.nc = nc;
        this.name= name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                String s = (String) nc.read();
                MsgManager.write(name, s);
                if (s.equals("$EXIT$")) {
                    nc.closeConnection();
                    break;
                };
                System.out.println(s);
                Iterator hmIterator = Server.hash.entrySet().iterator();

                while (hmIterator.hasNext()) {
                    Map.Entry mapElement = (Map.Entry)hmIterator.next();
                    name2 = (String) (mapElement.getKey());
                    if(name2!=name){
                        NetworkUtil nc2=(NetworkUtil) mapElement.getValue();
                        nc2.write(name+": "+s);
                    }


                }



            }
        } catch (Exception e) {
            System.out.println(e);
        }
        nc.closeConnection();
    }
}



