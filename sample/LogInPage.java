package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class LogInPage {
    @FXML
    private TextField LogIntfUserName;

    @FXML
    private PasswordField LogIntfPassword;
    @FXML
    private Label LogInLabelNotifi;

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
        if(userInLogin.type.equals("admin")) {
            if (AdminHandle.isValidUser(LogIntfUserName.getText(), LogIntfPassword.getText())) {
                try {
                    root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setScene(new javafx.scene.Scene(root));
                stage.show();
            }
            else{
                LogInLabelNotifi.setText("invalid username or password");
            }
        }

        else {

            if (NewUserHandle.isValidUser(LogIntfUserName.getText(), LogIntfPassword.getText())) {

                try {
                    root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setScene(new javafx.scene.Scene(root));
                stage.show();
            }
            else{
                LogInLabelNotifi.setText("invalid username or password");
            }
        }


    }
}