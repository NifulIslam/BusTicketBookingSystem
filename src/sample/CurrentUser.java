package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CurrentUser {
    public User user =new User();
    private FileOutputStream fos ;
    private ObjectOutputStream oos ;

    public CurrentUser(User user) {
        this.user = user;
        write();
    }


    public CurrentUser() {
        write();
    }
    private FileInputStream fis;
    private ObjectInputStream ois;
    private void read(){
        try {
            fis = new FileInputStream("G:\\spring 211\\advanced oop\\src\\sample\\UserInfo.txt");
            ois = new ObjectInputStream(fis);

            user = (User) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public User  getUser() {
        read();
        return  user;
    }
    private  void  write(){
        try {
            fos = new FileOutputStream("G:\\spring 211\\advanced oop\\src\\sample\\UserInfo.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setUserType(String type){
        this.user.type= type;
        write();

    }
}
