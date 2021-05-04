package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AdminHandle {
    private static File file = new File("G:\\spring 211\\advanced oop\\src\\sample\\Admins.txt");
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
