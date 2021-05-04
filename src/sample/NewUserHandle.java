package sample;

import java.io.*;

public class NewUserHandle {
    private  User user= new User();
    private static File file = new File("G:\\spring 211\\advanced oop\\src\\sample\\Users.txt");
    public static void createNewUser(String name, String pass){
        try {
            BufferedWriter bw= new BufferedWriter(new FileWriter(file, true));
            String data= name+" " + pass+ " " + "0 0 0 0 0";
            bw.write(data);
            bw.newLine();
            bw.close();
            File file2 = new File("G:\\spring 211\\advanced oop\\src\\sample\\clientTickets.txt");
            FileWriter fw = new FileWriter(file2,true);
            BufferedWriter bw1= new BufferedWriter(fw);
            String line= name +" _";
            bw1.write(line+"\n");
            bw1.close();

        }

        catch (IOException e){
            System.out.println("file not found");
        }
    }
    public static boolean isValidName(String name){
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null){
                String parts[]= line.split(" ");
                if(parts[0].equals(name) ){
                    br.close();
                    return false;
                }
            }
            br.close();
            return true;
        }
        catch (IOException e){

            return true;
        }
    }
    public static boolean isValidUser(String name, String pass){
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null){
                String parts[]= line.split(" ");
                if(parts[0].equals(name) && parts[1].equals(pass) ){
                    br.close();
                    return true;
                }
            }
            br.close();
            return false;
        }
        catch (IOException e){

            return false;
        }
    }

}
