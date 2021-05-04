package sample;

import javafx.scene.control.TextArea;

class Msg extends  Thread{
    private TextArea msgArea;

    public Msg(TextArea msgArea) {
        this.msgArea = msgArea;
        Thread thread = new Thread(this ,"msgThread");
        thread.start();
    }
    public void run(){
        while(true) {

            MsgManager.readMsg(msgArea);
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                System.out.println("thread error");
            }
        }
    }
}