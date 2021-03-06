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
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPage implements Initializable {
    Msg msg;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUserPageLabelName();
        Msg msg= new Msg(msgArea);
        new Tickets(ticketsTAusers);

    }
    @FXML
    private TextArea ticketsTAusers;
    @FXML
    private TextArea msgArea;
    @FXML
    private Text UserPageLabelName;
    private void setUserPageLabelName(){

        UserPageLabelName.setText(HomePage.user.name);
    }


    @FXML
    private TextField TfBus5Desc;

  public void btnSaveAdminAction(ActionEvent actionEvent){
      
   }
    public void btnCancelBusAction(ActionEvent actionEvent) throws IOException {
        TicketManager.reset();
    }
    public void btnLogOutAction(ActionEvent actionEvent) {
      //  msg.stop();
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
       // msg.stop();
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

}
