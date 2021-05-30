
package sample.ServerUtil.grpchattemplate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MsgManager  {
    public static void write(String name , String msg){
        try{
            File file= new File("G:\\netbeans\\projects\\Aoop\\src\\grpchattemplate\\History.txt");
            FileWriter fw= new FileWriter(file, true);
            BufferedWriter bw= new BufferedWriter(fw);
            bw.write(name+":"+msg+"\n");
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String getMsg(String name){
        try{
            File file= new File("G:\\netbeans\\projects\\Aoop\\src\\grpchattemplate\\History.txt");
            FileReader fr= new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            String msg="";
            String line;
            while((line=br.readLine())!=null){
                
                    msg+=line+"\n";
                
            }
            br.close();
        return msg;    
        }
        catch(Exception e){
            e.printStackTrace();
            return "";
        }
        
    }
   
}
