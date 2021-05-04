package sample;

import javafx.scene.control.TextArea;

public class Tickets extends  Thread{
    private TextArea msgArea;

    public Tickets(TextArea msgArea) {
        this.msgArea = msgArea;
        Thread thread = new Thread(this ,"ticketThread");
        thread.start();
    }
    public void run(){
        while(true) {

            TicketManager.readMsg(msgArea);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("thread error");
            }
        }
    }
}
