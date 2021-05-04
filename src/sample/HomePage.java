package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class HomePage {
    public  static User user= new User("admin");
    private  FileOutputStream fos ;
    private ObjectOutputStream oos ;

    private   void setUser(String type){
        this.user.type= type;
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


    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnUser;

    @FXML
    void btnAdminAction(ActionEvent event) throws IOException {
    }

    @FXML
    void btnSignUpAction(ActionEvent event) {

    }

    @FXML
    void btnUserAction(ActionEvent event) {

    }

    public void btnAdminAction(javafx.event.ActionEvent actionEvent) {

       // setUser("admin");
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    }

    public void btnSignUpAction(javafx.event.ActionEvent actionEvent) {
        Stage stage =Main.stage;
        this.user= new User("consumer");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    }

    public void btnUserAction(javafx.event.ActionEvent actionEvent) {
        this.user= new User("consumer");

        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    }
}