package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class TicketManager {
    public  static void reset() throws IOException {
        removeTicket();
        removeClientTicket();
    }


    private static void removeClientTicket() throws  IOException{
        File file = new File( "G:\\spring 211\\advanced oop\\src\\sample\\clientTickets.txt");
        FileReader fr= new FileReader(file);
        BufferedReader br= new BufferedReader(fr);
        List lines = new LinkedList<String>();
        String line;
        while((line=br.readLine())!=null){
            lines.add(line);
        }
        br.close();
        FileWriter fw= new FileWriter(file);
        BufferedWriter bw= new BufferedWriter(fw);
        for(int i=0 ; i<lines.size(); i++){
            line= (String) lines.get(i);
            String[] parts = line.split(" ");
            bw.write(parts[0]+" _\n");
        }
        bw.close();

    }
    private static void removeTicket() throws IOException {
        File file = new File( "G:\\spring 211\\advanced oop\\src\\sample\\Tickets");
        FileReader fr= new FileReader(file);
        BufferedReader br= new BufferedReader(fr);
        List lines = new LinkedList<String>();
        String line;
        while((line=br.readLine())!=null){
            lines.add(line);
        }
        br.close();
        FileWriter fw= new FileWriter(file);
        BufferedWriter bw= new BufferedWriter(fw);
        for(int i=0 ; i<lines.size(); i++){
            line= (String) lines.get(i);
            if(line.contains("(B)")){
                line= line.replace("(B)", "(A)");
                bw.write(line+"\n");
                continue;
            }
            bw.write(line+"\n");

        }
        bw.close();
    }
    public static void addTicket(String name, String ticket) throws IOException {
        File file = new File("G:\\spring 211\\advanced oop\\src\\sample\\clientTickets.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br= new BufferedReader(fr);
        String line;
        ticket= ticket.toUpperCase();
        boolean found= false;
        List lines= new LinkedList<String>();
        while((line= br.readLine())!=null){
            lines.add(line);
        }

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw= new BufferedWriter(fw);
        for(int i=0; i<lines.size(); i++){
            line=  (String) lines.get(i);

            if(line.contains(name)){
                String newstr= line+ticket+",";
                bw.write(newstr+"\n");
                continue;
            }
            bw.write(line+"\n");
        }
        br.close();
        bw.close();
    }

    public static void addTickets(TextField ticketsUserProfile) throws IOException {
        File file = new File("G:\\spring 211\\advanced oop\\src\\sample\\clientTickets.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br= new BufferedReader(fr);
        String line;
        while((line= br.readLine())!=null){
            if(line.contains(HomePage.user.name)){
                String[] parts= line.split(" ");
                ticketsUserProfile.setText(parts[1]);
            }
        }
    }
    public static void readMsg(TextArea msgArea){
        File file=  new File("G:\\spring 211\\advanced oop\\src\\sample\\Tickets");
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
            System.out.println("io exception !");
            e.printStackTrace();
        }
    }
    public static boolean change(String name ) throws IOException{
        name= name.toUpperCase() +"(A)";
        File file = new File("G:\\spring 211\\advanced oop\\src\\sample\\Tickets");
        FileReader fr = new FileReader(file);
        BufferedReader br= new BufferedReader(fr);

        String line;
        boolean found= false;
        List lines= new LinkedList<String>();
        while((line= br.readLine())!=null){
            lines.add(line);
        }

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw= new BufferedWriter(fw);

        for(int i=0; i<lines.size(); i++){
            line=  (String) lines.get(i);

            if(line.contains(name)){

                String newstr= line.replace(name,name.replace("(A)", "(B)") );
                bw.write(newstr+"\n");



                found=true;
                continue;
            }
            bw.write(line+"\n");
        }
        br.close();
        bw.close();
        return found;
    }

}
