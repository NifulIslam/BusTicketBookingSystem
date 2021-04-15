package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.*;

public class LogInPage {
    public User userInLogin;
    private FileInputStream fis  ;
    private ObjectInputStream ois  ;
    private void  getUser(){

        try {
            fis = new FileInputStream("G:\\spring 211\\advanced oop\\src\\sample\\UserInfo.txt");
            ois = new ObjectInputStream(fis);

            userInLogin = (User) ois.readObject();
            ois.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public void btnLogInActin(ActionEvent actionEvent) {
        Stage stage =Main.stage;
        Parent root = null;
        getUser();
        System.out.println("login page: "+userInLogin.type);
        System.out.println(userInLogin.type.equals("admin"));
        if(userInLogin.type.equals("admin")) {
            try {
                root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        }
        else  {
            try {
                root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        }

    }
}
