package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class UserProfilePage implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            TicketManager.addTickets(ticketsUserProfile);
        } catch (IOException ioException) {
            System.out.println("exception while adding tickets");
        }
    }
    @FXML
    private TextField ticketsUserProfile;
    User user;
    private FileInputStream fis  ;
    private ObjectInputStream ois  ;
    private void  getUser(){

        try {
            fis = new FileInputStream("G:\\spring 211\\advanced oop\\src\\sample\\UserInfo.txt");
            ois = new ObjectInputStream(fis);

            user = (User) ois.readObject();
            ois.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    {
        getUser();




    }


    private  void setUserPageLabelName(){
      //  UserPageLabelName.setTextContent(user.name);
      //  UserPageLabelName.setData(user.name);
    }


    @FXML
    private Text UserPageLabelName;
    public void btnLogOutAction(ActionEvent actionEvent) {
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();

    }

    public void btnExpandAction(ActionEvent actionEvent) {
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MessagePage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();

    }

    public void btnUserBackPage(ActionEvent actionEvent) {
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();

    }


}
