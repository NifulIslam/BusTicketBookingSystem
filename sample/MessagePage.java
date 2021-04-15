package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MessagePage {
    public User userInMsg;
    private FileInputStream fis;
    private ObjectInputStream ois;

    private void getUser() {

        try {
            fis = new FileInputStream("G:\\spring 211\\advanced oop\\src\\sample\\UserInfo.txt");
            ois = new ObjectInputStream(fis);

            userInMsg = (User) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void btnBackAction(ActionEvent actionEvent) {
        getUser();
        if (userInMsg.type.equals("admin")) {
            Stage stage = Main.stage;
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        }


    else{
        Stage stage = Main.stage;
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
}
