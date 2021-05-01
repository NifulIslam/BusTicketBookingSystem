package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MessagePage implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUserPageLabelName();
        Msg msg= new Msg(msgArea);
       // msgArea.setEditable(false);
    }
    @FXML
    private Text UserPageLabelName;
    private void setUserPageLabelName(){ UserPageLabelName.setText(HomePage.user.name); }

    @FXML
    private TextField msgFieldMsg;
    @FXML
    private TextArea msgArea;
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
    public void btnSendAction(ActionEvent actionEvent){
        MsgManager.writeMsg(msgFieldMsg.getText());
        msgFieldMsg.setText("");
        MsgManager.readMsg(msgArea);

    }
    public void btnBackAction(ActionEvent actionEvent) {
        getUser();

        if (HomePage.user.type.equals("admin")) {

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