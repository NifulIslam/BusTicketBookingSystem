package sample;

import javafx.scene.control.TextArea;

import java.io.*;

public class MsgManager {
    private static File file = new File("G:\\spring 211\\advanced oop\\src\\sample\\consumerMsg.txt");
    public static void writeMsg(String text){
        String data= HomePage.user.name +": "+ text;
        write(data);
    }
    public static void readMsg(TextArea msgArea){
        if(HomePage.user.type.equals("admin")){file= new File("G:\\spring 211\\advanced oop\\src\\sample\\adminMsg.txt"); }
        else{file= new File("G:\\spring 211\\advanced oop\\src\\sample\\consumerMsg.txt");}
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            String line;
            msgArea.setText("");
            while ((line=br.readLine())!=null){
                msgArea.appendText(line+"\n");


            }
            br.close();

        }
        catch (IOException e){

            e.printStackTrace();
        }
    }
    private static  void write(String data ){
        try {
            if(HomePage.user.type.equals("admin")){file= new File("G:\\spring 211\\advanced oop\\src\\sample\\adminMsg.txt"); }
            else{file= new File("G:\\spring 211\\advanced oop\\src\\sample\\consumerMsg.txt");}
            BufferedWriter bw= new BufferedWriter(new FileWriter(file, true));
            bw.write(data);
            bw.newLine();
            bw.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
